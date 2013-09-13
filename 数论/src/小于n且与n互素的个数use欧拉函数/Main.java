package 小于n且与n互素的个数use欧拉函数;

import java.util.Scanner;
//import java.lang.Math;
public class Main {
	static int n;
	
	static int eulerPhi(int n) {
		int ans = n;
		int m = (int) Math.sqrt(n + 0.5);
		
		for(int i = 2; i <= m; i++)
			if(n % i == 0) {
				ans = ans / i * (i - 1);
				while(n % i == 0)
					n = n / i;
			}
		if(n > 1) ans = ans / n * (n - 1);
		
		return ans;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int s = eulerPhi(n);
		System.out.println(s);
		in.close();
		
	}
}
