import sys
from collections import deque
input = sys.stdin.readline

def bfs(r,c) :
    q = deque()
    q.append([0,0])
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    maze[0][0] = -1
    while q :
        r,c = q.popleft()
        if (n == r+1 and m == c+1) :
            return count[r][c]+1
        for i in range(4) :
            nx = c + dx[i]
            ny = r + dy[i]
            if (nx >= 0 and nx < m and ny >= 0 and ny < n and maze[ny][nx] == 1) :
                q.append([ny,nx])
                maze[ny][nx] = -1
                count[ny][nx] = count[r][c]+1

n,m = map(int, input().split())
maze = []
for i in range(n) :
    maze.append(list(map(int, input().rstrip())))
count = [[0 for i in range(m)] for j in range(n)]
print(bfs(n,m))