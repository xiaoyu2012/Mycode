	import java.util.*;
	public class Main3
	{
		static{
			Scanner in=new Scanner(System.in);
			int a=in.nextInt();
			int b=in.nextInt();
			if(a>=b)System.out.println(a-b);
			else{
				int cnt=0,l=0;
				if(a==0)a=l=1;
				cnt=(int)(Math.log(b/a)/Math.log(2));
				int g=(int)Math.pow(2, cnt);
				cnt+=l;a*=g;
				int h=f(a*2-b,g*2)+1;
				int k=f(b-a,g);
				System.out.println(Math.min(k,h)+cnt);
				}
			in.close();
			System.exit(0);
		}
		static int f(int l,int n)
		{
			if(n==0)return 0;
			int a=l%n,b=a;
		   	l=l/n;
		   	a=f(n-a,n/2)+l+1;
		   	b=f(b,n/2)+l;
		   return Math.min(a, b);
		}
	}