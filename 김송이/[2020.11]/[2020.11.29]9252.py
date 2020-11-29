def LCS(str1_list, str2_list):
    dp = [[0 for _ in range(len(str2_list))] for _ in range(len(str1_list))]

    for i in range(1, len(str1_list)):
        for j in range(1, len(str2_list)):
            if str1_list[i] == str2_list[j]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
    return dp


# 행마다 가장 큰 숫자가 시작된 곳을 체크한다.
def findString(dp, string_a, string_b):
    i = len(string_a) - 1
    j = len(string_b) - 1
    result = []

    while dp[i][j] != 0:
        if dp[i][j] == dp[i][j - 1]:
            j -= 1
        elif dp[i][j] == dp[i - 1][j]:
            i -= 1
        else:
            result.insert(0, string_b[j])
            i -= 1
            j -= 1
    return result


def main():
    str1 = input()
    str2 = input()
    str1_list = [0] + list(str1)
    str2_list = [0] + list(str2)
    dp = LCS(str1_list, str2_list)
    lcs = dp[len(str1)][len(str2)]
    if lcs != 0:
        print(lcs)
    result = findString(dp, str1_list, str2_list)
    if result:
        print(''.join(result))


if __name__ == '__main__':
    main()
"""
ACAYKP
CAPCAK
"""
