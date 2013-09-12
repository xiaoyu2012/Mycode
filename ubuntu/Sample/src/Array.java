public class Array{
	public static void main(String[] args){
	    int M = 4;	    
	    double[][] a = new double[M][M];
	    double[][] b = new double[M][M];
            int N = a.length;
        System.out.println(N);
	    for(int i = 0;i < N; i++)
		for(int j = 0;j < N;j++)
		    {
			a[i][j] = i+1;
			b[i][j] = i+2;
		    }
	    double[][] c = new double[N][N];
	    for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
		    { // 计算行 i 和列 j 的点乘
			for (int k = 0; k < N; k++)
			    c[i][j] += a[i][k]*b[k][j];
	            }
	    for(int i = 0;i < N;i++)
		for(int j = 0;j < N;j++) {
			
		    System.out.print("\t"+c[i][j]);
		    if (j == 3)
		    	System.out.println();
		}
	}
}
