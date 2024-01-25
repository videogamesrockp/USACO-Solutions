// http://www.usaco.org/index.php?page=viewproblem2&cpid=595

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
    freopen("div7.in", "r", stdin);
    freopen("div7.out", "w", stdout);

    int N; cin >> N;

    vector<int> ids(N);

    for (int i = 0; i < N; i ++) {
        cin >> ids[i];
    }

    vector<ll> pref(N + 1);

    for (int i = 0; i < N; i ++) {
        pref[i + 1] = pref[i] + ids[i + 1];
    }

    int ans = 0;

    for (int i = 0; i < N; i ++) {
        for (int j = i + 1; j <= N; j ++) {
            if ((pref[j] - pref[i]) % 7 == 0 && j - i > ans) {
                ans = j - i;
            }
        }
    }

    cout << ans;
}