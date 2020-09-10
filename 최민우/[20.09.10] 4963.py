from collections import deque

dx = [0, 0, -1, 1, 1, 1, -1, -1]
dy = [1, -1, 0, 0, 1, -1, 1, -1]


def bfs(start):
    queue = deque([start])
    while queue:
        x, y = queue.popleft()
        for d in range(8):
            if 0 <= x + dx[d] < w and 0 <= y + dy[d] < h:
                if not visited[y + dy[d]][x + dx[d]] and field[y + dy[d]][x + dx[d]] == 1:
                    visited[y + dy[d]][x + dx[d]] = True
                    queue.append([x + dx[d], y + dy[d]])


visited = []

while True:
    w, h = map(int, input().split())
    if not w and not h:
        break
    field = [list(map(int, input().split())) for _ in range(h)]
    visited = [[False for _ in range(w + 1)] for _ in range(h + 1)]
    count = 0
    for y in range(h):
        for x in range(w):
            if not visited[y][x] and field[y][x] == 1:
                bfs([x, y])
                count += 1
    print(count)
