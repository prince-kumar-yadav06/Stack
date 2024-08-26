import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {
   static class Node{
        int row;
        int col;
        int time;

        Node(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }

    public static int Solution(int[][] arr){

        int n=arr.length;
        int m=arr[0].length;

        int vis[][]=new int[n][m];
        Queue<Node> Q=new LinkedList<>();

        int cntFrsh=0;
        int cntRot=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==2){
                    vis[i][j]=2;
                    Q.add(new Node(i, j, 0));
                }
                if(arr[i][j]==1){
                    cntFrsh++;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        
        int tm=0;
        int valrow[]={-1,0,+1,0};
        int valcol[]={0,+1,0,-1};

        
        while(!Q.isEmpty()){
            int row=Q.peek().row;
            int col=Q.peek().col;
            int time=Q.peek().time;
            
            tm=Math.max(time,tm);
             Q.remove();

            for(int i=0;i<4;i++){
                int nrow=row+valrow[i];
                int ncol=col+valcol[i];
         if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && arr[nrow][ncol]==1 && vis[nrow][ncol]!=2){
                    Q.add(new Node(nrow, ncol, tm+1));
                    vis[nrow][ncol]=2;
                    cntRot++;
                }
            }
        }

       if(cntFrsh!=cntRot){
        return -1;
       }
        return tm;
    }
    public static void main(String args[]){
        int [][] grid={{2,2,0,1}};
                       

        System.out.println(Solution(grid));
    }
}
