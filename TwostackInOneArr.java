public class TwoStackInarray {
       static int arr[];
        static int top1;
       static  int top2;
      static  int size;

        TwoStackInarray(int s){
            this.size=s;
            top1=-1;
            top2=s-1;
            arr=new int[s];
        }
        public static void push1(int x){
            if(top2-top1>1){
                top1++;
                arr[top1]=x;
            }
            else{
                System.out.println("stack overflow"+" "+x);
            }
        }
        public static void push2(int y){
            if(top2-top1>1){
                arr[top1]=y;
                top2--;
            }
            else{
                System.out.println("stack overflow"+" "+y);
            }
        }
        public static int pop1(){
            if(top1>=0){
                int ans=arr[top1--];
                return ans;
            }
            else{
                return -1;
            }
        }
        public static int pop2(){
            if(top2<=size){
                int ans=arr[top2++];
                return ans;
            }
            else{
                return -1;
            }
        
        }

    public static void main(String args[]){
        TwoStackInarray st=new TwoStackInarray(5);
        st.push1(5);
        st.push1(11);
        // st.push1(3);

        st.push2(10);
        st.push2(15);
        st.push2(7);
        st.push2(40);

        st.pop1();
        st.pop2();

    }
}

