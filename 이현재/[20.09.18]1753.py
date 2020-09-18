import sys
import heapq

INF = sys.maxsize
V, E = map(int, sys.stdin.readline().split())
K = int(sys.stdin.readline())
graph = [[] for _ in range(V + 1)]
queue = []


def dijkstra(graph, start, length):
    distance = {node: INF for node in range(1, length + 1)}
    distance[start] = 0
    heapq.heappush(queue, [0, start])

    while queue:
        # print("Queue: ", queue)
        current_dist, current_node = heapq.heappop(queue)
        # print(current_node, "번째 값: ", current_dist)
        # print(distance[current_node], current_dist)
        if distance[current_node] < current_dist:
            continue
        # if not graph.get(current_node):
        #    continue
        for dist, next_node in graph[current_node]:
            dist += current_dist
            if dist < distance[next_node]:
                distance[next_node] = dist
                heapq.heappush(queue, (dist, next_node))

    return distance


for i in range(E):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append((w, v))

result = dijkstra(graph, K, V)

for i in range(1, V + 1):
    print(result[i] if result[i] != INF else "INF")
