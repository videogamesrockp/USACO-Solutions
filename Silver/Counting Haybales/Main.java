// http://www.usaco.org/index.php?page=viewproblem2&cpid=666

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter pw = new PrintWriter("haybales.out");

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] haybales = new int[N];
        int[][] queries = new int[Q][2];

        st = new StringTokenizer(r.readLine());

        for (int i = 0; i < N; i ++) {
            haybales[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < Q; i ++) {
            String[] query = r.readLine().split(" ");
            for (int j = 0; j < 2; j ++) {
                queries[i][j] = Integer.parseInt(query[j]);
            }
        }

        Arrays.sort(haybales);

        for (int[] i: queries) {
			int lower = Arrays.binarySearch(haybales, i[0]);
			if (lower < 0) {
                lower = Math.abs(lower + 1);
            }

			int higher = Arrays.binarySearch(haybales, i[1]);
			if (higher < 0) {
                higher = Math.abs(higher + 2);
            }

            pw.println(higher - lower + 1);
        }

        pw.close();
    }
}
