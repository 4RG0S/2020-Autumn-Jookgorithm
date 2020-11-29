from collections import deque


def bfs(queue, graph, n, m):
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    while queue:
        a, b = queue.popleft()
        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]
            if 0 <= nx < m and 0 <= ny < n and graph[nx][ny] == 0:
                graph[nx][ny] += graph[a][b] + 1
                queue.append([nx, ny])


def main():
    n, m = map(int, input().split())  # 열 행
    graph = [list(map(int, input().split())) for _ in range(m)]
    queue = deque()
    for i in range(m):
        for j in range(n):
            if graph[i][j] == 1:
                queue.append([i, j])
    bfs(queue, graph, n, m)
    result = -2
    flag = True
    for i in graph:
        for j in i:
            if j == 0:
                flag = False
            result = max(result, j)
    #print(graph)
    if flag == False:  # 토마토가 모두 익지 못하는 상황
        print(-1)
    elif result == -1:  # 토마토가 전부 들어있지 않은 경우
        print(0)
    else:  # 모두 익은 경우
        print(result - 1)


if __name__ == '__main__':
    main()
