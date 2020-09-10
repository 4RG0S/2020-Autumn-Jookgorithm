import sys
from collections import deque

"""
81프로에서 시간초과 발생
"""


def bfs(start):
    global result
    queue = deque([[start, [start]]])
    while queue:
        q, path = queue.popleft()
        for p in node[q]:
            if not visited[p]:
                visited[p] = True
                queue.append([p, path + [p]])
            elif p in path:
                result += len(path) - path.index(p)


results = []

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
            visited[_node] = True
            bfs(_node)

    results.append(n - result)

print('\n'.join(map(str, results)))
