import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline

def solution(r,c,n) :
    if (n == 1) :
        result[field[r][c]] += 1
    else :
        chk = True
        for i in range(r,r+n) :
            for j in range(c,c+n) :
                if (field[r][c] != field[i][j]) :
                    chk = False

        slicing = n//3
        if chk :
            result[field[r][c]] += 1
        else :    
            for i in range(3) :
                for j in range(3) :
                    solution(r+slicing*i,c+slicing*j,slicing)
                
n = int(input())
field = []
result = {-1:0,0:0,1:0}

for i in range(n) :
    field.append(list(map(int, input().split())))

solution(0,0,n)
for i in result.values() :
    print(i)