// http://www.usaco.org/index.php?page=viewproblem2&cpid=572

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("bcount.in"));
        PrintWriter pw = new PrintWriter("bcount.out");

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[][] cows = new int[N][3];
        int[][] queries = new int[Q][2];
        int[][] cows_presum = new int[N + 1][3];

        for (int i = 0; i < N; i ++) {
            int cow = Integer.parseInt(r.readLine()) - 1;
            cows[i][cow] = 1;
        }

        for (int i = 0; i < Q; i ++) {
            st = new StringTokenizer(r.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken()) - 1;
            queries[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }
        
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < 3; j ++) {
                cows_presum[i + 1][j] = cows_presum[i][j] + cows[i][j];
            }
        }

        for (int i = 0; i < Q; i ++) {
            for (int j = 0; j < 3; j ++) {
                if (j == 2) {
                pw.print(cows_presum[queries[i][1] + 1][j] - cows_presum[queries[i][0]][j]);
                }
                else {
                    pw.print(cows_presum[queries[i][1] + 1][j] - cows_presum[queries[i][0]][j] + " ");
                }
            }
            pw.println("");
        }

        pw.close();
    }
}