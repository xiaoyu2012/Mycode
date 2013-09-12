package hdu2544;

import java.util.Scanner;

public class Main {
	static final int INF = 99999999;
	static int[] d;
	static boolean[] vis;
	static int[][] w;
	static int N, M;
	
	static void newdis(int u) {
		for(int i = 0; i <= N; i++) 
			if(vis[i] == false && d[i] > w[u][i] + d[u])
				d[i] = w[u][i] + d[u];		
	}
	
	static int found() {
		int min = INF;
		int minpoint = 1;
		for(int i = 0; i <= N; i++) 
			if(vis[i] == false && d[i] < min) {
				min = d[i];
				minpoint = i;
			}
		return minpoint;
	}
		
		
		
		
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while((N = in.nextInt()) != 0) {
			M = in.nextInt();
			w = new int[N + 1][N + 1];
			for(int i = 0; i <= N; i++)
				for(int j = 0; j <= N; j++)
					w[i][j] = INF;
			for(int i = 0; i < M; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				int weight = in.nextInt();
				if(w[a][b] > weight) {
					w[a][b] = weight;
					w[b][a] = weight;
				}
			}
			d = new int[N + 1];
			vis = new boolean[N + 1];
			
			for(int i = 0; i <= N; i++) {
				d[i] = INF;
				vis[i] = false;
			}
			d[1] = 0;
			vis[1] = true;
			newdis(1);
			for(int i = 1; i <= N; i++) {				
				int u = found();
				vis[u] = true;
				newdis(u);		
			}
			
			System.out.println(d[N]);				
				
			}
		in.close();
			
		}	
}
