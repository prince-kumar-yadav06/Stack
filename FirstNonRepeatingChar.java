import java.util.*;
public class FirstNonRepeatingChar {
    public static void NonRepeating(String str){
    //     // Using Array 

    //     char[] count=new char[26];

    //     Queue<Character> Q=new LinkedList<Character>();
        
    //     for(int i=0;i<str.length();i++){
    //             char c=str.charAt(i);
    //             count[c-'a']++;
    //                 // mp.put(c,mp.getOrDefault(c,0)+1);
    //                 Q.add(c);
    //             }
    //         while(!Q.isEmpty() && count[Q.peek()-'a']>1){
    //             // if(count[Q.peek()-'a']>1){
    //                 Q.remove();
    //             }
    //             // else{
    //             // System.out.print(Q.peek()+" ");
    //             //     break;
    //             // }
            
    //         if(Q.isEmpty()){
    //             System.out.println("-1");
    //         }
    //         else{
    //             System.out.println(Q.peek());
    //         }
    //         System.out.println();



    
            // Same thing using Map DataStructure
        Map<Character,Integer> mp=new HashMap<>();

        Queue<Character> Q=new LinkedList<Character>();

        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            mp.put(c,mp.getOrDefault(c,0)+1);
            Q.add(c);
        }

        while(!Q.isEmpty() && mp.get(Q.peek())>1){
            Q.remove();
        }
        if(Q.isEmpty()){
            System.out.println("-1");
        }
        else{
            System.out.println(Q.peek());
        }

    }
    public static void main(String args[]){
        String str="aa";
        NonRepeating(str);
    }
}
