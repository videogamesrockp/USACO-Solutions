// https://usaco.org/index.php?page=viewproblem2&cpid=691

#include <bits/stdc++.h>
using namespace std;

int main() {
	freopen("hps.in", "r", stdin);
	freopen("hps.out", "w", stdout);



	int n; cin >> n;
	vector<char> cows(n);

	for (int i = 0; i < n; i ++) {
		cin >> cows[i];
	}

	vector<vector<int>> count (n + 1, vector<int>(3));
	for (int i = 1; i < n + 1; i ++) {
		count[i][0] = count[i-1][0];
		count[i][1] = count[i-1][1];
		count[i][2] = count[i-1][2];
		if (cows[i - 1] == 'H') {
			count[i][0] ++;
		}
		else if (cows[i - 1] == 'P') {
			count[i][1] ++;
		}
		else {
			count[i][2] ++;
		}
	}

	int ans = 0;
	for (int i = 1; i < n + 1; i ++) {
		int curr = max(count[i][0], max(count[i][1], count[i][2])) + max(count[n][0] - count[i][0], max(count[n][1] - count[i][1], count[n][2] - count[i][2]));
		ans = max(curr, ans);
	}

	cout << ans;
}
