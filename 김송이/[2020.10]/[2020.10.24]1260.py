def dfs(v):  # v가 시작점
    print(v, end=' ')
    visit[v] = 1  # 방문한 점 1로
    for i in range(1, n + 1):
        if visit[i] == 0 and matrix[v][i] == 1:  # 방문을 아직 안했고 v에서 i로 갈수있다면
            dfs(i)  # i를 다시 v로 하면서 dfs 로 탐색


def bfs(v):
    queue = [v]  # 들려야 할 점 저장
    visit[v] = 0  # 방문한 점 0으로( dfs로 인해 1로 바뀌어 있으므로)
    while queue:  # 큐가 빌 때까지
        v = queue.pop(0)
        print(v, end=' ')
        for i in range(1, n + 1):
            if visit[i] == 1 and matrix[v][i] == 1:
                queue.append(i) # bfs이므로 첫 점에서 갈 수 있다는 걸 확인할 때마다 queue에 push
                visit[i] = 0


n, m, v = map(int, input().split())
matrix = [[0] * (n + 1) for i in range(n + 1)]  # 0부터 시작하므로

visit = [0 for i in range(n + 1)]
for i in range(m):
    x, y = map(int, input().split())
    # 갈 수 있는 정점을 1로 설정
    matrix[x][y] = 1
    matrix[y][x] = 1
dfs(v)
print()
bfs(v)
