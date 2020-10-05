#
# Created by Dandalf on 2020-10-02.
#

import sys

input = lambda: sys.stdin.readline().rstrip()
sys.setrecursionlimit(100000)

if __name__ == "__main__":
    n = int(input())
    field = [list(map(int, input().split())) for _ in range(n)]
    for i in range(1, n):
        field[i][0] += min(field[i - 1][1], field[i - 1][2])
        field[i][1] += min(field[i - 1][0], field[i - 1][2])
        field[i][2] += min(field[i - 1][0], field[i - 1][1])
    print(min(field[n - 1]))
