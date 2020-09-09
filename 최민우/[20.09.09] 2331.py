from collections import deque


def nextNode(num):
    result = 0
    for c in str(num):
        result += int(c) ** P
    return result


def bfs(start):
    queue = deque([[start, [start]]])
    while queue:
        q, path = queue.popleft()
        p = nextNode(q)
        if p in path:
            return path.index(p)
        queue.append([p, path + [p]])


A, P = map(int, input().split())
print(bfs(A))
