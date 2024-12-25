// https://usaco.org/index.php?page=viewproblem2&cpid=1446

#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n; cin >> n;
    vector<int> cakes (n);

    long long total = 0;
    for (int i = 0; i< n; i++) {
        cin >> cakes[i];
        total += cakes[i];
    }

    long long curr = 0;

    for (int i= 0; i< n/2 - 1; i++) {
        curr += cakes[i];
    }

    long long e = curr;

    for (int i= 1; i< n/2; i++) {
        curr = curr - cakes[n/2 - i- 1] + cakes[n - i];
        e = max(curr, e);
    }

    long long b = total - e;

    cout << b << " " << e << endl;
}

int main() {
	
    int t; cin >> t;
    
    for (int i = 0; i < t; i ++) {
        solve();
    }
}
