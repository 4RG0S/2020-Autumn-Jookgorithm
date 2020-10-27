from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
N, M = map(int, input().split())
table = [0 for _ in range(M)]
cnt = [[0 for _ in range(N)] for _ in range(M)]
for i in range(M):
    table[i] = list(map(int, input().split()))

queue = deque()

for i in range(M):
    for j in range(N):
        if table[i][j] == 1:
            queue.append((i, j))

while queue:
    x, y = queue.pop()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= ny < N and 0 <= nx < M:
            if table[nx][ny] == 0:
                table[nx][ny] = 1
                cnt[nx][ny] = cnt[x][y] + 1
                queue.appendleft((nx, ny))

max_cnt = 0
for i in range(M):
    for j in range(N):
        if cnt[i][j] > max_cnt:
            max_cnt = cnt[i][j]

for i in range(M):
    for j in range(N):
        if table[i][j] == 0:
            max_cnt = -1
            break

print(max_cnt)
