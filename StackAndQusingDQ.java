import java.util.*;
public class StackQandDQ {
    static class DqNode{
        int value;
        DqNode next;
        DqNode prev;
    }
    public static class dqueue{
        private static DqNode head;
        private  static DqNode tail;

        dqueue(){
            head=tail=null;
        }

        public static boolean isEmpty(){
            if(head==null){
                return true;
            }
            return false;
        } 

        public static void insert_first(int element){
            DqNode temp=new DqNode();
            temp.value=element;
            if(head==null){
                head=tail=temp;
                temp.next=temp.prev=null;
            }
            else{
                head.prev=temp;
                temp.next=head;
                temp.prev=null;
                head=temp;
            }

            }
        public static void insert_last(int element){ 
            DqNode temp=new DqNode();
            temp.value=element;
            if(head==null){
                head=tail=temp;
                temp.next=temp.prev=null;

            }
            else{
                tail.next=temp;
                temp.next=null;
                temp.prev=tail;
                tail=temp;
            }
            }
            public static void remove_first(){
                if(!isEmpty()){
                    if(head==tail){
                        head=tail=null;
                        return;
                    }
                    else{
                        head=head.next;
                        head.prev=null;
                    }
                }
                else{
                    System.out.println("List is Empty");
                }
            }
            public static void remove_last(){
                if(!isEmpty()){
                    DqNode temp=tail;
                    tail=tail.prev;
                    if(tail!=null){
                        tail.next=null;
                    }
                        return;
                    }
                    
                else{
                    System.out.println("List is Empty");
                }
        }
        public static int size(){
            int Len=0;
            if(!isEmpty()){
                DqNode temp=head;
                while(temp!=null){
                    Len++;
                    temp=temp.next;
                }
            }
            return Len;
        }
    
        public static void print(){
        if(!isEmpty()){
            DqNode temp=head;
            while(temp!=null){
                System.out.println(temp.value);
                temp=temp.next;
            }
            return;
        }
        System.out.println("list is Empty");
        }
    }

    static class stack{
       static dqueue d=new dqueue();

        public static void pushstk(int data){
            d.insert_last(data);
        }

        public static void popstk(){
            d.remove_last();
        }
        public static void printStk(){
            d.print();
        }
        public static int sizeStk(){
            return d.size();
        }
    }
    static class queue{
        static dqueue q=new dqueue();

        public static void pushQ(int data){
            q.insert_last(data);
        }
        public static void popQ(){
            q.remove_first();
        }
        public static void printQ(){
            q.print();
        }
        public static int sizeQ(){
            return q.size();
        }
    }
    public static void main(String[] args) {
        stack s=new stack();
        s.pushstk(7);
        s.pushstk(8);
        // s.pushstk(3);
        System.out.println("stack elemnt");
        s.printStk();
        s.popstk();
        System.out.println("After pop stack elemnt");
        s.printStk();

        queue q=new queue();
        q.pushQ(12);
        q.pushQ(13);
        // q.pushQ(6);
        System.out.println("Queue element");
        q.printQ();
        q.popQ();
        System.out.println("After pop Queue element");
        q.printQ();

        System.out.println(s.sizeStk());
        System.out.println(q.sizeQ());
    }
}

