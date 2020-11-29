import heapq

INF = float('inf')
def dijkstra(edges, V, E, src, dst):

    distance = [INF for _ in range(V + 1)]
    distance[src] = 0
    queue = []
    found = [False for _ in range(V + 1)]

    heapq.heappush(queue, [0, src])  # 거리의 값, 노드 값

    while queue:
        v = heapq.heappop(queue) #해당 v 에서부터의 간선과 비교
        found[v[1]] = True  # v1은 노드 , 최단 경로 찾음
        for node_weight in edges[v[1]]: # 노드, 거리
            if found[node_weight[0]]: continue
            # 현재 nodeweight의 distance와 v에서 현재 nodeweight로 갈때 비교
            if distance[node_weight[0]] > distance[v[1]] + node_weight[1]:
                distance[node_weight[0]] = distance[v[1]] + node_weight[1]
                heapq.heappush(queue, [distance[node_weight[0]], node_weight[0]]) #거리 ,노드
    return distance


def main():
    V, E = map(int, input().split())  # 노드, 엣지
    edges = [[] for _ in range(V + 1)]

    for _ in range(E):
        i, j, c = map(int, input().split())
        edges[i].append([j, c])  # i에서 j로 가는데 c 비용 걸림
        edges[j].append([i, c])  # 양방향 허용하므로
    a, b = map(int,input().split())
    start_one = dijkstra(edges, V, E, 1, V)
    start_a = dijkstra(edges, V, E, a, V)
    start_b= dijkstra(edges, V, E, b, V)
    result = min((start_one[a]+start_a[b]+start_b[V]),(start_one[b]+start_b[a]+start_a[V]))

    if result< INF:
        print(result)
    else:
        print(-1)

if __name__ == '__main__':
    main()