import heapq


def dfs(graph, root):
    visited = []
    stack = [root]

    while stack:
        n = stack.pop()
        if n not in visited:
            visited.append(n)
            temp = list(set(graph[n]) - set(visited))
            temp.sort(reverse=True)
            stack += temp
    return " ".join(str(i) for i in visited)


def bfs(graph, root):
    visited = []
    queue = []
    heapq.heappush(queue, root)

    while queue:
        n = queue.pop(0)
        if n not in visited:
            visited.append(n)

            temp = list(set(graph[n]) - set(visited))
            temp.sort()
            queue += temp

    return " ".join(str(i) for i in visited)


N, M, V = map(int, input().split())

graph = [[] for i in range(N + 1)]

for i in range(M):
    node1, node2 = map(int, input().split())
    graph[node1].append(node2)
    graph[node2].append(node1)

print(dfs(graph, V))
print(bfs(graph, V))
