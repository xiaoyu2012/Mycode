package 杨辉三角;

import java.util.Scanner;

public class Main {
	
	static int[][] c;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		c = new int[n+1][n+1];
		for(int i = 0; i <= n; i++) {
			c[i][0] = 1;
			for(int j = 1; j <= i; j++)
				c[i][j] = c[i-1][j-1] + c[i-1][j];
		}
		
		for(int i = 0; i <= n; i++) {
			for(int j = n; j > i; j--)
				System.out.print(" ");
			for(int j = 0; j <= i; j++)
				System.out.print(c[i][j] + " ");	
			System.out.println("   ");
			
		}
		in.close();
		
		}

		
}


