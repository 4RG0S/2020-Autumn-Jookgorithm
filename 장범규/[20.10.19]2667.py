import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline

def dfs(matrix,n,count,x,y) :
    matrix[x][y] = 0
    dx = [1,-1,0,0]
    dy = [0,0,1,-1]

    for i in range(4) :
        nx = x + dx[i]
        ny = y + dy[i]
        if (nx >= 0 and nx < n and ny >= 0 and ny < n) :
            if (matrix[nx][ny] == 1) :
                count = dfs(matrix,n,count+1,nx,ny)
    
    return count

n = int(input())
matrix = []
for i in range(n) :
    matrix.append(list(map(int, input().rstrip())))

apart = []
for i in range(n) :
    for j in range(n) :
        if (matrix[i][j] == 1) :
            apart.append(dfs(matrix,n,1,i,j))

apart.sort()
print(len(apart))
for i in apart :
    print(i)