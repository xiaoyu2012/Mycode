package B;

import static java.lang.System.out;

//import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static class Pair implements Comparable<Pair> {
        private static final short[][] delta = {{0, 1, 0, -1}, {1, 0, -1, 0}};
        private final int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Pair that) {
            if (this.x != that.x)
                return this.x-that.x;
            return this.y-that.y;
        }
        public Iterable<Pair> neighbors() {
            ArrayList<Pair> result = new ArrayList<Pair>();
            for (int i = 0; i < 4; i++)
                result.add(new Pair(x+delta[0][i], y+delta[1][i]));
            return result;
        }
    }
    
    
    private static int[] bazinga(char[][] m, Pair u) {
        int[] result = {0, 0};
        if (m[u.x][u.y]=='W')
            result[0] = 1;
        else if (m[u.x][u.y]=='S')
            result[1] = 1;
        m[u.x][u.y] = '#';
        for (Pair v : u.neighbors())
            if (v.x>=0 && v.x<m.length && v.y>=0 && v.y<m[0].length && m[v.x][v.y]!='#') {
                int[] t = bazinga(m, v);
                result[0] += t[0];
                result[1] += t[1];
            }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        //Scanner in = new Scanner(new File("input.txt"));
        while (in.hasNext()) {
            int x = Integer.parseInt(in.next()), y = Integer.parseInt(in.next());
            char[][] m = new char[x][];
            for (int i = 0; i < x; i++)
                m[i] = in.next().toCharArray();
            int result = 0;
            for (int i = 0; i < x; i++)
                for (int j = 0; j < y; j++)
                    if (m[i][j] != '#') {
                        int[] t = bazinga(m, new Pair(i, j));
                        if (t[0] == 0)
                            result += t[1];
                    }
            out.println(result);
        }
        in.close();
    }

}