import sys
input = sys.stdin.readline

n = int(input())
stair = [0]
for i in range(n) :
    stair.append(int(input()))

dp = [0 for i in range(n+1)]
dp[1] = stair[1]
if (n == 1) :
    print(dp[1])
else :
    dp[2] = max(stair[2],dp[1]+stair[2])
    for i in range(3,n+1) :
        dp[i] = max(dp[i-2]+stair[i],dp[i-3]+stair[i]+stair[i-1])
    print(dp[n])