import sys
import heapq

input = sys.stdin.readline


def connect(edges, start, visited):
    queue = []
    heapq.heappush(queue, start)
    visited[start] = True
    while queue:
        p = heapq.heappop(queue)
        for k in edges[p]:
            if visited[k]:
                continue
            visited[k] = True
            heapq.heappush(queue, k)


if __name__ == '__main__':
    n, m = map(int, input().split())
    edges = {x: [] for x in range(1, n + 1)}
    for _ in range(m):
        u, v = map(int, input().split())
        edges[u].append(v)
        edges[v].append(u)

    path = 0
    visited = {x: [] for x in range(1, n + 1)}
    for i in range(1, n + 1):
        if not visited[i]:
            connect(edges, i, visited)
            path += 1
    print(path)
