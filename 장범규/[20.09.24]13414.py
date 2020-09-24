import sys

k,l = map(int, sys.stdin.readline().split())
queue = {}

for i in range(1,l+1) :
    student = sys.stdin.readline().rstrip()
    queue[student] = i

queue = sorted(queue.items(),key=lambda x:x[1])
for i in queue[0:k] :
    print(i[0])