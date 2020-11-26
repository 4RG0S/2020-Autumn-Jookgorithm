import sys
from collections import deque


def bfs(tree, root):
    queue = deque([root])
    parent = [0 for _ in range(n + 1)]
    visited = [False for _ in range(n + 1)]
    visited[root] = True
    while queue:
        p = queue.popleft()
        for v in tree[p]:
            if visited[v]:
                continue
            visited[v] = True
            parent[v] = p
            queue.append(v)
    return parent


input = sys.stdin.readline
n = int(input())

tree = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

result = bfs(tree, 1)
for i in range(2, n + 1):
    print(result[i])
