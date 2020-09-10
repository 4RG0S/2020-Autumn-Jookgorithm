from collections import deque

"""
히히히 이게 되네 히히히히히히히히 신난다 ㅎㅎㅎㅎㅎㅎ
"""


def bfs(start):
    queue.append(start)
    visited[start] = 1
    while queue:
        q = queue.popleft()
        for p in node[q]:
            if not visited[p]:
                visited[p] = 3 - visited[q]
                queue.append(p)
            elif visited[p] == visited[q]:
                return False
    return True


for test_case in range(int(input())):
    n, v = map(int, input().split())

    node = {}
    visited = [0 for _ in range(n + 1)]
    for i in range(1, n + 1):
        node[i] = []

    for _ in range(v):
        a, b = map(int, input().split())
        if b not in node[a]:
            node[a].append(b)
        if a not in node[b]:
            node[b].append(a)
    queue = deque()
    isDivide2 = True
    for _node in node:
        if visited[_node] == 0:
            if not bfs(_node):
                isDivide2 = False
                break

    print('YES' if isDivide2 else 'NO')
