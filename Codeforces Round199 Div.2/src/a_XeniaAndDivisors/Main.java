package a_XeniaAndDivisors;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] m = new int[n];
		int[] a = new int[6];
		boolean flag = false;
		for(int i = 0; i < n; i++) {   //输入n个数据，并用a[i]计数
			m[i] = in.nextInt();
			if(m[i] == 5 || m[i] == 7)
				flag = true;   //如果出现5或者7，直接输出-1；
			switch (m[i]) {
			case 1: a[0]++;	break;
			case 2: a[1]++;	break;
			case 3: a[2]++;	break;
			case 4: a[3]++; break;
			case 6: a[4]++; break;
			default : break;
			}
			
		}
		
		if(flag == true) 		
			System.out.println(-1);
		else if(a[0] == 1 && a[2] == 1 && a[3] == 1)  //如果是1 3 4，输出-1；
			System.out.println(-1);
		else {
			if(a[1] >= a[3] && a[3] + a[4] == a[0] && a[1] + a[2] == a[0]) {  //判断的条件
				for(int i = 0; i < a[3]; i++)
					System.out.println("1 2 4");
				for(int i = 0; i < a[2]; i++)
					System.out.println("1 3 6");
				for(int i = 0; i < a[0] - a[2] - a[3]; i++)
					System.out.println("1 2 6");
			}
			else
				System.out.println(-1);
				
		}
			
		in.close();
		
	}

}
/*

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] m = new int[n];
		int[] a = new int[6];
		boolean flag = false;
		for(int i = 0; i < n; i++) {   
			m[i] = in.nextInt();
			if(m[i] == 5 || m[i] == 7)
				flag = true;  
			switch (m[i]) {
			case 1: a[0]++;	break;
			case 2: a[1]++;	break;
			case 3: a[2]++;	break;
			case 4: a[3]++; break;
			case 6: a[4]++; break;
			default : break;
			}
			
		}
		
		if(flag == true) 		
			System.out.println(-1);
		else if(a[0] == 1 && a[2] == 1 && a[3] == 1) 
			System.out.println(-1);
		else {
			if(a[1] >= a[3] && a[3] + a[4] == a[0] && a[1] + a[2] == a[0]) { 
				for(int i = 0; i < a[3]; i++)
					System.out.println("1 2 4");
				for(int i = 0; i < a[2]; i++)
					System.out.println("1 3 6");
				for(int i = 0; i < a[0] - a[2] - a[3]; i++)
					System.out.println("1 2 6");
			}
			else
				System.out.println(-1);
				
		}
			
		in.close();
		
	}

}
*/
