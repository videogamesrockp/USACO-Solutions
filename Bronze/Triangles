import java.io.*;
import java.util.StringTokenizer;
import java.lang.Math;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("triangles.in"));
		PrintWriter pw = new PrintWriter("triangles.out");

		int N = Integer.parseInt(r.readLine());

		int[][] posts = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(r.readLine());
			posts[i][0] = Integer.parseInt(st.nextToken());
			posts[i][1] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;

		for (int i = 0; i < N; i++) {
			int height = 0;
			int width = 0;
			for (int j = 0; j < N; j++) {
				if (posts[i][0] == posts[j][0]) {
					height = Math.max(height, Math.abs(posts[i][1] - posts[j][1]));
				}
				if (posts[i][1] == posts[j][1]) {
					width = Math.max(width, Math.abs(posts[i][0] - posts[j][0]));
				}
			}

			ans = Math.max(ans, width * height);
		}

		pw.println(ans);

		pw.close();
	}
}
