import sys
import heapq


def dijkstra(graph, V, src, dst):
    distance = [float('Inf') for _ in range(V + 1)]
    distance[src] = 0
    queue = []
    heapq.heappush(queue, [0, src])
    found = [False for _ in range(V + 1)]
    while queue:
        v = heapq.heappop(queue)
        found[v[1]] = True
        for node_weight in graph[v[1]]:
            if found[node_weight[0]]: continue
            if distance[node_weight[0]] > distance[v[1]] + node_weight[1]:
                distance[node_weight[0]] = distance[v[1]] + node_weight[1]
                heapq.heappush(queue, [distance[node_weight[0]], node_weight[0]])
    return distance[dst]


if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    M = int(input())
    graph = [[] for _ in range(N + 1)]

    for i in range(M):
        u, v, w = map(int, input().split())
        graph[u].append([v, w])

    src, dst = map(int, input().split())
    print(dijkstra(graph, N, src, dst))
