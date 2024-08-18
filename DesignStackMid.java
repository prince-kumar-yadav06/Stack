import java.util.*;
public class DDLLNode{

 static class Node{
    Node next;
    Node prev;
    int data;

    Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
 }
 static class stack{
    static int size;
    static Node head;
    static Node mid;

    public static boolean isEmpty(){
        return head==null;
    }
  

  public static void push(int data){
    Node newnode=new Node(data);
    if(size==0){
        head=newnode;
        mid=newnode;
        size++;
    }
    else{
        head.next=newnode;
        newnode.prev=head;
        head=head.next;
        
        // For Set  mid
        if(size%2==0){
            mid=mid.next;
        }
    }
    size++;
  }
  public static int pop(){
    if(size==0){
        System.out.print("stack is empty");
        return -1;
    }
    int data=-1;
    if(size==1){
        data=head.data;
        head=null;
    }
    if(size>1){
        data=head.data;
        if(head.prev!=null){
            head=head.prev;
            if(head.next!=null){
                head.next=null;
            }
        }
        // set mid 
        if(size%2!=0){
            mid=mid.prev;
        }
    }
    size--;
    return data;
  }
  public static int getMid(){
    if(size==0){
        System.out.println("Stack is empty");
        return -1;
    }
    int val=-1;
    if(mid!=null){

         val=mid.data;
    }
    return val;
  }
  public static int deleteMid(){
    int delmid=-1;
    if(size==0){
        System.out.println("Only one elemeny in stack");
        return -1;
    }
    if(mid.prev!=null && mid.next!=null){
    delmid=mid.data;
    mid.next.prev=mid.prev;
    mid.prev.next=mid.next;
    size--;
    }
    if(size%2!=0){
        mid=mid.next;
    }
    else{
        mid=mid.prev;
    }

    return delmid;
  }
}

public static void main(String args[]){
    stack s=new stack();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);
    s.push(6);

    System.out.println("mid="+s.getMid());
    System.out.println("Delete Mid="+s.deleteMid());
    System.out.println("mid="+s.getMid());

    System.out.println("Delete Mid="+s.deleteMid());
    System.out.println("mid="+s.getMid());

    System.out.println("Delete Mid="+s.deleteMid());
    System.out.println("mid="+s.getMid());

    System.out.println("Delete Mid="+s.deleteMid());
    System.out.println("mid="+s.getMid());

    System.out.println("Delete Mid="+s.deleteMid());
    System.out.println("mid="+s.getMid());


   


}
}
