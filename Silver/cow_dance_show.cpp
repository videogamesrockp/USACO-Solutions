#include <bits/stdc++.h>
using namespace std;

int N, T;

vector<int> cows;

bool check(int k) {
	priority_queue<int, vector<int>, greater<int>> pq;

	for (int i = 0; i < k; i ++) {
		pq.push(cows[i]);
	}
	
	int time;
	int i = k;
	while (!pq.empty()) {
		time = pq.top();
		pq.pop();
		if (i < N) {
			pq.push(cows[i] + time);
		}
		i ++;
	}

	if (time > T) {
		return false;
	}
	else {
		return true;
	}
}

int main() {
	freopen("cowdance.in", "r", stdin);
	freopen("cowdance.out", "w", stdout);

	cin >> N >> T;

	for (int i = 0; i < N; i ++) {
		int a; cin >> a;
		cows.push_back(a);
	}

	int left = 0; int right = N;
	int ans = -1;
	while (left <= right) {
		int mid = left + (right - left)/2;
		if (check(mid)) {
			ans = mid;
			right = mid - 1;
		}
		else {
			left = mid + 1;
		}
	}

	cout << ans;
}
