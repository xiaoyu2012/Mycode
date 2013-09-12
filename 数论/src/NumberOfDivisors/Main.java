package NumberOfDivisors;
import java.util.Scanner;

public class Main {
	static int n, i, tn;
	static int[] e;
	static final int N = 1000;
	int total = 1;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		e = new int[N];
		System.out.print(n + "=");
		tn = n;
		for(i = 2; i * i <= n; i++)
			while(n != i) {
				if(n % i == 0) {
					System.out.print(i + "*");
					e[i]++;   //指数存放在e[i]中
					n = n / i;
				}
				else
					break;				
			}
		e[n]++;
		System.out.println(n);
		
		System.out.print(tn + "=");
		for(int k = 2; k < i; k++)
			if(e[k] != 0)
				System.out.print(k +"^" + e[k] + " * ");
		System.out.println(n + "^" + e[n]);		
		in.close();
		
	}	

}
