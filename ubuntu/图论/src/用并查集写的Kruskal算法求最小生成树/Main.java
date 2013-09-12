package 用并查集写的Kruskal算法求最小生成树;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static final int MAXN = 10000;
	static int[] u = new int[MAXN];
	static int[] v = new int[MAXN];
	static int[] p = new int[MAXN];
	static int n, m;
	
	static class Rw {
		int r; 
		int w;
		static int k = 0;
		public Rw(int w) {	
			this.r = Rw.k++;
			this.w = w;
		}
	}
	
	static class Com implements Comparator<Rw> {
		public int compare(Rw x, Rw y) {
			return 
					x.w - y.w;
		}
	}
	
	static int find (int x) {
		while(p[x] != x) {
			x = p[x];
		}
		return x;		
	}
	
	static int kruskal(Rw[] s) {
		int ans = 0;
		for(int i = 0; i < m; i++) {
			 int e = s[i].r;
			 int x = find(u[e]);
			 int y = find(v[e]);
			 if(x != y) {
				 ans += s[i].w;
				 p[x] = y;
				// System.out.println(u[e] + " " + v[e]);
			 }			 
		}
		 return ans;
	}
	
	
	
		
	public static void main(String[] args) {		
			Scanner in = new Scanner(System.in);
			n = in.nextInt();
			m = in.nextInt();
			Rw[] s = new Rw[m];
			for(int i = 0; i < m; i++) {
				u[i] = in.nextInt();
				v[i] = in.nextInt();
				s[i] = new Rw(in.nextInt());
				p[i] = i;
			}				
			Arrays.sort(s,new Com());
			/*for (Rw i : s)
				System.out.println(i.r+" " + i.w);*/
			int answer = kruskal(s);
			System.out.println(answer);
			in.close();			
	}

}
