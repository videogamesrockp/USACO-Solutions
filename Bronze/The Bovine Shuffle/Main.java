// http://www.usaco.org/index.php?page=viewproblem2&cpid=760

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter pw = new PrintWriter("shuffle.out");

        int N = Integer.parseInt(r.readLine());

        int[] shuffles = new int[N];
        int[][] lineups = new int[4][N];

        StringTokenizer st = new StringTokenizer(r.readLine());

        for (int i = 0; i < N; i ++) {
            shuffles[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        st = new StringTokenizer(r.readLine());

        for (int i = 0; i < N; i ++) {
            lineups[0][i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < 4; i ++) {
            for (int j = 0; j < N; j ++) {
                lineups[i][j] = lineups[i - 1][shuffles[j]];
            }
        }

        for (int i = 0; i < N; i ++) {
            pw.println(lineups[3][i]);
        }

        pw.close();
    }
}
