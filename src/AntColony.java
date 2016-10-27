import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AntColony {

 public static void main(String[] args) {
 /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
	 System.out.println(Math.pow(10, 2));
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for (int i =0; i<t; i++){
           int x = sc.nextInt();
           int y = sc.nextInt();
           int d = sc.nextInt();
           int[][] arr = new int[x][y];
           for (int j=0; j<x; j++)
                for (int k=0; k<y; k++)
                     arr[j][k] = sc.nextInt();
//                	arr[j][k] = 90000000;
           int levels = Math.min((x-1)/2, (y-1)/2);
           for (int j=0; j<=levels; j++){
        	   int maxRotation = 2 * (x - 2 * j) + 2 * (y - 2 * j - 2);
        	   maxRotation = d % maxRotation;
        	   for (int k=0; k<maxRotation; k++){
        		   rotate(arr, j, levels, x, y);
        	   }
           }
           printArray(arr,x,y);
           
      }
 }
     private static void printArray(int[][] arr, int x, int y){
    	  for (int i=0; i<x; i++){
    		  StringBuffer buffer = new StringBuffer();
    	         
               for (int j=0; j<y; j++) {
            	   buffer.append(arr[i][j] + " ");
               }
//            	   System.out.printf(arr[i][j] + " ");
               buffer.setLength(buffer.length() - 1);
               System.out.println(buffer.toString());
               
          }
          
     }
     
	public static void rotate(int[][] arr, int curr, int levels, int x, int y){
		
		int top_left = arr[curr][curr];
		int bot_right = arr[x-1-curr][y-1-curr];
		int bot_left = arr[x-1-curr][curr];
        
		/* 
		 int top_left = arr[0][0];
         int tempB = arr[1][y-1];
         for (int i=y; i>0; i--){
              int tempA = arr[0][i-1];
              arr[0][i-1] = tempB;
              tempB = tempA;
         }
		 * */
		
		 int tempB = arr[1+curr][y-1-curr];
         for (int i=y-curr; i>curr; i--){
              int tempA = arr[curr][i-1];
              arr[curr][i-1] = tempB;
              tempB = tempA;
         }
         
         /*
           int bot_left = arr[x-1][0];
         tempB = top_left;
         for (int i=1; i<x; i++){
        	 int tempA = arr[i][0];
        	 arr[i][0] = tempB;
        	 tempB = tempA;
         }
          */
         
         tempB = top_left;
         for (int i=1+curr; i< x - curr; i++){
        	 int tempA = arr[i][curr];
        	 arr[i][curr] = tempB;
        	 tempB = tempA;
         }
         
         /*
           int bot_right = arr[x-1][y-1];
         tempB = bot_left;
         for (int i=1; i<y;i++){
        	 int tempA = arr[x-1][i];
        	 arr[x-1][i] = tempB;
        	 tempB = tempA;
         }
          */
         if (!(y/2 == curr)){
        	 tempB = bot_left;
             for (int i=1+curr; i<y-curr;i++){
            	 int tempA = arr[x-1-curr][i];
            	 arr[x-1-curr][i] = tempB;
            	 tempB = tempA;
             }
         } 

                  /*
          tempB = bot_right;
         for (int i=x-2; i>=0; i--){
        	 int tempA = arr[i][y-1];
        	 arr[i][y-1] = tempB;
        	 tempB = tempA;
         }
          */
         if (!(x/2 == curr)){
        	 tempB = bot_right;
             for (int i=x-2-curr; i>=curr; i--){
            	 int tempA = arr[i][y-1-curr];
            	 arr[i][y-1-curr] = tempB;
            	 tempB = tempA;
             }
         }
         
    }
}

