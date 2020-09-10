from collections import deque

n, v = map(int, input().split())

visited = [False for _ in range(n + 1)]

node = {}
for i in range(1, n + 1):
    node[i] = []


def bfs(start):
    queue = deque([start])
    while queue:
        q = queue.popleft()
        for __node in node[q]:
            if not visited[__node]:
                visited[__node] = True
                queue.append(__node)


for _ in range(v):
    a, b = map(int, input().split())

    if a not in node:
        node[a] = [b]
    elif b not in node[a]:
        node[a].append(b)

    if b not in node:
        node[b] = [a]
    elif a not in node[b]:
        node[b].append(a)

result = 0
for _node in node:
    if not visited[_node]:
        visited[_node] = True
        bfs(_node)
        result += 1

print(result)