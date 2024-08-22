import java.util.*;
public class celebrity {
    public static int Solution(int[][] mat,int n){
        //step 1 push all index in stack
        Stack<Integer> st=new Stack();

        for(int i=0;i<n;i++){
            st.push(i);
        }
// step2 pop top 2 element and jo dusro nhi janat usko phir se stack me push kr de 
        while(st.size()>1){
            int top1=st.pop();
            int top2=st.pop();

            if(CheckKnow(mat,top1,top2)){
                st.push(top2);
            }
            else{
                st.push(top1);
            }
        }
        int ans=st.peek();

        // check value of ans is celebrity or not 

        // row ans pr if zero hai n ke equal to celebrity ho skta hai es row pe 
        
        int rowcount=0;
        for(int i=0;i<n;i++){
            if(mat[ans][i]==0){
                rowcount++;
            }
        }
        // check for row pr zero hai ya nhi 
        if(rowcount!=n){
            return -1;
        }
        
        int colcount=0;
        for(int i=0;i<n;i++){
            if(mat[i][ans]==1){
                colcount++;
            }
        }
        // check for col pr 1 hai ya nhi n-1 ke equal 
        if(colcount!=n-1){
            return -1;
        }
        return ans;

    }
        //check function
        public static Boolean CheckKnow(int[][] mat,int top1,int top2){
            if(mat[top1][top2]==1){
                return true;
            }
            else{
                return false;
            }
        }
        public static void main(String args[]){
            int mat[][]={{0,1,0},
                        {0,1,0},
                        {0,0,0}};

            int mat1[][]={{0,1},
                        {1,0}};
            
            int N=mat.length;

            System.out.println(Solution(mat, N));
        }

}
