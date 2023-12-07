// http://www.usaco.org/index.php?page=viewproblem2&cpid=891

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("shell.in"));
		PrintWriter pw = new PrintWriter("shell.out");

		int N = Integer.parseInt(r.readLine());
		int [][] swaps = new int[N][3];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(r.readLine());
			swaps[i][0] = Integer.parseInt(st.nextToken()) - 1;
			swaps[i][1] = Integer.parseInt(st.nextToken()) - 1;
			swaps[i][2] = Integer.parseInt(st.nextToken()) - 1;
		}

		int[] a1 = new int[3];
		int[] a2 = new int[3];

		for (int i = 0; i < 3; i++) {
			a2[i] = i;
		}

		for (int i = 0; i < N; i ++) {
			int temp = a2[swaps[i][0]];
			a2[swaps[i][0]] = a2[swaps[i][1]];
			a2[swaps[i][1]] = temp;
			a1[a2[swaps[i][2]]] += 1;
		}
		int max = 0;
		for (int i = 0; i < 3; i ++) {
			if (a1[i] > max) {
				max = a1[i];
			}
		}
		pw.println(max);

		pw.close();
	}
}
