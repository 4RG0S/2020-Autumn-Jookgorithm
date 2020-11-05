import sys
input = sys.stdin.readline

n = int(input())
dot = []
for i in range(n) :
    x,y = map(int, input().split())
    dot.append([x,y])
dot.sort(key=lambda x:(x[0],x[1]))
for i,j in dot :
    print(i,j)