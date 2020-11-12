import heapq


def dijkstra(edges, V, E, src):
    INF = float('inf')
    distance = [INF for _ in range(V + 1)]
    distance[src] = 0
    queue = []
    found = [False for _ in range(V + 1)]

    heapq.heappush(queue, [0, src])  # 거리의 값, 노드 값

    while queue:
        v = heapq.heappop(queue)  # 해당 v 에서부터의 간선과 비교
        found[v[1]] = True  # v1은 노드 , 최단 경로 찾음
        for node_weight in edges[v[1]]:
            if found[node_weight[0]]: continue
            # 현재 nodeweight의 distance와 v에서 현재 nodeweight로 갈때 비교
            if distance[node_weight[0]] > distance[v[1]] + node_weight[1]:
                distance[node_weight[0]] = distance[v[1]] + node_weight[1]
                heapq.heappush(queue, [distance[node_weight[0]], node_weight[0]])  # 거리 ,노드
    for i in range(1, V + 1):
        if i == src:
            print(0)
        elif distance[i] == INF:
            print('INF')
        else:
            print(distance[i])


def main():
    V, E = map(int, input().split())  # 노드, 엣지
    src = int(input())
    edges = [[] for _ in range(V + 1)]

    for _ in range(E):
        i, j, c = map(int, input().split())
        edges[i].append([j, c])  # i에서 j로 가는데 c 비용 걸림
    #print(edges)
    dijkstra(edges, V, E, src)


if __name__ == '__main__':
    main()
