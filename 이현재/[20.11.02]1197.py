import heapq


def prim(edges, N):
    queue = []
    heapq.heappush(queue, [0, 0, 1])

    visit = [False for _ in range(N + 1)]
    result = []
    sum = 0

    while queue:
        # h[0]: link cost, h[1]: current node, h[2]: next node
        h = heapq.heappop(queue)
        if visit[h[2]]:
            continue
        else:
            visit[h[2]] = True
            sum += h[0]
            result.append((h[1], h[2], h[0]))

        for e in edges[h[2]]:
            if visit[e[0]]: continue
            heapq.heappush(queue, [e[1], h[2], e[0]])
    return sum


def main():
    V, E = map(int, input().split())

    edges = [[] for _ in range(V + 1)]
    for _ in range(E):
        a, b, c = map(int, input().split())
        edges[a].append([b, c])
        edges[b].append([a, c])
    print(prim(edges, V))


if __name__ == "__main__":
    main()
