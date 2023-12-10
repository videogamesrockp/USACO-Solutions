// http://www.usaco.org/index.php?page=viewproblem2&cpid=568

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter pw = new PrintWriter("speeding.out");
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] miles = new int[100][2];

        int mile_at = 0;
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(r.readLine());
            int length = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());
            for (int j = 0; j < length; j ++) {
                miles[mile_at + j][0] = limit;
            }
            mile_at += length;
        }

        mile_at = 0;
        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(r.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for (int j = 0; j < length; j ++) {
                miles[mile_at + j][1] = speed;
            }
            mile_at += length;
        }

        int ans = 0;
        for (int i = 0; i < 100; i ++) {
            if (miles[i][1] - miles[i][0] > ans) {
                ans = miles[i][1] - miles[i][0];
            }
        }

        pw.println(ans);

        pw.close();
    }
}