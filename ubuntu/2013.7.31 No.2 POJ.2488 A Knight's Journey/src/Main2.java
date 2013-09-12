import java.util.Scanner;

/**
 * 2013.7.31 No.2 POJ.2488 A Knight's Journey
 * 
 * @author YH YANG
 */
public class Main2 {
	public static int[][] dir = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 },
			{ 1, -2 }, { 1, 2 }, { 2, -1 }, { 2, 1 } };
	public static boolean[][] vis = new boolean[30][30];
	public static int[][] trace = new int[30][30];
	public static int T, t, n, m, count = 0;
	public static boolean flag;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		for (t = 1; t <= T; t++) {
			n = in.nextInt();
			m = in.nextInt();
			System.out.println("Scenario #" + t + ":");
			count = 0;
			vis = new boolean[30][30];
			vis[1][1] = true;
			flag = false;
			trace[count][0] = 1;
			trace[count][1] = 1;
			
			dfs(1, 1, 1);
			if(flag == true) {
				for (int i = 0; i < n * m; i++) {
					System.out.printf("%c", trace[i][0] + 'A' - 1);
					System.out.print(trace[i][1]);
				}		
				System.out.println("\n");
			}
			else
				System.out.println("impossible\n");
		
		

		}
		in.close();

	}

	static void dfs(int N, int M, int count) {

		if (count == n * m) {
			flag = true;
			return;
		}

		for (int i = 0; i < 8; i++) {
			int n1 = N + dir[i][0];
			int m1 = M + dir[i][1];
			
			
			if (n1 > 0 && n1 <= m && m1 > 0 && m1 <= n && vis[n1][m1] == false) {
				//System.out.println("\n" + n1 + " " + m1 + "\n");
				trace[count][0] = n1;
				trace[count][1] = m1;			
				vis[n1][m1] = true;
				dfs (n1, m1, count + 1);
				if (flag == true)
					return;
				vis[n1][m1] = false;
			}		

		}
		return;

	}
}

