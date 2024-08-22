public class NextGreaterElement {
    public static void solution(int arr[],int N){

        int next;
        int j;

        for(int i=0;i<=N;i++){
            next=-1;
            for( j=i+1;j<=N;j++){
                if(arr[j]>arr[i]){
                    next=arr[j];
                    break;
                }
            }
            System.out.println(arr[i]+":"+next);
        }
    }
    public static void main(String args[]){
        int []arr={4,5,2,25};
        solution(arr,arr.length-1);
    }
}
