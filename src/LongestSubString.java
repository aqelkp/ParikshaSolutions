import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LongestSubString {

 public static void main(String[] args) {
 /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      sc.nextLine();
      for (int i=0; i<t; i++){
           char[] a = sc.nextLine().toCharArray();
           char[] b = sc.nextLine().toCharArray();
           int[][] dp = new int[a.length][b.length];
           int max = 0;
           for (int j=0; j<a.length; j++)
                for (int k=0; k<b.length; k++ ){
                     if (a[j] == b[k]) dp[j][k] = 1;
                     else dp[j][k] = 0;
                }
           for (int j=1; j<a.length; j++)
                for (int k=1; k<b.length; k++ ){
                     if (dp[j][k] != 0) 
                          dp[j][k] = dp[j][k] + dp[j-1][k-1];
                     if (dp[j][k] > max) max = dp[j][k];
                }
           System.out.println(max);
      }
 }
}