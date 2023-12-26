// http://usaco.org/index.php?page=viewproblem&cpid=1336, LIVE SUBMISSION

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(r.readLine());
        String[] cows = r.readLine().split("", 0);

        ArrayList<Integer> infected_groups = new ArrayList<Integer>();

        int current = 0; 
        for (int i = 0; i < N; i ++) {
            if (Integer.parseInt(cows[i]) == 1) {
                current += 1;
            }
            else {
                if (current > 0) {
                    infected_groups.add(current);
                }
                current = 0;
            }
        }

        if (current > 0) {
            infected_groups.add(current);
        }

        int shortest_cluster = N;
        for (int i = 0; i < infected_groups.size(); i ++) {
            if (Integer.parseInt(cows[0]) == 1 && i == 0) {
                shortest_cluster = (2*(infected_groups.get(0) - 1)) + 1;
            }
            else if (Integer.parseInt(cows[N-1]) == 1 && i == infected_groups.size() - 1) {
                shortest_cluster = Math.min((2*(infected_groups.get(infected_groups.size() - 1)-1)) + 1, shortest_cluster);
            }
            else if (infected_groups.get(i) < shortest_cluster) {
                shortest_cluster = infected_groups.get(i) + (infected_groups.get(i) % 2) - 1;
            }
        }

        int ans = 0;
        
        for (int i: infected_groups) {
            ans += (int)Math.ceil((double)i / (double)(shortest_cluster));
        }
            
        pw.println(ans);

        pw.close();

    }
}