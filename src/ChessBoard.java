import java.util.Scanner;

public class ChessBoard {

 public static void main(String[] args) {
 /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
      Scanner sc = new Scanner(System.in);
      int t =  sc.nextInt();
      for (int i=0; i<t; i++){
           int s = sc.nextInt();
           int x = sc.nextInt();
           int y = sc.nextInt();
           int dx = sc.nextInt();
           int dy = sc.nextInt();
           checkIfBlack(s, x, y);
           int count = 0;
           if (x%s ==0 || y%s ==0 ){
                if (x%s ==0){
                     if (dx == s) 
                          System.out.println("The fly can not escape from black squares");
                } else {
                     if (dy == s) 
                          System.out.println("The fly can not escape from black squares");
                }
           }else {
//                while (checkIfBlack(s, x, y)){
//                     int m = 1;
//                     if ( x % s < y % s){
//                          m = m + (s - x % s)/dx;
//                     } else {
//                          m = m + (s - y % s)/dy;
//                     }
//                     x = x + m * dx;
//                     y = y + m * dy;
//                     count = count + m;
//                }
        	   	int m = 0;
        	   	for (m  = 0; m<Integer.MAX_VALUE; m++){
        	   		if ( x % s < y % s){
	                      m = m + (s - (m * dx +  x) % s)/dx;
	                 } else {
	                      m = m + (s -  (m * dy + y) % s)/dy;
	                 }
        	   		int k1 = ( y + m * dy )/(2 * s) + 1;
        	   		int k = ( x + m * dx )/(2 * s) + 1;
        	   		int lhs = 2*k*s - m*dx - x;
        	   		int rhs = 2*k1*s - m *dy - y;
        	   		if ((lhs < s && rhs > s) || (lhs > s && rhs < s)) break;
        	   	}
                System.out.println("After "+ m + " jumps the fly lands at ("+ (m * dx +  x) + ", "+ (m * dy + y) + ")");
           }
           
      }
 }
     
  public static boolean checkIfBlack(int s, int x, int y){
       x = x % (2 * s);
       y = y % (2 * s);
       //if ( x == 0 || y == 0) return false;
       if ((x<s) && (y<s)) return true;
       if ((x>s) && (y>s)) return true;
       return false;
  }
}