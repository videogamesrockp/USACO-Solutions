// http://usaco.org/index.php?page=viewproblem&cpid=1410

#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int N; cin >> N;
	int K; cin >> K;

	vector<int> cows(N);

	for (int i = 0; i < N; i ++) {
		cin >> cows[i];
	}

	priority_queue<pair<ll,int> , vector<pair<ll,int>>, greater<pair<ll,int>> > order;
	vector<vector<int>> adjacency_list(K);

	for (int i = 0; i < K; i ++) {
		order.push(make_pair(cows[i], i));
	}

	pair<ll, int> value;
	for (int i = K; i < N; i ++) {
		if (order.top().first == value.first) {
			adjacency_list[value.second].push_back(order.top().second);
			adjacency_list[order.top().second].push_back(value.second);
		}
		order.push(make_pair(cows[i] + order.top().first, order.top().second));
		value = order.top();
		order.pop();
	}

	cout << order.top().first << endl;
	
	vector<int> farmers (K);
	
	queue<int> q;
	q.push(order.top().second);

	while (!q.empty()) {
		int current_node = q.front();
		q.pop();

		farmers[current_node] = 1;

		for (int neighbor : adjacency_list[current_node]) {
			if (farmers[neighbor] == 0) {
				q.push(neighbor);
			}
		}
	}

	for (int i = 0; i < K; i ++) {
		cout << farmers[i];
	}
}