// http://usaco.org/index.php?page=viewproblem&cpid=1364, LIVE SUBMISSION

#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int N; cin >> N;

	set<ll> days;

	for (int i = 0; i < N; i ++) {
		ll x;
		cin >> x;
		days.insert(x);
	}

	int L = int(*days.begin() / 4);

	ll ans = 0;
	set<int> remainders;
	
	for (int i = 1; i <= L; i ++) {
		if (days.size() <= 3) {
			ans += i;
			continue;
		}
		if (i <= 3) {
			ans += i;
			continue;
		}
		for (ll j: days) {
			remainders.insert(j % i);
		}
		if (remainders.size() <= 3) {
			ans += i;
		}
		remainders.clear();
	}

	cout << ans;
}
