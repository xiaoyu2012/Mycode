package 无平方因子的数squarefreenumber;

import java.util.Scanner;

/*
 * * * 1 <= n <= 10^12,  用数组存不下
 *
 public class Main {
 public static void main(String[] args) {
 Scanner in = new Scanner(System.in);
 int T = in.nextInt();
 while (T-- > 0) {
 int n = in.nextInt();
 boolean[] vis = new boolean[n + 1];	
 boolean[] vis2 = new boolean[n + 1];
 int m = (int)Math.sqrt(n + 0.5);
 int[] prime = new int[m];
 int c = 0;
 int count = 0;
 for(int i = 2; i <= m; i++)
 if(vis[i] == false) {
 prime[c++] = i;
 for(int j = i * i; j <= n; j += i)
 vis[j] = true;
 }

 for(int i = 0; i < c; i++)
 for(int j = prime[i] * prime[i]; j <= n; j += prime[i] * prime[i])
 vis2[j] = true;

 for(int i = 1; i <= n; i++) 
 if(vis2[i] == false) {
 //System.out.print(i + " ");
 count++;
 }					
 System.out.println(count);

 }			

 in.close();

 }
 }*/

/**
 * 用容斥原理，先求n中的有平方因子树sum， 再n - sum; 发现可以利用容斥原理，很简单，n之内有平方因子的数的个数 sum = n/(2^2) +
 * n/(3^2)+……+n/(k^2) - n/(2^2 * 3^2)-……+……。
 **/
public class Main {
	static final int MAX = 1000010;
	static int[] prime = new int[MAX / 2];


	public static void main(String[] args) {
		boolean[] vis = new boolean[MAX];
		//int c = InitPrime(prime);
		int c = InitPrime(prime, vis);
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			long n = in.nextLong();

			int m = (int) Math.sqrt(n + 0.5);
	
			//boolean[] vis = new boolean[m + 1];
	
			/*
			 * int c = 0; for (int i = 2; i <= m; i++) if (vis[i] == false) {
			 * prime[c++] = i; for (int j = i * i; j <= m; j += i) vis[j] =
			 * true; }
			 */
			// System.out.println("c = " + c + "m = " + m);
			long sum;
			sum = SquareRoot(0, 1, prime, m, n, c);
			System.out.println(n - sum);

		}

		in.close();

	}

	static long SquareRoot(int s, long d, int[] prime, int m, long n, int c) {
		long sum = 0;
		while (s < c && (long) prime[s] * prime[s] <= n / d) {
			sum += n / (d * prime[s] * prime[s])
					- SquareRoot(s + 1, d * prime[s] * prime[s], prime, m, n, c);
			s++;
		}
		return sum;
	}

/*	static int InitPrime(int[] prime) {
		int i, j;
		int cnt = 0;
		int[] a = new int[MAX];
		for (i = 2; i < MAX; i++) {
			if (a[i] == 0)
				prime[cnt++] = i;
			for (j = 0; j < cnt && i * prime[j] < MAX; j++) {
				a[i * prime[j]] = 1;
				if (i % prime[j] == 0)
					break;
			}
		}
		return cnt;
	}*/
	static int  InitPrime(int[] prime,boolean[] vis){  
		int cnt = 0;
	    for(int i=2;i<MAX;i++){  
	        if(vis[i]) continue;  
	        prime[cnt++]=i;  
	        for(int j=2;j*i<MAX;j++)  
	            vis[i*j]=true;  
	    }  
	    return cnt;
	}     
}
