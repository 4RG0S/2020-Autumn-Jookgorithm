def main():
    n = int(input())
    score_list = [0] + [int(input()) for _ in range(n)]
    # print(score_list)

    dp = [0 for _ in range(n + 1)]

    for i in range(1, n+1):
        if i ==1:
            dp[1] = score_list[1]
        elif i ==2:
            dp[2] = score_list[1]+ score_list[2]
        else:
            dp[i] = max(dp[i - 3] + score_list[i - 1] + score_list[i], dp[i - 2] + score_list[i])  # 2칸밟고 올라온 경우

    print(dp[n])


if __name__ == '__main__':
    main()
