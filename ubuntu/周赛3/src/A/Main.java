package A;

import java.util.Scanner;

/**
 * 2013.08.04 No.1 Problem A: Sheep
 * 
 * @author yyh
 */
/*
public class Main {
	static int[][] a;
	static boolean[][] is;
	static int x, y;
	static int count1 = 0;
	static int count2 = 0;
	
	static void dfs (int n, int m) {
		if (is[n][m] == true || a[n][m] == 0 || a[n][m] == 2)
			return;
		is[n][m] = true;
		if(a[n][m] == 3)
			count2++;
		dfs(n - 1, m - 1);	dfs(n - 1, m);	dfs(n - 1, m + 1);
		dfs(n, m -1);						dfs(n, m + 1);
		dfs(n + 1, m - 1);	dfs(n + 1, m);	dfs(n + 1, m + 1);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			x = in.nextInt();
			y = in.nextInt();
			String[] s = new String[x];
			count1 = 0;
			count2 = 0;
			a = new int[x + 2][y + 2];
			is = new boolean[x + 2][y + 2];
			
			for (int i = 0; i < x; i++)
				s[i] = in.next();
			for (int i = 1; i <= x; i++)
				for (int j = 1; j <= y; j++) {
					if (s[i - 1].charAt(j - 1) == '.')
						a[i][j] = 1;
					if (s[i - 1].charAt(j - 1) == 'W')
						a[i][j] = 2;
					if (s[i - 1].charAt(j - 1) == 'S')
						a[i][j] = 3;
					if (s[i - 1].charAt(j - 1) == '#')
						a[i][j] = 0;
				}

			
			for (int i = 1; i <= x; i++)
				for (int j = 1; j <= y; j++) {
					if (a[i][j] == 3)
						count1++;
				}

			System.out.println(count1);

			for (int[] q : a) {
				for (int p : q)
					System.out.print(p);
				System.out.println();
			}

			for (int n = 1; n <= x; n++)
				for (int m = 1; m <= y; m++)
					if (a[n][m] == 2 && is[n][m] == false)
						dfs(n, m);
			System.out.println(count2);
			System.out.println(count1 - count2);

		}
		in.close();
	}
}
*/

/*package B;

public class Main {

}*/



/**
 * 2013.08.04 No.1 Problem A: Sheep
 * 
 * @author yyh
 */

public class Main {
	static int[][] a;
	static boolean[][] is;
	static int x, y;
	static int count1 = 0;
	static int count2 = 0;
	
	static void dfs (int n, int m) {
		if (is[n][m] == true || a[n][m] == 0)
			return;
		is[n][m] = true;
		if(a[n][m] == 3)
			count2++;
		dfs(n - 1, m - 1);	dfs(n - 1, m);	dfs(n - 1, m + 1);
		dfs(n, m -1);						dfs(n, m + 1);
		dfs(n + 1, m - 1);	dfs(n + 1, m);	dfs(n + 1, m + 1);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			x = in.nextInt();
			y = in.nextInt();
			String[] s = new String[x];
			count1 = 0;
			count2 = 0;
			a = new int[x + 2][y + 2];
			is = new boolean[66][66];
			
			for (int i = 0; i < x; i++)
				s[i] = in.next();
			for (int i = 1; i <= x; i++)
				for (int j = 1; j <= y; j++) {
					if (s[i - 1].charAt(j - 1) == '.')
						a[i][j] = 1;
					if (s[i - 1].charAt(j - 1) == 'W')
						a[i][j] = 2;
					if (s[i - 1].charAt(j - 1) == 'S')
						a[i][j] = 3;
					if (s[i - 1].charAt(j - 1) == '#')
						a[i][j] = 0;

				}

			
			for (int i = 1; i <= x; i++)
				for (int j = 1; j <= y; j++) {
					if (a[i][j] == 3)
						count1++;
				}

			//System.out.println(count1);

		/*	for (int[] q : a) {
				for (int p : q)
					System.out.print(p);
				System.out.println();
			}*/

			for (int n = 1; n <= x; n++)
				for (int m = 1; m <= y; m++)
					if (a[n][m] == 2 && is[n][m] == false)
						dfs(n, m);
			//System.out.println(count2);
			System.out.println(count1 - count2);

		}
		in.close();
	}
}
