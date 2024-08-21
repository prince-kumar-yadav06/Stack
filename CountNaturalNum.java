import java.util.*;
public class NthNaturalStack {
    public static int NthNaturalNum(int n){
        Stack<Integer> st=new Stack<>();

        int count=0;
        // first add 1 to 9 bcoz permutation of 1 to 9 is same
        //count +++
        for(int i=1;i<=9;i++){
            st.push(i);
            count++;
        }

        //remove top and loop j=top%10 to 9
        //if x=top*10+j is <= N then push in stack and count++
        while(!st.isEmpty()){
            int top=st.pop();
            for(int j=top%10;j<=9;j++){
                int x=top*10+j;
                if(x<=n){
                    st.push(x);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String args[]){
        int n=100;
        System.out.println("Total Number is:"+NthNaturalNum(n));
    }
}

