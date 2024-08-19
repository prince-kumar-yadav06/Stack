import java.util.*;
public class InfixToPrefix {
    public static int precedence(char c){
        if(c=='^'){
            return 3;
        }
        else if(c=='/' || c=='*'){
            return 2;
        }
       else if(c=='+' || c=='-'){
            return 1;
        }
        else{
            return -1;
        }
    }

    
    public static void infToPre(String str){
        StringBuilder res=new StringBuilder();
        Stack<Character> st=new Stack<>();

        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if((c>='a' && c<='z')  || (c>='A' && c<='Z') || (c>='0'  && c<='9')){
                res.append(c);
            }
            else if(c=='('){
                st.push(c);
            }
            else if(c==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    res.append(st.pop());
                    // st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && (precedence(str.charAt(i))<precedence(st.peek()) || precedence(str.charAt(i))==precedence(st.peek()))){
                    res.append(st.pop());
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            res.append(st.pop());
            // st.pop();
        }
        System.out.println(res);
    }
    public static void main(String args[]){
        // String str="A+B*C+D";
        String str="((A+B)-C*(D/E))+F";

        infToPre(str);
    }
}
