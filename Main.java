// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		int N = Integer.parseInt(r.readLine());

		StringTokenizer st = new StringTokenizer(r.readLine());

		int[] cows = new int[N];

		for (int i = 0; i < N; i++) {
			cows[i] = Integer.parseInt(st.nextToken());
		}

		long ans = 0L;
		int tuition = 0;
		Arrays.sort(cows);
		for (int i = N - 1; i >= 0; i--) {
			if (((long)(N - i) * (long)cows[i]) >= ans) {
				ans = ((long)(N - i) * (long)cows[i]);
				tuition = cows[i];
			}
		}

		pw.print(ans + " " + tuition);

		pw.close();
	}
}
