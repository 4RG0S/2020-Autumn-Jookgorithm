import sys
input = sys.stdin.readline

n = int(input())
conference = []
for i in range(n) :
    s,e = map(int, input().split())
    conference.append((s,e))

conference.sort(key=lambda x:(x[1],x[0]))

count = 0
start = 0
for i in range(n) :
    if (conference[i][0] >= start) :
        start = conference[i][1]
        count += 1
print(count)