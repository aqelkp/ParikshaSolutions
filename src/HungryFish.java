import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HungryFish {

 public static void main(String[] args) {
 /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0){
           int f = sc.nextInt();
           int n = sc.nextInt();
           int[] arr = new int[n];
           for (int i=0; i<n; i++) arr[i] = sc.nextInt();
           Arrays.sort(arr);
           System.out.println(findCount(arr, 0, f));
      }
      
 }
     
     public static int findCount(int[] arr, int i, int f){
          if (i == arr.length) return 0;
          if (f  > arr[i]) return findCount(arr, i+1, f+arr[i]);
          return Math.min(1 + findCount(arr, i, 2*f-1), arr.length - i);
          //return Math.min(1 + findCount(arr, i, 2*f-1), 1 + findCount(arr, i+1, f));
     }
     
}