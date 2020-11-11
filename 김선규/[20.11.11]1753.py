import sys
import heapq
INF = float('inf')

def dijkstra(edges, V, src):
    distance = [INF for _ in range(V+1)]
    distance[src] = 0
    queue = []
    heapq.heappush(queue, [0, src])

    while queue:
        v = heapq.heappop(queue)
        for node_weight in edges[v[1]].keys():
            if distance[node_weight] > v[0] + edges[v[1]][node_weight]:
                distance[node_weight] = v[0] + edges[v[1]][node_weight]
                heapq.heappush(queue, [distance[node_weight], node_weight])
    return distance

def main():
    V, E = map(int, sys.stdin.readline().split())
    src = int(sys.stdin.readline())
    edges = { i : {} for i in range(V+1)}

    for _ in range(E):
        i, j, c = map(int, sys.stdin.readline().split())
        try:
            edges[i][j] = min(edges[i][j], c)
        except Exception:
            edges[i][j] = c
    
    distance = dijkstra(edges, V, src)
    for i in range(1, V+1):
        if distance[i] == INF:
            print('INF')
        else:
            print(distance[i])

if __name__ == '__main__':
    main()