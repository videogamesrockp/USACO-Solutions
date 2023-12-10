// http://www.usaco.org/index.php?page=viewproblem2&cpid=665

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("cowsignal.in"));
		PrintWriter pw = new PrintWriter("cowsignal.out");

        StringTokenizer st = new StringTokenizer(r.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        char[][] initial = new char[M][N];

        for (int i = 0; i < M; i ++) {
            char[] line = r.readLine().toCharArray();
            for (int j = 0; j < N; j ++) {
                initial[i] = line;
            }
        }

        char[][] ans = new char[M*K][N*K];

        for (int i = 0; i < M; i ++) {
            for (int j = 0; j < N; j ++) {
                for (int x = 0; x < K; x ++) {
                    for (int y = 0; y < K; y ++) {
                        ans[(i * K) + x][(j * K) + y] = initial[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < M*K; i ++) {
            for (int j = 0; j < N * K; j++) {
                pw.print(ans[i][j]);
            }
            pw.println("");
        }

        pw.close();
	}
}