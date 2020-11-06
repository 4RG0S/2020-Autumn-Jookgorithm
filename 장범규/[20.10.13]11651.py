import sys
input = sys.stdin.readline

n = int(input())
dot = []
for i in range(n) :
    x,y = map(int, input().split())
    dot.append([x,y])
dot.sort(key=lambda x:(x[1],x[0]))
for i,j in dot :
    print(i,j)