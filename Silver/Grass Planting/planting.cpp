// https://usaco.org/current/current/index.php?page=viewproblem2&cpid=894

#include <bits/stdc++.h>
using namespace std;

int main() {
	freopen("planting.in", "r", stdin);
	freopen("planting.out", "w", stdout);
	int N; cin >> N;

	vector<int> neighbors (N);

	for (int i = 0; i < N - 1; i ++) {
		int a, b; cin >> a >> b;
		neighbors[a-1]++;
		neighbors[b-1]++;
	}

	int ans = 0;
	for (int i: neighbors) {
		if (i > ans) {
			ans = i;
		}
	}

	cout << ans + 1;
}
