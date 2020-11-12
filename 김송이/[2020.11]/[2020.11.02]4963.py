import sys
sys.setrecursionlimit(10000)
def dfs(matrix, i, j):
    matrix[i][j] = 0
    # x가 행, y가 열
    dx = [1, -1, 0, 0, 1, -1, 1, -1]
    dy = [0, 0, 1, -1, 1, -1, -1, 1]

    for k in range(len(dx)):
        nx = i + dx[k]
        ny = j + dy[k]
        if 0 <= nx < h and 0 <= ny < w:
            if matrix[nx][ny] == 1:  # 방문을 해야 할 경우
                dfs(matrix, nx, ny)


while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    else:
        island_matrix = [list(map(int, input().split())) for _ in range(h)]
        count = 0
        for i in range(h):
            for j in range(w):
                if island_matrix[i][j] == 1:
                    dfs(island_matrix, i, j)
                    count += 1
    print(count)
