// http://www.usaco.org/index.php?page=viewproblem2&cpid=856

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("blist.in"));
        PrintWriter pw = new PrintWriter("blist.out");

        int N = Integer.parseInt(r.readLine());

        int[] buckets_time_map = new int[1000];

        for (int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int buckets = Integer.parseInt(st.nextToken());
            for (int j = 0; j < end - start; j ++) {
                buckets_time_map[start + j] += buckets;
            }
        }
        int ans = 0;

        for (int i = 0; i < 1000; i ++) {
            ans = Math.max(ans, buckets_time_map[i]);
        }

        pw.println(ans);

        pw.close();
    }
}
