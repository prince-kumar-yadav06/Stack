import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class QReversal {

    public static void Qrev(Queue<Integer> Q1){ //T.c=O(N); S.c=O(N)
        Stack<Integer> s=new Stack();

        System.out.println("Queue Before Reversal");
        while(!Q1.isEmpty()){
            System.out.print(Q1.peek()+" ");
           s.add(Q1.remove());
        }

        // while(!Q1.isEmpty()){
        //     s.push(Q1.element());
        //     Q1.remove();
        // }

        System.out.println();
        System.out.println("Queue After Reversal");
        while(!s.isEmpty()){
            System.out.print(s.peek()+" ");
            s.pop();
        }
    }

    public static void QReversalusingRec(Queue<Integer> Q1){
        if(Q1.size()==0){
            return;
        }
        int FrontElem=Q1.peek();
        Q1.remove();
        QReversalusingRec(Q1);
        Q1.add(FrontElem);

    }
            public static void main(String args[]){
                Queue<Integer> q=new LinkedList<>() ;
                q.add(1);
                q.add(2);
                q.add(3);
                q.add(4);

                // Qrev(q);

                // By recursion 
                QReversalusingRec(q);
                while(!q.isEmpty()){
                    System.out.println(q.peek());
                    q.remove();
                }
                
            }
}
