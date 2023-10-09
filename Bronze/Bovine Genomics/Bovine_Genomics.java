// http://www.usaco.org/index.php?page=viewproblem2&cpid=736

import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("cownomics.in"));
		PrintWriter pw = new PrintWriter("cownomics.out");

		StringTokenizer st = new StringTokenizer(r.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] spotted_cows = new String[n];
		String[] plain_cows = new String[n];

		for (int i = 0; i < n; i++) {
			spotted_cows[i] = r.readLine();
		}

		for (int i = 0; i < n; i++) {
			plain_cows[i] = r.readLine();
		}

		int ans = 0;

		for (int i = 0; i < m; i++) {
			HashSet<Character> in_plain = new HashSet<Character>();
			for (int j = 0; j < n; j++) {
				in_plain.add(plain_cows[j].charAt(i));
			}
			boolean dupe = false;
			for (int j = 0; j < n; j ++) {
				if (in_plain.contains(spotted_cows[j].charAt(i))) {
					dupe = true;
					break;
				}
			}
			if (!dupe) {
				ans += 1;
			}
		}
		pw.println(ans);

		pw.close();
	}
}
