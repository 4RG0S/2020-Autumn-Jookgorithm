def chk_fibo(n) :
    dp = [[0,0] for i in range(n+1)]
    if (n == 0) :
        return [1,0]
    dp[0] = [1,0]
    dp[1] = [0,1]

    for i in range(2,n+1) :
        dp[i] = [dp[i-1][0]+dp[i-2][0],dp[i-1][1]+dp[i-2][1]]
    return dp[n]

t = int(input())
for i in range(t) :
    result = chk_fibo(int(input()))
    print(result[0],result[1])