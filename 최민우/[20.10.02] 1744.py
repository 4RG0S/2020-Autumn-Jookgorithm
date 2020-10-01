#
# Created by Dandalf on 2020-10-02. 
#

import sys

input = lambda: sys.stdin.readline().rstrip()
sys.setrecursionlimit(100000)
result = 0

if __name__ == "__main__":
    field = [[] for _ in range(3)]
    for _ in range(int(input())):
        var = int(input())
        field[1 if var > 1 else 0 if var < 1 else 2].append(var)
    result += len(field[2])
    for key in [False, True]:
        field[key].sort(reverse=key)
        field[key] += [1] if len(field[key]) % 2 else []
        result += sum([field[key][i] * field[key][i + 1] for i in range(0, len(field[key]), 2)])
    print(result)
