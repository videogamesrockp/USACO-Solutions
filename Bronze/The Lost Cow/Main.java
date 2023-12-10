// http://www.usaco.org/index.php?page=viewproblem2&cpid=735

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("lostcow.in"));
        PrintWriter pw = new PrintWriter("lostcow.out");
        StringTokenizer st = new StringTokenizer(r.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int sign = 1;
        int ans = 0;
        int distance = 1;

        while (true) {
            if ((sign == 1 && x <= y && y <= (x + distance)) ||
                (sign == -1 && y <= x && (x - distance <= y))) {
                ans += Math.abs(y - x);
                pw.println(ans);
                pw.close();
                break;
            } else {
                ans += (distance * 2);
                distance *= 2;
                sign *= -1;
            }
        }

    }
}