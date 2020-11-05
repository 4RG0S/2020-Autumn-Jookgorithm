import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline

def solution(r,c,n) :
    global result
    if (n == 1) :
        result += str(matrix[r][c])
        return

    chk = True
    for i in range(r,r+n) :
        for j in range(c,c+n) :
            if (matrix[r][c] != matrix[i][j]) :
                chk = False
    
    if chk :
        result += str(matrix[r][c])
    else :
        cut = n//2
        result += "("
        solution(r,c,cut)
        solution(r,c+cut,cut)
        solution(r+cut,c,cut)
        solution(r+cut,c+cut,cut)
        result += ")"

n = int(input())
matrix = []
result = ""
for i in range(n) :
    matrix.append(list(map(int, input().rstrip())))
solution(0,0,n)
print(result)