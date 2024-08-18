import java.util.*;

public class stack {
        public static int PostfixExpression(String str){
            int N= str.length();
            Stack<Integer> s=new Stack<>();
            for(int i=0;i<N;i++){
                char c=str.charAt(i);
                if(Character.isDigit(c)){
                    s.push(c- '0');
                }

                else{
                    int val2=s.pop();
                    int val1=s.pop();

                    switch(c){
                        case '+':
                            s.push(val1 + val2);
                            break;

                        case '-':
                            s.push(val1 - val2);
                            break;  
                            
                       case '*':
                        s.push(val1 * val2);
                        break;    
                        
                        case '/':
                            s.push(val1 / val2);
                            break;
                    }
                }
            }
            return s.pop();
        }
    

    public static void main(String args[]){
        String str="231*+9-";

        System.out.println(PostfixExpression(str));
    }
}
