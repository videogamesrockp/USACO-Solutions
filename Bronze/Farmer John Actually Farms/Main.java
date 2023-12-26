// http://usaco.org/index.php?page=viewproblem&cpid=1337, LIVE SUBMISSION

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

        int T = Integer.parseInt(r.readLine());

        for (int i = 0; i < T; i ++) {
            int N = Integer.parseInt(r.readLine());

            long[][] plants = new long[N][2];
            int[] likeability = new int[N];


            HashMap<Integer, Long> likeability_to_plants = new HashMap<Integer, Long>();
            HashMap<Integer, Long> likeability_to_growth = new HashMap<Integer, Long>();

            StringTokenizer st = new StringTokenizer(r.readLine());

            for (int j = 0; j < N; j ++) {
                plants[j][0] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(r.readLine());

            for (int j = 0; j < N; j ++) {
                plants[j][1] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(r.readLine());

            for (int j = 0; j < N; j ++) {
                likeability[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < N; j ++) {
                likeability_to_plants.put(likeability[j], plants[j][0]);
            }

            for (int j = 0; j < N; j ++) {
                likeability_to_growth.put(likeability[j], plants[j][1]);
            }

            long lower_bound = -1L;
            long upper_bound = Long.MAX_VALUE;
            boolean possible = true;

            for (int j = 1; j < N; j ++) {
                if (likeability_to_plants.get(j - 1) > likeability_to_plants.get(j)) {
                    if (likeability_to_growth.get(j - 1) < likeability_to_growth.get(j)) {
                        upper_bound = Math.min((likeability_to_plants.get(j - 1) - likeability_to_plants.get(j))/(likeability_to_growth.get(j) - likeability_to_growth.get(j - 1)), upper_bound);
                    }
                }
                else {
                    if (likeability_to_growth.get(j - 1) > likeability_to_growth.get(j)) {
                        lower_bound = Math.max(lower_bound, (likeability_to_plants.get(j) - likeability_to_plants.get(j - 1))/(likeability_to_growth.get(j - 1) - likeability_to_growth.get(j)));
                    }
                    else {
                        pw.println(-1);
                        possible = false;
                        break;
                    }
                }
            }
            
            if (possible) {
                if (upper_bound < lower_bound) {
                    pw.println(-1);
                }
                else {
                    pw.println(lower_bound + 1);
                }
            }

        }
        pw.close();
    }
}