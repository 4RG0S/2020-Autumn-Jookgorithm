import sys
from collections import deque
from pprint import pprint

dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]


def coloring(start, color):
    queue = deque([start])
    while queue:
        q = queue.popleft()
        x, y = q
        for i in range(4):
            if 0 <= x + dx[i] < n and 0 <= y + dy[i] < n:
                if not visited[y + dy[i]][x + dx[i]] and filed[y + dy[i]][x + dx[i]] != 0:
                    filed[y + dy[i]][x + dx[i]] = color
                    visited[y + dy[i]][x + dx[i]] = True
                    queue.append([x + dx[i], y + dy[i]])


n = int(sys.stdin.readline())
filed = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

visited = [[False for _ in range(n)] for _ in range(n)]
color = 1
for dy in range(n):
    for dx in range(n):
        if not visited[dy][dx]:
            coloring([dx, dy], color)
            color += 1

pprint(filed)
