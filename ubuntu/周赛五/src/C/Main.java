package C;

import java.util.Scanner;

public class Main {
	static int x, y, d;
	
	static int gcd(int a, int b) {
		if(b == 0) {
			d = a;
			x = 1; 
			y = 0;
			return d;
		}
		int d = gcd(b, a % b);
		int tx = x;
		x = y;     //x = y'
		y = tx - a /b * y;      //y = x' - (a/b) * y
		return d;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T-- > 0) {
			int a = in.nextInt();
			int b = in.nextInt();
			if((a == 1 && b == 0) || (a == 0 && b == 1)) {
				System.out.println(1);
				continue;
			}
			if((a == 1 && b != 0) || (b == 1) && a != 0) {
				System.out.println(2);
				continue;
			}
			d = gcd(a, b);
			//System.out.println("d= " + d + "   x= " + x + "  y= " + y);
			if(d != 1) 
				System.out.println(-1);
			else
				System.out.println(Math.abs(x) + Math.abs(y) - 1);
			
		}
 		in.close();
	}
}
