import sys
import heapq
INF = float('inf')

def dijkstra(edges, n, x):
    dist = [INF for _ in range(n+1)]
    dist[x] = 0
    que = []
    heapq.heappush(que, [0, x])

    while que:
        v = heapq.heappop(que)
        for i in edges[v[1]].keys():
            if dist[i] > v[0] + edges[v[1]][i]:
                dist[i] = v[0] + edges[v[1]][i]
                heapq.heappush(que, [dist[i], i])
    return dist

def main():
    n, m, x = map(int, sys.stdin.readline().split())
    edges = {i:{} for i in range(n+1)}
    for _ in range(m):
        s, d, t = map(int, sys.stdin.readline().split())
        edges[s][d] = t

    gohome = dijkstra(edges, n, x)
    time = []
    for i in range(1, n+1):
        goparty = dijkstra(edges, n, i)
        time.append(goparty[x] + gohome[i])
    print(max(time))

if __name__ == "__main__":
    main()