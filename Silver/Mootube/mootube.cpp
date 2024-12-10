// https://usaco.org/index.php?page=viewproblem2&cpid=788

#include <bits/stdc++.h>
#include <utility>
using namespace std;

int main() {
	freopen("mootube.in", "r", stdin);
	freopen("mootube.out", "w", stdout);

	int n, q; cin >> n >> q;
	vector<vector<pair<int, int>>> adj (n);

	for (int i = 0; i < n-1; i ++) {
		int p, q, r; cin >> p >> q >> r;
		adj[--p].push_back(make_pair(--q, r));
		adj[q].push_back(make_pair(p, r));
	}

	for (int i = 0; i < q; i ++) {
		vector<int> visited (n);
		int count = 0;
		int k, v; cin >> k >> v;
		v --;
		queue<int> q;
		q.push(v);
		while (!q.empty()) {
			int top = q.front();
			visited[top] = true;
			q.pop();
			for (auto neighbor: adj[top]) {
				if (neighbor.second >= k && !visited[neighbor.first]) {
					q.push(neighbor.first);
					count ++;
				}
			}
		}

		cout << count << endl;
	}
}
