package 表达式树;

import java.util.Scanner;

/*public class Main {
	static final int MAX = 1000;
	static int[] lch = new int[MAX];
	static int[] rch = new int[MAX];
	static char[] op = new char[MAX];
	static char[] input = new char[MAX];
	static int nc = 0;

	static int buildTree(char[] s, int x, int y) {
		int i, c1 = -1, c2 = -1, p = 0;
		int u;
		if (y - x == 1) {
			u = nc++;
			lch[u] = rch[u] = 0;
			op[u] = s[x];
			return u;
		}
		
		for (i = x; i < y; i++) {
			switch(s[i]) {
			case '(' : {
				p++;	break;
			}
			case ')' : {
				p--; 	break;
			}
			case '+' :
			case '-' :
				if(p == 0) {
					c1 = i;		break;
				}
			case '*' :
			case '/' :
				if(p == 0) {
					c2 = i; 	break;
				}
			}
		}
				if(c1 < 0)
					c1 = c2;
				if(c1 < 0) 
					return buildTree(s, x + 1, y -1);
				
				u = nc++;
				lch[u] = buildTree(s, x, c1);
				rch[u] = buildTree(s, c1 + 1, y);
				op[u] = s[c1];
				return u;				
		
	}
	
	static int transTree(int cur) {
		if (lch[cur] == 0 || rch[cur] == 0)
			return op[cur] - '0';
		else {
			int l = transTree(lch[cur]);
			int r = transTree(rch[cur]);
			
			switch (op[cur]) {
			case '+' :
				return l + r;
			case '-' :
				return l -r;
			case '*' :
				return l * r;
			case '/' :
				return l / r;	
			default :
					return 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		input =  in.next().toCharArray();
		buildTree(input, 0, input.length);
		System.out.println(transTree(0));
		in.close();
	}
	
	
	
}*/
public class Main {
	final int MAX = 1000;
	int[] lch = new int[MAX];
	int[] rch = new int[MAX];
	char[] op = new char[MAX];
	char[] input = new char[MAX];
	int nc = 0;

	int buildTree(char[] s, int x, int y) {
		int i, c1 = -1, c2 = -1, p = 0;
		int u;
		if (y - x == 1) {
			u = nc++;
			lch[u] = rch[u] = 0;
			op[u] = s[x];
			return u;
		}
		
		for (i = x; i < y; i++) {
			switch(s[i]) {
			case '(' : {
				p++;	break;
			}
			case ')' : {
				p--; 	break;
			}
			case '+' :
			case '-' :
				if(p == 0) {
					c1 = i;		break;
				}
			case '*' :
			case '/' :
				if(p == 0) {
					c2 = i; 	break;
				}
			}
		}
				if(c1 < 0)
					c1 = c2;
				if(c1 < 0) 
					return buildTree(s, x + 1, y -1);
				
				u = nc++;
				lch[u] = buildTree(s, x, c1);
				rch[u] = buildTree(s, c1 + 1, y);
				op[u] = s[c1];
				return u;				
		
	}
	
	int transTree(int cur) {
		if (lch[cur] == 0 || rch[cur] == 0)
			return op[cur] - '0';
		else {
			int l = transTree(lch[cur]);
			int r = transTree(rch[cur]);
			
			switch (op[cur]) {
			case '+' :
				return l + r;
			case '-' :
				return l -r;
			case '*' :
				return l * r;
			case '/' :
				return l / r;	
			default :
					return 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Main mm = new Main();
		Scanner in = new Scanner(System.in);
		mm.input =  in.next().toCharArray();
		mm.buildTree(mm.input, 0, mm.input.length);
		System.out.println(mm.transTree(0));
		in.close();
	}	
}

