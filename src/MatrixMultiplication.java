import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MatrixMultiplication {

 public static void main(String[] args) {
 /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
	 StringBuffer buffer = new StringBuffer();
	 buffer.setLength(buffer.length());
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for (int z=0; z<t; z++){
           int m = sc.nextInt();
           int n = sc.nextInt();
           int[][] mat = new int[m][n];
           for (int i=0; i<m; i++){
                for (int j=0; j<n; j++){
                     mat[i][j] = sc.nextInt();
                }
           }
           for (int i=0; i<m; i++){
                for (int j=0; j<m; j++){
                     int sum = 0;
                     for (int k=0; k<n; k++) sum = sum + mat[i][k] * mat[j][k];
                     System.out.print(sum + " ");
                }
                System.out.println("");
           }
      }
 }
}