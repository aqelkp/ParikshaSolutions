import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GCDofF {

 public static void main(String[] args) {
 	Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0){
//           System.out.println("t = " + t + " " + gcd(5,15));
           int i = sc.nextInt();
           int j = sc.nextInt();
           int sum = 0;
           for (int k = i; k <= j; k++)
                sum = sum + func(k);
           System.out.println(sum);
           
      }
 }
     private static int func(int x){
          int sum = 0;
          for (int i=1; i<=x; i++ ){
               sum = sum + gcd(i, x);
          }
          return sum;
     }
     
     private static int gcd(int x, int y){
          int max = Math.max(x,y);
          int min = Math.min(x,y);
          while (min != 0){
               int temp = min;
               min = max % min;
               max = temp;
          }
          return max;
     }
}