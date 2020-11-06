import sys
input = sys.stdin.readline

n = int(input())
human = []
for i in range(n) :
    w,k = map(int, input().split())
    human.append([w,k])

order = [1 for i in range(n)]
for i in range(n) :
    for j in range(n) :
        if ((human[i][0] < human[j][0]) and (human[i][1] < human[j][1])) :
            order[i] += 1
    print(order[i],end=" ")