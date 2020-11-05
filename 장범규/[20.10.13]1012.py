import sys
sys.setrecursionlimit(10**8)
input = sys.stdin.readline

def dfs(x,y) :
    field[y][x] = 2
    direct = [(-1,0),(1,0),(0,-1),(0,1)]
    for i in range(4) :
        tmp_x,tmp_y = x+direct[i][0],y+direct[i][1]
        if (not (tmp_x < 0 or tmp_x >= m or tmp_y < 0 or tmp_y >= n)) :
            if (field[tmp_y][tmp_x] != 0 and field[tmp_y][tmp_x] != 2) :
                dfs(tmp_x,tmp_y)

t = int(input())

for i in range(t) :
    m,n,k = map(int, input().split())
    field = [[0 for col in range(m)] for row in range(n)]
    
    for j in range(k) :
        x,y = map(int, input().split())
        field[y][x] = 1
    
    count = 0
    for c in range(m) :
        for r in range(n) :
            if (field[r][c] == 1) :
                dfs(c,r)
                count += 1
    print(count)