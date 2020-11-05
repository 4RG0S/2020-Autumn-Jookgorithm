from collections import deque
import sys
input = sys.stdin.readline

def bfs(m,n,h):
    q = deque()
    for i in range(h):
        for j in range(n):
            for k in range(m):
                if (tomato[i][j][k] == 1) :
                    q.append([i,j,k])
                    visit[i][j][k] = True
    dx = [-1,1,0,0,0,0]
    dy = [0,0,-1,1,0,0]
    dz = [0,0,0,0,-1,1]
    while q:
        z,y,x = q.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            if (0 <= nx < m and 0 <= ny < n and 0 <= nz < h and tomato[nz][ny][nx] == 0 and not visit[nz][ny][nx]) :
                q.append([nz,ny,nx])
                tomato[nz][ny][nx] = tomato[z][y][x] + 1
                visit[nz][ny][nx] = True
    chk_result = False
    count_day = 0
    for i in range(h):
        for j in range(n):
            for k in range(m):
                if (tomato[i][j][k] == 0) :
                    chk_result = True
                count_day = max(count_day,tomato[i][j][k])
    if (chk_result) :
        return -1
    else:
        return count_day-1

m,n,h = map(int, input().split())
tomato = [[] for i in range(h)]
visit = [[[False for i in range(m)] for i in range(n)] for i in range(h)]
for i in range(h):
    for j in range(n):
        tomato[i].append(list(map(int, input().split())))
print(bfs(m,n,h))