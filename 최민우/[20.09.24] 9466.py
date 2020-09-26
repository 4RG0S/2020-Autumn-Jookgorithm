import sys
from collections import deque


def bfs(start, path):
    global result
    queue = deque([start])
    path[start] = 1
    while queue:
        q = queue.popleft()
        for p in node[q]:
            if not visited[p]:
                visited[p] = True
                path[p] = path[q] + 1
                queue.append(p)
            elif path[p]:
                print(path[p])
                result += len(path) - path[p]


for test_case in range(int(sys.stdin.readline())):
    n = int(sys.stdin.readline())

    visited = [False for _ in range(n + 1)]
    result = 0

    node = {i: [] for i in range(1, n + 1)}
    inputs = list(map(int, sys.stdin.readline().split()))
    for index in range(1, n + 1):
        node[index].append(inputs[index - 1])

    for _node in node:
        if not visited[_node]:
            _path = [0 for _ in range(n + 1)]
            visited[_node] = True
            bfs(_node, _path)

    print(n - result)
