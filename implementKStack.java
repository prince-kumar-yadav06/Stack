public class ImplementKStack {
     static class arrayConstructer{
      static int[] top;
     static int[] arr;
     static int[] next;
         static  int freespace;
        
        arrayConstructer(int S,int N){
            this.arr=new int[N];
            this.top=new int[S];
            this.next=new int[N];
            this.freespace=0;

            // intialize top with -1 
            for(int i=0;i<S;i++){
                top[i]=-1;
            }

            //next ko intialize kre as free 
            for(int i=0;i<N-1;i++){
                next[i]=i+1;

                next[N-1]=-1; // that  -1  indicate end of free list
            }
        }
    

    // x is value and m is stack number
    public static void Push(int X,int M){

        // check stack is over flow or not
        if(freespace==-1){
            System.out.println("Stack is overflow");
            return;
        }

        // step 1 find index
        int index=freespace;

        // step 2 update freespace to next coming  element at index
        freespace=next[index];

        //step 3 push X at in arr
        arr[index]=X;

        // step 4 update next 
        next[index]=top[M];

        //step update top
        top[M]=index;
        System.out.println("Stack:"+M+" Element:"+arr[top[M]]);

    }


    // for pop write the same step of push from step 5 to 1 skip only step 3
    // bcqz push is not required in pop
    public static int Pop(int M){  //M is stack number
         
        // check underflow
        if(top[M]==-1){
            System.out.println("Underflow Stack");
            return Integer.MAX_VALUE;
        }

        // step 1 find index of top element
        int index=top[M];

        //step 2 change top to store previous top
        top[M]=next[index];

            //s step 3 attach previous top to freespace
            next[index]=freespace;
         
            // step 4 
            return arr[index];

    } 
}

public static void main(String[] args) {
    arrayConstructer st=new arrayConstructer(3, 10);

    //push some element in stakc no..2
    st.Push(15,2);
    st.Push(45,2);

    //push some element in stakc no..1
    st.Push(17,1);
    st.Push(39,1);
    st.Push(49,1);

    //push some element in stakc no..0
    st.Push(11,0);
    st.Push(9,0);
    st.Push(7,0);


    System.out.println("pop element from stack 2:"+st.Pop(2));
    System.out.println("pop element from stack 1:"+st.Pop(1));
    System.out.println("pop element from stack 0:"+st.Pop(0));

}
}
