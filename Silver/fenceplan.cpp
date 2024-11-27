// Source: https://usaco.guide/general/io

#include <bits/stdc++.h>
using namespace std;

vector<int> visited;
vector<vector<int>> adj;
vector<pair<int, int>> cows;
int max_y = 0;
int max_x = 0;
int min_y = INT_MAX;
int min_x = INT_MAX;

void dfs(int current_node) {
	if (visited[current_node]) {
		return;
	}

	visited[current_node] = true;
	max_y = max(max_y, cows[current_node].second);
	max_x = max(max_x, cows[current_node].first);
	min_y = min(min_y, cows[current_node].second);
	min_x = min(min_x, cows[current_node].first);
	for (int neighbor: adj[current_node]) {
		dfs(neighbor);
	}
}

int main() {
	freopen("fenceplan.in", "r", stdin);
	freopen("fenceplan.out", "w", stdout);

	int N, M; cin >> N >> M;
	visited.resize(N);
	adj.resize(N);
	cows.resize(N);

	for (int i = 0; i < N; i ++) {
		cin >> cows[i].first >> cows[i].second;
	}

	for (int i = 0; i < M; i ++) {
		int a, b; cin >> a >> b;
		a --;
		b --;

		adj[a].push_back(b);
		adj[b].push_back(a);
	}

	int ans = INT_MAX;

	for (int i = 0; i < N; i ++) {
		if (!visited[i]) {
			dfs(i);
			ans = min(ans, 2 * (max_y - min_y + max_x - min_x));
			max_y = 0;
			max_x = 0;
			min_y = INT_MAX;
			min_x = INT_MAX;
		}
	}

	cout << ans;
}
