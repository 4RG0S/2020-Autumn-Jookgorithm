def knapsack(n, k, weight_list, value_list):
    dp = [[0] * (k + 1) for _ in range(n + 1)]
    for i in range(1, n + 1):  # i번째 아이템
        weight = weight_list[i]
        value = value_list[i]
        for j in range(1, k + 1):  # j 만큼의 무개제한
            if weight <= j:  # 가방에 들어갈 수 있는 경우
                dp[i][j] = max(dp[i - 1][j - weight] + value, dp[i - 1][j])  # 직전값과 weight만큼 비웠을 때 최적값+현재 value 비교
            else:
                dp[i][j] = dp[i - 1][j]  # i번째 아이템 넣기 직전값
    # print(dp)
    return dp[n][k]


def main():
    weight_list = [0]
    value_list = [0]
    n, k = map(int, input().split())  # 물품의 수, 제한 무게
    for i in range(n):
        w, v = map(int, input().split())
        weight_list.append(w)
        value_list.append(v)

    print(knapsack(n, k, weight_list, value_list))


if __name__ == '__main__':
    main()
