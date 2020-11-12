from collections import deque


def bfs(v):
    queue.append((0, 0))

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    while queue:
        x, y = queue.popleft()
        for i in range(4):  # 자식노드 큐에 추가하기 위함
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if visit[nx][ny] == False and matrix[nx][ny] == 1:
                    queue.append((nx, ny))
                    visit[nx][ny] = True
                    result[nx][ny] = result[x][y] + 1


n, m = map(int, input().split())
matrix = [list(map(int, input())) for _ in range(n)]
visit = [[False] * m for _ in range(n)]
queue = deque()
result = [[1] * m for _ in range(n)]
#print(matrix)
bfs(0)
print(result[ n- 1][m - 1])
