import java.util.LinkedList;
import java.util.Scanner;

/**
 * 20130802 No.1 POJ3278
 * 
 * @author YH YANG
 */

public class Main2 {

	public static class Node {
		public Node(int time, int n) {
			this.time = time;
			this.n = n;
		}

		public int time, n;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int[] is = new int[200000];
		LinkedList<Node> s = new LinkedList<Node>();
		s.add(new Node(0, N));
		Node now = s.pop();
		is[N] = 1;
		while (now.n != K) {
			int time = now.time;
			int n = now.n;
			if (n - 1 >= 0 && n - 1 <= 100000 && is[n - 1] == 0) {				
				s.add(new Node(time + 1, n - 1));
				is[n - 1] = 1;
			}
			if (n + 1 >= 0 && n + 1 <= 100000 && is[n + 1] == 0) {				
				s.add(new Node(time + 1, n + 1));
				is[n + 1] = 1;
			}
			if (n * 2 >= 0 && n * 2 <= 100000 && is[n * 2] == 0) {				
				s.add(new Node(time + 1, n * 2));
				is[n * 2] = 1;
			}	
			now = s.pop();
			//System.out.println("n=" + now.n + " time=" + now.time);
		}
		System.out.println(now.time);
		in.close();

	}

}
