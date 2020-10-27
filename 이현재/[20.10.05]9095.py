import sys

sys.setrecursionlimit(10 ** 5)
arr = [1, 2, 3]


def ott_sum(k, cnt):
    result = 0
    if k == 0:
        return 1
    else:
        for j in arr:
            if j <= k:
                result += ott_sum(k - j, cnt + 1)


    return result


n = int(input())
for i in range(n):
    num = int(input())
    print(ott_sum(num, 0))
