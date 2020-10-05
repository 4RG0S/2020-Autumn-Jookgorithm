#
# Created by Dandalf on 2020-10-02. 
#

import sys

input = lambda: sys.stdin.readline().rstrip()
sys.setrecursionlimit(100000)

if __name__ == "__main__":
    length, line = int(input()), input()
    line_len = len(line)

    # 실패함수
    field = [0 for _ in range(line_len)]
    j = 0
    for i in range(1, line_len):
        while j > 0 and line[i] != line[j]:
            j = field[j - 1]
        if line[i] == line[j]:
            j += 1
            field[i] = j

    print(line_len - field[line_len - 1])
