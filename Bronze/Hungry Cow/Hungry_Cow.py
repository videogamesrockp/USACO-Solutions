# http://www.usaco.org/index.php?page=viewproblem2&cpid=1299

N, T = map(int, input().split())
days = []

for i in range(N):
    days.append(list(map(int, input().split())))

bale_count = 0
ans = 0

for i in range(N-1):
    bale_count += days[i][1]
    ans += min(bale_count, days[i+1][0] - days[i][0])
    bale_count -= min(bale_count, days[i+1][0] - days[i][0])

bale_count += days[N-1][1]
ans += min(bale_count, T + 1 - days[N-1][0])


print(ans)
