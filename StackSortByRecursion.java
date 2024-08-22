import java.util.*;
public class SortStByRecursion {
public static void sortedInsert(Stack<Integer> s,int num){

    //base case
    if(s.isEmpty() || s.peek()<num){
        s.push(num);
        return;
    }
    int top=s.peek();
    s.pop();

    //recursion
    sortedInsert(s, num);
    s.push(top);
}

    public static void SortSt(Stack<Integer> s){
        // Base case
        if(s.isEmpty()){
            return;
        }

        //store top element
        int top=s.peek();

        //pop top element
        s.pop();

        //recursion
        SortSt(s);

        // call function that insert top at right position 
        sortedInsert(s,top);

    }
    
    public static void main(String args[]){
        Stack<Integer> s=new Stack<>();
        // s.push(-3);
        // s.push(14);
        // s.push(18);
        // s.push(-5);
        // s.push(30);

        s.push(1);
        s.push(2);
        s.push(4);
        s.push(3);

        SortSt(s);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
