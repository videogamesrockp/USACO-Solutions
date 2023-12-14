// http://www.usaco.org/index.php?page=viewproblem2&cpid=1275

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		int N = Integer.parseInt(r.readLine());
		
		char[] breeds = r.readLine().toCharArray();
		int[] lists = new int[N];

		int first_G = -1;
		int first_H = -1;
		int last_G = -1;
		int last_H = -1;

		int ans = 0;


		StringTokenizer st = new StringTokenizer(r.readLine());

		for (int i = 0; i < N; i++) {
			lists[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		for (int i = 0; i < N; i++) {
			if (breeds[i] == 'G') {
				first_G = i;
				break;
			}
		}

		for (int i = 0; i < N; i++) {
			if (breeds[i] == 'H') {
				first_H = i;
				break;
			}
		}

		for (int i = N - 1; i >= 0; i--) {
			if (breeds[i] == 'G') {
				last_G = i;
				break;
			}
		}

		for (int i = N - 1; i >= 0; i--) {
			if (breeds[i] == 'H') {
				last_H = i;
				break;
			}
		}

		if (lists[first_G] >= last_G) {
			for (int i = 0; i < first_G; i++) {
				if (i == first_H) {
					continue;
				}
				if (breeds[i] == 'H' && lists[i] >= first_G) {
					ans++;
				}
			}
		}

		if (lists[first_H] >= last_H) {
			for (int i = 0; i < first_H; i++) {
				if (i == first_G) {
					continue;
				}
				if (breeds[i] == 'G' && lists[i] >= first_H) {
					ans++;
				}
			}
		}

		if ((lists[first_G] >= last_G || (first_G <= first_H && lists[first_G] >= first_H)) && (lists[first_H] >= last_H || (first_H <= first_G && lists[first_H] >= first_G))) {
			ans++;
		}

		pw.println(ans);

		pw.close();
	}
}
