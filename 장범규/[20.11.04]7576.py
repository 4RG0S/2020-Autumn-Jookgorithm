from collections import deque
import sys
input = sys.stdin.readline

def bfs(m,n):
    q = deque()
    for i in range(n):
        for j in range(m):
            if (tomato[i][j] == 1) :
                q.append([i,j])
                visit[i][j] = True
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    while q:
        y,x = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if (0 <= nx < m and 0 <= ny < n and tomato[ny][nx] == 0 and not visit[ny][nx]) :
                q.append([ny,nx])
                tomato[ny][nx] = tomato[y][x] + 1
                visit[ny][nx] = True
    chk_result = False
    count_day = 0
    for i in range(n):
        for j in range(m):
            if (tomato[i][j] == 0) :
                chk_result = True
            count_day = max(count_day,tomato[i][j])
    if (chk_result) :
        return -1
    else:
        return count_day-1

m,n = map(int, input().split())
tomato = [] 
visit = [[False for i in range(m)] for i in range(n)]
for i in range(n):
    tomato.append(list(map(int, input().split())))
print(bfs(m,n))