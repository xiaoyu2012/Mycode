package hdu1005;

import java.util.Scanner;

/**
 * 2013.07.23 No.1
 * 
 * @author yyh Number Sequence f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) % 7
 *         f(n - 2)) mod 7 有规律，循环的
 */
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//int n, A, B;
		while(in.hasNext()) {
			int A = in.nextInt();
			int B = in.nextInt();
			int n = in.nextInt();
			int s;
			if (A == 0 && B == 0 && n == 0)
				continue;
			else {
				
				s = F(n, A, B) % 7;
				System.out.println("A=" + A + " B=" + B + " n=" + n);
				System.out.println(s);
			}
		}
		in.close();

	}

	public static int F(int a, int m, int n) {
		if (a == 1 || a == 2)
			return 1;
		else
			return m * (F(a - 1, m, n) % 7) + n *( F(a - 2, m, n) % 7);
	}
}
/*for(n = 0; n < 2; n++) 
	for (A = 0; A < 2; A++)
		for (B = 0; B < 2; B++)*/