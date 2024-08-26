import java.util.*;
public class CircularTour {
   static class Petrolpump{
        int petrol;
        int distance;

      public  Petrolpump(int petrol,int distance){
            this.petrol=petrol;
            this.distance=distance;
        }
    }

    public static int Solution(Petrolpump[] arr,int n){
        int dificit=0;
        int extraPetrol=0;
        int start=0;

        for(int i=0;i<n;i++){
            int ptrl=arr[i].petrol;
            int dist=arr[i].distance;

             extraPetrol=(extraPetrol+ptrl)-dist;
            if(extraPetrol<0){
                dificit+=extraPetrol;
                start=i+1;
                extraPetrol=0;
            }
            
            
        }
        if(dificit+extraPetrol>=0){
            return start;
        }
        else{

            return -1;
        }
    }

    public static void main(String args[]){
        Petrolpump arr[]={
                    new Petrolpump(4, 6),
                    new Petrolpump(6, 5),
                    new Petrolpump(7, 3),
                    new Petrolpump(4, 5),
        };

        int n=arr.length;

        System.out.println(Solution(arr,n));
    }
}
