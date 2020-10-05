#
# Created by Dandalf on 2020-10-02. 
#

import sys

input = lambda: sys.stdin.readline().rstrip()
sys.setrecursionlimit(100000)


def draw(size, char, index):
    if size == 1:
        field[index[0]][index[1]] = char
        return
    size //= 3
    for dx in range(0, size * 2 + 1, size):
        for dy in range(0, size * 2 + 1, size):
            if dx == size and dy == size:
                draw(size, ' ', (index[0] + dx, index[1] + dy))
            else:
                draw(size, char, (index[0] + dx, index[1] + dy))


if __name__ == "__main__":
    n = int(input())
    field = [[[] for _ in range(n)] for __ in range(n)]
    draw(n, '*', (0, 0))
    for k in field:
        for line in k:
            print(''.join(line), end=' ')
        print()
