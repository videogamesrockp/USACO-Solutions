// http://www.usaco.org/index.php?page=viewproblem2&cpid=1301

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(r.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long[] days = new long[N];

        st = new StringTokenizer(r.readLine());

		for (int i = 0; i < N; i++) {
			days[i] = Long.parseLong(st.nextToken());
		}

		long ans = 0L;
        long exist = 0L;

		for (int i = 0; i < N - 1; i++) {
			if ((days[i + 1] - days[i]) <= K) {
				exist += 1;
			} else {
				ans += (days[i] - days[(int) (i - exist)]) + K + 1;
				exist = 0;
			}
		}
        
        ans += (days[N - 1] - days[(int) (N - 1 - exist)]) + K + 1;


        pw.println(ans);

		pw.close();

	}
}