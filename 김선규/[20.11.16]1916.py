import sys
import heapq
INF = float('inf')

def dijkstra(edges, n, s):
    cost = [INF for _ in range(n+1)]
    cost[s] = 0
    visit = [False for _ in range(n+1)]
    que = []
    heapq.heappush(que, [0, s])

    while que:
        v = heapq.heappop(que)
        for i in edges[v[1]].keys():
            if visit[i]: continue
            if cost[i] > v[0] + edges[v[1]][i]:
                cost[i] = v[0] + edges[v[1]][i]
                heapq.heappush(que, [cost[i], i])
    return cost

def main():
    n = int(sys.stdin.readline())
    m = int(sys.stdin.readline())
    edges = {i:{} for i in range(n+1)}
    for i in range(m):
        s, d, c = map(int, sys.stdin.readline().split())
        try:
            edges[s][d] = min(edges[s][d], c)
        except Exception:
            edges[s][d] = c
    
    s, d = map(int, sys.stdin.readline().split())
    cost = dijkstra(edges, n, s)
    print(cost[d])

if __name__ == '__main__':
    main()