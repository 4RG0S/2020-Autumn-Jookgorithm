import sys
import heapq
INF = float('inf')

def dijkstra(edges, n, c):
    dist = [INF for _ in range(n+1)]
    dist[c] = 0
    que = []
    heapq.heappush(que, [0, c])

    while que:
        v = heapq.heappop(que)
        for i in edges[v[1]].keys():
            if dist[i] > v[0] + edges[v[1]][i]:
                dist[i] = v[0] + edges[v[1]][i]
                heapq.heappush(que, [dist[i], i])
    return dist

def main():
    t = int(sys.stdin.readline())
    for _ in range(t):
        n, d, c = map(int, sys.stdin.readline().split())
        edges = {i:{} for i in range(n+1)}
        for i in range(d):
            a, b, s = map(int, sys.stdin.readline().split())
            edges[b][a] = s

        dist = dijkstra(edges, n, c)
        computer = 0
        time = 0
        for i in dist:
            if i != INF:
                computer += 1
                time = max(time, i)
        print(computer, time)

if __name__ == '__main__':
    main()