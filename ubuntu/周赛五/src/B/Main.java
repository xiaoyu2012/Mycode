package B;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);	
	String s;
	while(!(s = in.next()).equals("0") ) {
		BigInteger n = new BigInteger(s,2);
		//System.out.println(n.toString());	
		if(n.isProbablePrime(200))
			System.out.println("YES");
		else
			System.out.println("NO");		
	}
	in.close();
	}
}
