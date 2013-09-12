import java.util.LinkedList;
import java.util.Scanner;
import java.lang.Math;

/**
 * 20130802 No.1 POJ3278
 * @author YH YANG
 */


public class Main {
	static class Node {			
			public Node (int n) {
				this.n = n;
				a = this.n - 1;
				b = this.n + 1;
				c = this.n * 2;	
			}		
			
			public int getA()  {
				return a;
			}
			public int getB()  {
				return b;
			}
			public int getC()  {
				return c;
			}
				
			private int n, a,b, c;		

		}
	
	
	public static int N, K, flag;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
		in.close();	
		int time = 0;
		LinkedList<Node> s = new LinkedList<Node>();
		s.add(new Node(N));
		Node now = s.poll();
		while (now.getA() != K && now.getB() != K && now.getC() != K) {
			s.add(new Node(now.getA())); time++;
			s.add(new Node(now.getB())); time++;			
			s.add(new Node(now.getC())); time++;
			now = s.poll();			
		}
		//time = s.size();
		double ans;	
		ans = Math.log10(1.0 + (2.0 / 3.0) * time*1.0) /  Math.log10(3.0);
		//System.out.println(time);
		//System.out.println(ans);
		System.out.println((int)ans + 1);		
	}
}
