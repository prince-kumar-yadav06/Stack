import java.util.*;
public class LRUchache {
   public class Node{
      Node next;
      Node prev;
        int key;
        int data;

        Node(int _key,int _data){
           this.key=_key;
            this.data=_data;
        }
    }
    Node head=new Node(0,0);
    Node tail=new Node(0,0);

     Map<Integer,Node> mp=new HashMap<>();
    int ChacheSize;

  

   public LRUchache(int capacity){
        head.next=tail;
        tail.prev=head;

        this.ChacheSize=capacity;
        

    }

    public  int get(int key){
        if(mp.containsKey(key)){
            Node node=mp.get(key);
            deletenode(node);
            insertafterHead(node);

            return node.data;
        }
        else{
            return -1;
        }
    }

    public void put(int key,int value){
        if(mp.containsKey(key)){ 
            deletenode(mp.get(key));
        }
        if(mp.size()==ChacheSize){
            deletenode(tail.prev);
        }
        insertafterHead(new Node(key, value));
    }
    public void deletenode(Node node){
        mp.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void insertafterHead(Node node){
        mp.put(node.key,node);
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;
    }
    public static void main(String args[]){
         
        LRUchache ob=new LRUchache(2);

        ob.put(1, 10);
        ob.put(3, 15);
        ob.put(2, 12);
        ob.put(4, 16);

        System.out.println(ob.get(1));

        ob.put(4,25);
        System.out.println(ob.get(4));
    }
}
