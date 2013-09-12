package 无根树转为有根树;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static final int  MAX = 10;
	@SuppressWarnings("unchecked")
	static ArrayList<Integer>[] s = new ArrayList[MAX];
	static void ini(ArrayList<Integer>[] s, int max) {
		for(int i = 0; i < max; i++)
			s[i] = new ArrayList<Integer>();
	}
		
	static Scanner in = new Scanner(System.in);
	static void read() {
		int n, u, v;
		n = in.nextInt();
		for (int i = 0; i < n - 1; i++) {
			u = in.nextInt();
			v = in.nextInt();
			s[u].add(v);
			s[v].add(u);
		}
	}
	
	static void dfs (int u, int fa) {
		for (int i = 0; i < s[u].size(); i++) {
			int v = s[u].get(i);
			if (v != fa) {
				dfs(v, u);
				System.out.println(v + "的父亲是" +  u);
			}
		}
	}	
	
	public static void main(String[] args) {
		ini(s, MAX);	
		read();
		dfs(1, -1);
		
	}
	 

}
