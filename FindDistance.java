import java.util.*;

public class FindDistance {
    static class Node{
        int row;
        int col;
        int dist;

        Node(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }

    }
    public static int[][] solution(int arr[][]){

        int n=arr.length;
        int m=arr[0].length;

        // visited arr

        int vis[][]=new int[n][m];

        //distacne matrix that store distance 
        int dist[][]=new int[n][m];

        //Queue that store row,col,distance
        Queue<Node> Q=new LinkedList<Node>();

        //jab tk arr[i][j]=1 hai queue me add kr de and vis ko mark 1 kr de
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    Q.add(new Node(i,j,0));
                    vis[i][j]=1;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }

        //row and col for checking valid row ,col or not

        int valrow[]={-1,0,+1,0};
        int valcol[]={0,-1,0,+1};

        //jab tk queue empty khali nhi hota tb tk q se row,col,dist remove krte rahenge

        while(!Q.isEmpty()){
            int row=Q.peek().row;
            int col=Q.peek().col;
            int step=Q.peek().dist;
            Q.remove();

            dist[row][col]=step;

            for(int i=0;i<4;i++){
                int nrow=row+valrow[i];
                int ncol=col+valcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    Q.add(new Node(nrow,ncol,step+1));
                    vis[nrow][ncol]=1;
                }
            }
            
        }

        return dist;
    }

    public static void main(String args[]){
        int[][] mat={{1,0,1},
                    {1,1,0},
                    {1,0,0}};

                    int res[][]=solution(mat);
                     for(int i=0;i<mat.length;i++){
                        for(int j=0;j<mat[0].length;j++){
                            System.out.print(res[i][j]+" ");
                        }
                        System.out.println();
                     }
    }
}
