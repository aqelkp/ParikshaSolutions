import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Factorial {

 public static void main(String[] args) {
 /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
       Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for (int i =0; i<t; i++){
      		int num = sc.nextInt();
           BigInteger sum = BigInteger.ONE;
           for (int j=2; j<=num; j++) sum = sum.multiply(BigInteger.valueOf(j));
           System.out.println(sum);
      }
 }
}