import java.util.Stack;

public class NextSmallest {
    public static int[] Solution(int [] arr){
        int N=arr.length;

        int ans[]=new int[N];

        Stack<Integer> St=new Stack<>();
        
        St.push(arr[N-1]);
        ans[N-1]=-1;

        for(int i=N-2;i>=0;i--){
            
            while(!St.isEmpty() && arr[i]<=St.peek()){
                St.pop();
            }
            if(St.isEmpty()){
                ans[i]=-1;
                St.push(arr[i]);
            }
            if(St.peek()<arr[i]){
                ans[i]=St.peek();
                St.push(arr[i]);
            }
          }
            
            return ans;
    }
    public static void main(String args[]){
        int arr[]={13,7,6,12};

        int res[]=Solution(arr);

        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
