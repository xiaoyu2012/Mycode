public class DisjointSet {

	//private int N;
	private int[] p;
	
	
	public DisjointSet(int a) {
		//N = a;
		p = new int[a];
		for(int i=0;i<a;i++)
		    p[i]=i;
	}
	
	public void union(int a, int b) {
		int m;
		m=b;
		while(p[m]!=m)
			m=p[m];
		p[b]=m;
		m=a;
		while(p[m]!=m)
			m=p[m];
		p[a]=m;
		p[p[b]]=p[a];
	}
	
	public boolean find(int a, int b) {
		while(p[b]!=b)
			b=p[b];
		while(p[a]!=a)
			a=p[a];
		return a==b;
		
	}
	
	
	
}
