import sys

input = sys.stdin.readline
n = int(input())
top_list = list(map(int, input().split()))

t = {}
for i in top_list :
    t[i] = 0
stack = []
for i in range(n-1,-1,-1) :
    while stack :
        if (top_list[i] > stack[-1]) : 
            t[stack.pop()] = i+1
        else :
            break
    stack.append(top_list[i])

print(*t.values())