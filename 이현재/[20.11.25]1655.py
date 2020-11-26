import sys
import heapq

input = sys.stdin.readline
n = int(input())

min_h = []
max_h = []
for _ in range(n):
    k = int(input())
    if len(min_h) == len(max_h):
        heapq.heappush(max_h, -k)
    else:
        heapq.heappush(min_h, k)
    if min_h:
        if -max_h[0] > min_h[0]:
            t1 = heapq.heappop(max_h)
            t2 = heapq.heappop(min_h)
            heapq.heappush(min_h, -t1)
            heapq.heappush(max_h, -t2)

    print(-max_h[0])
