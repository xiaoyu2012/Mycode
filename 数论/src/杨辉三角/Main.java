package Ñî»ÔÈý½Ç;

import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		long N, M;
		while(in.hasNext()) {
			M = in.nextLong();
			N = in.nextLong();
			long min = M;
			long i;
			if(M < N)
				System.out.println(-1);
			else {
				long mod = M / (N - 1);
				for(i = mod; i > 0; i--) {		
					if(M - i * (N -1) > 0 && M - i * (N - 1) != i) {
						min =  M - i * (N - 1);
					    break;
					}
				}
				System.out.println(min);
			}
			
			
		}
		in.close();
				
		}
		
		
	}


