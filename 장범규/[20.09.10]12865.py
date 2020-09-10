n, k = map(int, input().split())
bag = [{0:0}]
dp = [[0 for col in range(k+1)] for row in range(n+1)]

for i in range(n) :
    w, v = map(int, input().split())
    bag.append({w:v})

result = 0
for i in range(1,n+1) :
    for j in range(1,k+1) :
        w = list(bag[i].keys())[0]
        v = list(bag[i].values())[0]
        if (w <= j) :
            dp[i][j] = max(v + dp[i-1][j-w], dp[i-1][j])
        else :
            dp[i][j] = dp[i-1][j]
        result = max(dp[i][j], result)

print(result)
    