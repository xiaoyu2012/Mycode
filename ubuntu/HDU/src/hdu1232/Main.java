package hdu1232;

import java.util.Scanner;

public class Main {
	
	/*static int find(int u,int[] p) {
		while(p[u] != u) {
			u = p[u];
		}
		return u;
	}
	*/
	static void union(int a, int b, int[] p) {	
		while(p[a] != a)
			a = p[a];
		while(p[b] != b)
			b = p[b];
		p[a] = b;		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N, M, count;
		int[] p;
		while((N = in.nextInt()) != 0) {
			M = in.nextInt();
			count = 0;
			//count = N;
			p = new int[N + 1];
			for(int i = 1; i <= N; i++)
				p[i] = i;
			
			for(int i = 0; i < M; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				union(a, b, p);			
			}
			
			for(int i = 1; i <= N; i++)
				if(p[i] == i)
					count++;
			// if(p[i] != i)   count--:
			System.out.println(count - 1);			
		}
		in.close();		
	}
}
