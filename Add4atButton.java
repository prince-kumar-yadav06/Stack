import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class stackclass{
public static void pushAtbuttom(int data,Stack<Integer> s){
  // base case

  if(s.isEmpty()){
    s.push(data);
    return;
  }
  // remove top data
  int top=s.pop();
  pushAtbuttom(data, s);

  // when all element pop then function will come down the add top
  s.push(top);
}
 public static void main(String args[]){
   
   // using brute force 
  //  ArrayList arr=new ArrayList<>();
  // System.out.println("enter number");
  // Scanner input=new Scanner(System.in);
  // int n=input.nextInt();

  Stack s=new Stack<>();

  s.push(1);
  s.push(2);
  s.push(3);
  
  // while(!s.isEmpty()){
  //   arr.add(s.peek());
  //   s.pop();
  // }
  // s.add(n);
  // int size=arr.size()-1;
  
  // while(size>=0){
  //   s.add(arr.get(size));
  //   arr.remove(size);
  //   size--;
  // }


  // using recursion 
  int data=4;
  pushAtbuttom(data, s);
  while(!s.isEmpty()){
    System.out.println(s.peek());
    s.pop();
  }


}

}
