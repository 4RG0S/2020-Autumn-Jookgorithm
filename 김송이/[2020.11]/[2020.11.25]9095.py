def DP(num):
    dp = [0 for _ in range(num + 1)]
    for i in range(num + 1):
        if i <= 2:
            dp[i] = i
        elif i == 3:
            dp[i] = 4
        else:
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    return dp[num]


def main():
    n = int(input())
    for i in range(n):
        num = int(input())
        print(DP(num))


if __name__ == '__main__':
    main()
