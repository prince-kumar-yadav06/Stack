import java.util.*;
 class StackSpecial extends Stack<Integer> {
    Stack<Integer> min=new Stack<>();

    public  void push(int x){
        if(isEmpty()==true){
            super.push(x);
            min.push(x);
        }
        else{
            super.push(x);
            int y=min.pop();
            min.push(y);
            if(x<=y){
                min.push(x);
            }
            else{
                min.push(y);
            }
        }
    }
   public  Integer pop(){
    int val=super.pop();
    min.pop();

    return val;
    }

    Integer getmin(){
        int Min=min.pop();
        min.push(Min);

        return Min;
    }

    public static void main(String args[]){
        StackSpecial s=new StackSpecial();
        s.push(2);
        s.push(14);
        s.push(4);
        s.push(7);
        s.push(1);
        s.push(10);

        System.out.println("Popped:"+s.pop());
        System.out.println("Min:"+s.getmin());

        System.out.println("Popped:"+s.pop());
        System.out.println("Popped:"+s.getmin());


    }
}
