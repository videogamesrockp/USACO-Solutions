// Source: https://usaco.guide/general/io

#include <bits/stdc++.h>
using namespace std;

int main() {
	freopen("gymnastics.in", "r", stdin);
	freopen("gymnastics.out", "w", stdout);

	int K, N; cin >> K >> N;

	vector<vector<int>> rankings(K, vector<int>(N));
	for (int i = 0; i < K; i ++) {
		for (int j = 0; j < N; j ++) {
			int a; cin >> a;
			a --;
			rankings[i][a] = j;
		}
	}

	int ans = 0;

	for (int i = 0; i < N; i ++) {
		for (int j = 0; j < N; j ++) {
			bool works = true;
			for (int l = 0; l < K; l ++) {
				if (rankings[l][i] >= rankings[l][j]) {
					works = false;
					break;
				}
			}
			if (works) {
				ans ++;
			}
		}
	}

	cout << ans;
}

