// https://usaco.org/index.php?page=viewproblem2&cpid=668

#include <bits/stdc++.h>
using namespace std;

vector<bool> visited(200);
vector<vector<int>> adj(200);
int curr = 0;

void dfs(int current_node) {
	if (visited[current_node]) {
		return;
	}
	curr ++;
	visited[current_node] = true;
	for (int neighbor: adj[current_node]) {
		dfs(neighbor);
	}
}

int main() {
	freopen("moocast.in", "r", stdin);
	freopen("moocast.out", "w", stdout);

	int n; cin >> n;
	vector<pair<pair<int, int>, int>> cows (n);

	for (int i = 0; i < n; i ++) {
		cin >> cows[i].first.first >> cows[i].first.second >> cows[i].second;
	}
	
	for (int i = 0; i < n; i ++) {
		for (int j = 0; j < n; j ++) {
			if (sqrt(pow(cows[j].first.first - cows[i].first.first, 2) + pow(cows[j].first.second - cows[i].first.second, 2)) <= cows[i].second) {
				adj[i].push_back(j);
			}
		}
	}

	int ans = 0;

	for (int j = 0; j < n; j ++) {
		dfs(j);
		fill(begin(visited), end(visited), false);
		ans = max(ans, curr);
		curr = 0;
	}

	cout << ans;
	
}
