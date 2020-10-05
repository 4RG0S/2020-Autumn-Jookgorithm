#
# Created by Dandalf on 2020-10-02. 
#

import sys

input = lambda: sys.stdin.readline().rstrip()
sys.setrecursionlimit(100000)


def solve(index, dep):
    if dp[dep][index] != -1:
        return dp[dep][index]
    if dep + 1 == depth:
        dp[dep][index] = field[dep][index]
        return dp[dep][index]
    dp[dep][index] = field[dep][index] + max(solve(index, dep + 1), solve(index + 1, dep + 1))
    return dp[dep][index]


if __name__ == "__main__":
    depth = int(input())
    field = [list(map(int, input().split())) for _ in range(depth)]
    dp = [[-1 for _ in range(i)] for i in range(1, depth + 1)]
    print(solve(0, 0))
