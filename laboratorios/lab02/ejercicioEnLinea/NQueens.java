import java.io.*;
import java.util.*;
/**
 * Write a description of class f here.
 * 
 * @author Camilo Cruz Villegas, Cristian Villamizar
 * @version (a version number or a date)
 */
public class NQueens {
    static int N;
    final static int MAXN = 15;
    final static int total=15;
    static boolean [][] ha;
    
    public static int resolver(int mask, int col, int arriba, int abajo, int fondo) {
        if(col == mask)
            return 1;
        int res = 0;
        int pos = mask &~ (col | arriba | abajo);
        while(pos >0) {
            int p = pos & (-pos);     
            pos = pos - p;
            if(ha[fondo][p] == false) {
                res += resolver(mask, (col+p), (arriba+p) << 1, (abajo+p) >>1, fondo+1);
            }
        }
        return res;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }
        public String next() {
            try {
                while (tokenizer == null || !tokenizer.hasMoreTokens())
                    tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return tokenizer.nextToken();
        }
        public String nextLine() {
            String line = null;
            try {
                tokenizer = null;
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int t = 1;
        while(true) {
            N = in.nextInt();
            if (N == 0)
                break;
            int mask = (1 <<N) -1;
            char[][] map = new char[N][N];
            ha = new boolean[16][1<<MAXN];
            for(int i=0; i < N; i++)
                map[i] = in.nextLine().toCharArray();
            for(int i=0; i < N; i++) {
                for(int j=0; j < N; j++) {
                    if(map[i][j] == '*')
                        ha[i][1<<j] =true;
                }
            }
            System.out.println("Case " + t + ": " + resolver(mask, 0, 0, 0, 0));
            t++;
        }
    }
}