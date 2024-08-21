import java.util.*;
public class SatackPermutation {
    public static boolean CheckPermutation(int[] in,int[] op,int n){

        //Queue for Input
        Queue<Integer> input=new LinkedList<>();
        for(int i=0;i<n;i++){
            input.add(in[i]);
        }

        //Queue for output
        Queue<Integer> output=new LinkedList<>();
        for(int i=0;i<n;i++){
            output.add(op[i]);
        }

        Stack<Integer> st=new Stack<>();
        
        while(!input.isEmpty()){

            int ele=input.poll();

            if(ele==output.peek()){
                output.poll();
                while(!st.isEmpty()){
                    if(st.peek()==output.peek()){
                        st.pop();
                        output.remove();
                    }
                    else{
                        break;
                    }
                }
            }
            else{

                st.push(ele);
            }
        }
        return (st.isEmpty() && input.isEmpty());
    }
    
    //optimization code without using Queue
    public static boolean Sol(int in[],int op[],int n){
        Stack<Integer> st=new Stack<Integer>();
        //push all input value in stack
        int j=0;
        for(int i=0;i<n;i++){
            st.push(in[i]);
            while(!st.isEmpty() && st.peek()==op[j]){
                st.pop();
                j++;
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;

    }
    
    public static void main(String args[]){
        int input[]={1,2,3};
        // int output[]={3,1,2};
        int output[]={2,1,3};
        int n=3;

    //    boolean res= CheckPermutation(input,output,n);

       boolean res= Sol(input,output,n);
       if(res==true){
        System.out.println("1");
       }
       else{
           System.out.println("0");
    }
}
}
