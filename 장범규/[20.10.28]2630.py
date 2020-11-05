import sys
sys.setrecursionlimit(10**8)
input = sys.stdin.readline

def solution(row,col,n) :
    if (n == 1) :
        color[matrix[row][col]] += 1
        return
    
    chk = True
    for r in range(row,row+n) :
        for c in range(col,col+n) :
            if (matrix[row][col] != matrix[r][c]) :
                chk = False
                break
        if (not chk) :
            break
    
    if (chk) :
        color[matrix[row][col]] += 1
    else :
        cut = n//2
        solution(row,col,cut)
        solution(row,col+cut,cut)
        solution(row+cut,col,cut)
        solution(row+cut,col+cut,cut)

n = int(input())
matrix = []
color = {0:0,1:0}
for i in range(n) :
    matrix.append(list(map(int, input().split())))
solution(0,0,n)
print(color[0])
print(color[1])