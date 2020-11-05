import sys
input = sys.stdin.readline

t = int(input())
for i in range(t) :
    m,n,x,y = map(int, input().split())
    found = False
    while x <= m*n :
        if ((x-y)%n == 0) :
            found = True
            break
        x += m
    if (found) :
        print(x)
    else :
        print(-1)