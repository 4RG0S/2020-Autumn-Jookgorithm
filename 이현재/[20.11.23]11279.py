import heapq
import sys

n = int(sys.stdin.readline())
queue = []
for _ in range(n):
    x = int(sys.stdin.readline())
    if x == 0:
        if queue:
            print(heapq.heappop(queue)[1])
        else:
            print(0)
    else:
        heapq.heappush(queue, [-x, x])
