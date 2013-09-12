package C;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 2013.08.04 No.2    Problem C: 忍者的逆袭
 * @author yyh
 */
public class Main {
	static int T, n, m;
	static String[] s;
	static int[][] a;
	static boolean[][] is;
	 static class Node {
		 public Node(int ll, int h, int wh) {
			 this.ll = ll;
			 this.h = h;
			 this.wh = wh;
		 }		 
		 public int ll, h, wh;
	 }
	 
	 public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 T = in.nextInt();
		 while(T-- > 0) {
			 n = in.nextInt();
			 m = in.nextInt();
			 s = new String[2];
			 s[0] = in.next();
			 s[1] = in.next();
			 a = new int[2][n + 4];
			 is = new boolean[2][n + 4];
			 for (int i = 0; i < 2; i++) {
				 for (int j = 1; j <= n; j++)
					 a[i][j] = s[i].charAt(j - 1) == '-' ? 1 : 0;
				 for (int j = n + 1; j <= n + 3; j++)
					 a[i][j] = 1;
			 }
	
			 boolean flag = true;
			/*for (int[] n : a) {
				 for (int m : n)
					 System.out.print(m);
				 System.out.println();
			 }*/
			 
			 LinkedList<Node> l = new LinkedList<Node>();
			 l.add(new Node(0, 0 ,0));
			 Node now = l.pop();
			
			 do {
				 if (a[now.ll][now.h + 1] == 1 && is[now.ll][now.h + 1] == false) {
					 l.add(new Node(now.ll, now.h + 1, now.wh + 1));
					 is[now.ll][now.h + 1] = true;
				 }
				 if (now.h != 0 && a[now.ll][now.h - 1] == 1 && is[now.ll][now.h - 1] == false) {
					 l.add(new Node(now.ll, now.h - 1, now.wh + 1));
					 is[now.ll][now.h - 1] = true;
				 }
				 if (now.h + m <= n && a[(now.ll + 1) % 2][now.h + m] == 1 && is[(now.ll + 1) % 2][now.h + m] == false) {
					 l.add(new Node((now.ll + 1) % 2, now.h + m, now.wh + 1));
					 is[(now.ll + 1) % 2][now.h + m] = true;
				 }
				 if(l.isEmpty()) {
					 flag = false;
					 break;
				 }
				 else
					 now = l.pop();	
				 if(now.wh > now.h) {
					 flag = false;
					 break;
				 }
				 
			 } while  (now.h <= n);
			 
			 if (flag == false)
				 System.out.println("NO");
			 else					
				 System.out.println("YES");
		 }
		 in.close();	 
	 }

}
