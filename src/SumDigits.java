import java.util.*;

class SumDigits {

 public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      
      for (int i=0; i<t; i++){
           int a = sc.nextInt();
           int b = sc.nextInt();
           System.out.println(sumUntil(b) - sumUntil(a) );
	  }
      sc.close();
 }
     
     private static long sumUntil(int n) {
    	 long sum = 0;
    	 if (n/10 > 0)
    		 sum = (n/10) * sumUntil(10-1) + 10 * sumUntil(n/10-1);
    	 for (int i=n-(n%10); i<=n; i++){
    		 sum = sum + addDigits(i);
    	 }
     return sum;
     }

     
     public static long addDigits(int a){
          int sum = 0;
          while (a != 0){
            sum = sum + a % 10;
          	a = a / 10;
          }
          return (long) sum;
     }
}