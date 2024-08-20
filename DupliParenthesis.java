import java.util.*;
public class DupliParenthesis {
    public static boolean Solution(String str){
        Stack<Character> st=new Stack();
        int sizeStr=str.length();
        
        for(int i=0;i<sizeStr;i++){
            char c=str.charAt(i);
            if(c=='(' || c=='+' || c=='-' || c=='*' || c=='/' ){
                st.push(c);
            }
            
            boolean redundant=true;
            if(c==')'){

                while(st.peek()!='('){
                    char top=st.peek();

                    if(top=='+' || top=='-' || top=='*' || top=='/'){
                        redundant=false;
                    }
                    st.pop();
                } 
                if(redundant==true){
                    return true;
                }
                st.pop();
            }
        }
        return false;
    }
    public static void main(String args[]){
        String str="(a+b)";
        // String str="(((a+(b)))+(c+d))";
      boolean ans=  Solution(str);
      if(ans==true){
        System.out.println("Duplicate Exist");
      }
      else{
        System.out.println("Duplicate Doesn't Exits");
      }

    }
}
