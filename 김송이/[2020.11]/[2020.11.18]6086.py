from collections import defaultdict, deque

INF = float('inf')


def bfs(source, sink, parent, edge):  # 임의의 경로 찾을 때 사용
    visited = defaultdict(lambda: 0) #디폴트 값을 0으로 설정
    queue = deque()
    queue.append(source)
    visited[source] = 1
    while queue:
        u = queue.popleft()
        for i in edge[u]:
            capacity = edge[u][i]
            if visited[i]:
                continue
            if capacity <= 0:
                continue
            queue.append(i)
            visited[i] = 1
            parent[i] = u

    if visited[sink]:
        return 1
    else:
        return 0


def min_flow(source, sink, parent, edge):
    flow = INF
    while sink != source:  # 싱크노드로부터 소스노드로
        flow = min(flow, edge[parent[sink]][sink])
        sink = parent[sink]
    return flow


def ford_fulkerson(source, sink, edge):
    parent = defaultdict(lambda: -1)
    max_flow = 0
    while bfs(source, sink, parent, edge):
        path_flow = min_flow(source, sink, parent, edge)
        max_flow += path_flow
        v = sink
        while v != source:
            u = parent[v]
            edge[u][v] -= path_flow  # 순방향으로 갈수록 줄어들음
            edge[v][u] += path_flow  # 이게 반대방향
            v = parent[v]
    return max_flow


def main():
    n = int(input())
    edge = defaultdict(lambda: defaultdict(int)) #dic의 디폴트값이 dict

    for _ in range(n):
        i, j, c = map(str, input().split())
        edge[i][j] += int(c) # 0으로 초기화 되어있으므로 += 해주는 것
        edge[j][i] += int(c)
    print(ford_fulkerson('A', 'Z', edge))


if __name__ == '__main__':
    main()
