import sys
from collections import deque

# 좌표 상에서 위, 아래, 좌, 우
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

N, M = map(int, sys.stdin.readline().split())

maze = [[0] * M for _ in range(N)]

for i in range(N):
    maze[i] = sys.stdin.readline()

queue = deque()
queue.append((0, 0))
visited = [[0] * M for _ in range(N)]
visited[0][0] = 1

while queue:
    x, y = queue.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M:
            if maze[nx][ny] == '1' and visited[nx][ny] == 0:
                visited[nx][ny] = visited[x][y] + 1
                queue.append((nx, ny))

print(visited[N - 1][M - 1])
