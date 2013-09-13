package 打印出1到n中所有欧拉函数的值;

import java.util.Scanner;
//import java.lang.Math;
public class Main {
	static int n;
	static int[] S;
	static final int N = 1000;
	
	static void eulerPhiTable(int n) {
		//	S[i] 已经被初始化为0； 
		S[1] = 1;
		for(int i = 2; i <= n; i++)
			if(S[i] == 0)
				for(int j = i; j <= n; j += i) {
					if(S[j]==0)
						S[j] = j;
					S[j] = S[j] / i * (i - 1);
				}	
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		S = new int[n + 1];
		eulerPhiTable(n);
		for(int i : S)
		System.out.print(i + " ");
		in.close();
		
	}
}     

