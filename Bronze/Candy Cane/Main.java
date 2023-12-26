// http://usaco.org/index.php?page=viewproblem&cpid=1335, LIVE SUBMISSION

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(r.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] cows = new long[N];
        long[] candy_base = new long[M];
        long[] candy_full = new long[M];

        st = new StringTokenizer(r.readLine());

        for (int i = 0; i < N; i ++) {
            cows[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(r.readLine());

        for (int i = 0; i < M; i ++) {
            candy_full[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i ++) {
            for (int j = 0; j < N; j ++) {
                if (cows[j] >= candy_base[i]) {
                    long temp = Math.min(cows[j] - candy_base[i], candy_full[i] - candy_base[i]);
                    cows[j] += temp;
                    candy_base[i] += temp;
                }
            }
        }

        for (int i = 0; i < N; i ++) {
            pw.println(cows[i]);
        }

        pw.close();
    }
}