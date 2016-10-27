import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class APorGP {

 public static void main(String[] args) {
 /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for (int z =0; z<t; z++){
           long a = sc.nextLong();
           long b = sc.nextLong();
           long c = sc.nextLong();
           if (b-a == c -b){
                System.out.println(c + (c-b));
           } else if (a * c == b * b){
                System.out.println(c * (b/a));
           } else System.out.println("-1");
      }
 }
}