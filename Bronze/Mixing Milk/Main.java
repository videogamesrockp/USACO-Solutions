// http://www.usaco.org/index.php?page=viewproblem2&cpid=855

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter pw = new PrintWriter("mixmilk.out");

        int[][] buckets = new int[3][2];

        for (int i = 0; i < 3; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            buckets[i][0] = Integer.parseInt(st.nextToken());
            buckets[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 100; i ++) {
            int a = i % 3;
            int b = (i + 1) % 3;
            int diff = Math.min(buckets[a][1], buckets[b][0] - buckets[b][1]);
            buckets[a][1] -= diff;
            buckets[b][1] += diff;
        }

        for (int i = 0; i < 3; i ++) {
            pw.println(buckets[i][1]);
        }

        pw.close();
    }
}
