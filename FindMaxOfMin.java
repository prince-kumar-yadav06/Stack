import java.util.*;

public class FindMaxOfMin {
    

            // using 3 loop that's why T.C=O(n^3)
    // public static int[] solution(int arr[]){
    //     int N=arr.length;

    //     int ans[]=new int[N];

        
    //     for(int i=0;i<N;i++){
    //         for(int j=0;j<N-i;j++){

    //             int num=Integer.MAX_VALUE;

    //             for(int k=j;k<j+i+1;k++){
    //                 num=Math.min(num,arr[k]);
    //             }
    //             ans[i]=Math.max(num, ans[i]);
    //         }
    //     }
    //     return ans;

    
    // using stack 

    public static int[] solution(int arr[]){

        int N=arr.length;

        Stack<Integer> st=new Stack<>();

        int ans[]=new int[N];

        for(int i=0;i<N;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                int index=st.peek();
                st.pop();

                if(st.isEmpty()){
                    // i jo next right smallest hoga
                    int range=i;
                    ans[range-1]=Math.max(arr[range-1],arr[index]);
                }
                else{
                    int range=i-st.peek()-1;
                    ans[range-1]=Math.max(ans[range-1],arr[index]);
                }
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int index=st.peek();
            st.pop();            

            if(st.isEmpty()){
                int range=N;
                ans[range-1]=Math.max(ans[range-1],arr[index]);
            }
            else{
                int range=N-st.peek()-1;
                ans[range-1]=Math.max(ans[range-1],arr[index]);
            }
        }

        for(int i=N-2;i>=0;i--){
            ans[i]=Math.max(ans[i],ans[i+1]);
        }
        return ans;
    }
 
    public static void main(String args[]){
        int arr[]={10,20,30,50,10,70,30};
        
        int res[]=solution(arr);
        
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}

