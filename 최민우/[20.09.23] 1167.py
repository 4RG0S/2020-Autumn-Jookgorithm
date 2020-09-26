import sys
from collections import deque

sys.setrecursionlimit(1000000)
result = 0


def bfs(start):
    global result
    queue = deque([(start, 0)])
    max_len = (start, 0)
    visited = [False for _ in range(n + 1)]
    visited[start] = True
    while queue:
        q, travel_len = queue.popleft()
        for p, p_length in nodes[q]:
            if not visited[p]:
                visited[p] = True
                if travel_len + p_length > max_len[1]:
                    max_len = (p, travel_len + p_length)
                queue.append((p, travel_len + p_length))
    result = max(result, max_len[1])
    return max_len[0]


n = int(sys.stdin.readline().rstrip())
nodes = {i: [] for i in range(1, n + 1)}

for _ in range(n):
    inputs = list(map(int, sys.stdin.readline().rstrip().split()))
    a = inputs[0]
    inputs = inputs[1:-1]

    for index in range(0, len(inputs), 2):
        b, value = inputs[index], inputs[index + 1]
        if (b, value) not in nodes[a]:
            nodes[a].append((b, value))

bfs(bfs(1))
print(result)
