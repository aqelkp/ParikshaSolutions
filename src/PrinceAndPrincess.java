import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Comparator;

public class PrinceAndPrincess {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i =0; i<t; i++){
			int m = sc.nextInt();
			int n = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			/*
			 	0 - Cost of the cell
			 	1 - Min dista
			 	2 - X axis
			 	3 - Y axis
			 */
			int[][][] c = new int[m][n][4];
			int[][] d = new int[m][n];
			boolean[][] gone = new boolean[m][n];
			for (int j = 0; j<m; j++){
				for (int k = 0; k<n; k++){
					c[j][k][0] = sc.nextInt();
					c[j][k][1] = Integer.MAX_VALUE;
					c[j][k][2] = j;
					c[j][k][3] = k;
					gone[j][k] = false;
					
				}
			}
			Comparator<int[]> comp = new DistanceComparator();
			PriorityQueue<int[]> queue = new PriorityQueue<int[]>(m*n, comp);
			c[0][0][1] = c[0][0][0];
			queue.add(c[0][0]);
			while (!queue.isEmpty()){
				int[] point = queue.remove();
//				System.out.println("Removed point ("+point[2] + ","+ point[3] + ") with distance " + point[1] );
				visit(c, gone, queue, point );
			}
			System.out.println(c[x][y][1]);
			
		}
	}

	private static void visit(int[][][] c, boolean[][] gone, PriorityQueue<int[]> queue, int[] point) {
		gone[point[2]][point[3]] = true;
		addPoint(c, queue, gone, point[2]+1, point[3], point[1] );
		addPoint(c, queue, gone, point[2]-1, point[3], point[1] );
		addPoint(c, queue, gone, point[2], point[3]+1, point[1] );
		addPoint(c, queue, gone, point[2], point[3]-1, point[1] );
	}

	private static void addPoint(int[][][] c, PriorityQueue<int[]> queue, boolean[][] gone, int i, int j, int d) {
		if (i== -1 || i == c.length || j == -1 || j == c[0].length) return;
		if (gone[i][j]) return;
		if (c[i][j][1] > d + c[i][j][0]) c[i][j][1] = d + c[i][j][0];
		queue.add(c[i][j]);
		return;
	}

	
	
	
}

class DistanceComparator implements Comparator<int[]>{
	 
	@Override
	public int compare(int[] a, int[] b){
		if (a[1] < b[1]) return -1;
		if (a[1] > b[1]) return 1;
		return 0;
	}
	
}
