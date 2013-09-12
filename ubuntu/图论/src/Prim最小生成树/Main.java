package Prim最小生成树;

import java.util.ArrayList;
import java.util.Scanner;

/*2013.8.12  No.1 
 * YYH
 */

public class Main {
	public static final int MAXN = 9999;
	static int[][] weight;
	static int[] lowCast;
	static int N, M;
	static class tree {
		int vertics, weight;
		public tree(int vertics, int weight) {
			this.vertics = vertics;
			this.weight = weight;
		}		
	}
	
	//found method: find the mimimum lowCast's point
	static int found(int[] lowCast, int N) {
		int minpoint = 1;
		int min = MAXN;
		for(int i = 1; i <= N;i++) 
			if(lowCast[i] != -1 && lowCast[i] < min) {
				min = lowCast[i];
				minpoint = i;			
			}				
		return minpoint;		
	}

	static void newLowCast( int N, int[][] weight, int u) {
		for(int i = 1; i <= N; i++)
			if(lowCast[i] != -1 && weight[u][i] < lowCast[i])
				lowCast[i] = weight[u][i];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		
		// initialize weight[][];
		weight = new int[N + 1][N + 1];
		for(int i = 0; i <= N; i++) 
			for(int j = 0; j <= N; j++) {
				if(i == j)
					weight[i][j] = 0;
				else
					weight[i][j] = MAXN;				
			}
		
		//Input weight
		for(int i = 0; i < M; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int w = in.nextInt();
			if(weight[a][b] > w) {
				weight[a][b] = w;
				weight[b][a] = w;
			}			
		}
		/*
		// Output weight
		for(int[] x : weight) {
			for(int y : x)
				System.out.print(y + " ");
			System.out.println();
		}
		*/
		lowCast = new int[N + 1];
		ArrayList<tree> s = new ArrayList<tree>();
		s.add(new tree(1, 0));
		lowCast[1] = -1;
		for(int i = 2; i <= N; i++) 
			lowCast[i] = weight[1][i];
		
		int count = 2;
		int u;
		while(count <= N) {
			u = found(lowCast, N);
			s.add(new tree(u,lowCast[u]));
			lowCast[u] = -1;
			newLowCast( N, weight, u);
			count++;
		}
		for(tree x : s)
		System.out.println(x.vertics + " " + x.weight);
		in.close();		
	}
	
}
