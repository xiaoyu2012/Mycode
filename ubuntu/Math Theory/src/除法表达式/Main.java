package 除法表达式;

import java.util.Scanner;

public class Main {
	
	static int gcd(int a, int b) {
		while(b != 0) {
			int m = a % b;
			a = b;
			b = m;
		}
		return a;
	}
	
	static boolean judge(int[] x,int K) {
		x[2] /= gcd(x[2],x[1]);
		for(int i = 3; i <= K; i++)
			x[2] /= gcd(x[i], x[2]);
		if(x[2] == 1)
			return true;
		else
			return false;		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int K = in.nextInt();
		int[] X = new int[K + 1];
		for(int i = 1; i <= K; i++)
			X[i] = in.nextInt();
		System.out.println(judge(X,K));
		
		in.close();
	}
}
