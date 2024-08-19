import java.util.*;

public class ValidString{
    public static int Solution(String Str){
        int strlen=Str.length();
        if(strlen==0){
            System.out.println("empty String");
            return -1;
        }

        int validStrLen=0;
        Stack<Character> st=new Stack<>();

        for(int i=0;i<strlen;i++){
            char c=Str.charAt(i);

            if(c=='('){
                st.push(c);
            }

            else{
                if(!st.isEmpty() && c==')' && st.peek() == '('){
                    st.pop();
                    validStrLen=validStrLen+2;;
                }

            }
        }

            return validStrLen;
        }
    

    public static void main(String args[]){
        // String str="(((()";
        // String str = "((()()";
       String str = "()(()))))()";
        System.out.println(Solution(str));
    }
}
