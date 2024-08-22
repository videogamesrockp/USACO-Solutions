// https://usaco.org/index.php?page=viewproblem2&cpid=712

#include <bits/stdc++.h>
using namespace std;

int main() {
	freopen("circlecross.out", "w", stdout);
	freopen("circlecross.in", "r", stdin);

	vector<char> crossings(52);
	for (int i = 0; i < 52; i ++) {
		cin >> crossings[i];
	}
	int ans = 0;
	for (int i = 0; i < 52; i ++) {
		for (int j = i + 1; j < 52; j ++) {
			int matching = 0;
			for (int k = j + 1; k < 52; k ++) {
				if (crossings[k] == crossings[i]) {
					matching ++;
				}
				else if (crossings[k] == crossings[j] && matching == 1) {
					matching ++;
				}
			}
			if (matching == 2) {
				ans ++;
			}
		}
	}

	cout << ans;
}
