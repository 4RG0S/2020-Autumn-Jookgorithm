import sys
from collections import deque

n = int(sys.stdin.readline().rstrip())
visited = [False for _ in range(n + 1)]
result = ['' for _ in range(n + 1)]

nodes = {}
for _ in range(n - 1):
    a, b = map(int, sys.stdin.readline().rstrip().split())

    if a not in nodes:
        nodes[a] = [b]
    elif b not in nodes[a]:
        nodes[a].append(b)

    if b not in nodes:
        nodes[b] = [a]
    elif a not in nodes[b]:
        nodes[b].append(a)

queue = deque([1])
while queue:
    q = queue.popleft()
    for p in nodes[q]:
        if not visited[p]:
            visited[p] = True
            result[p] = str(q)
            queue.append(p)

print('\n'.join(result[2:]))
