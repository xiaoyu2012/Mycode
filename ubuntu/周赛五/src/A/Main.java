package A;

import java.util.Scanner;

public class Main {
	public static long A, B, h;
	public static long H, day, s;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T-- > 0) {
			A = in.nextLong();
			B = in.nextLong();
			H = in.nextLong();
			h = A - B;
			day = 0;
			s = 0;
			if(A >= H) {
				System.out.println(1);
				continue;
			}
			day = (H - A) / h;
			s = day * h;
			//System.out.println(day);	
			//System.out.println(s);	
			while(H - s > A) {
				s += h;
				day++;
			}
			day++;			
			System.out.println(day);			
		}
		in.close();
	}
}
