from collections import deque

visited = [False for _ in range(100001)]


def bfs(n, k):
    queue = deque()
    queue.append([n, 0])

    while queue:
        # n[0] : current node, n[1] : time
        node, time = queue.popleft()
        # print(node, time)
        if not visited[node]:
            visited[node] = True
            if node == k:
                return time

            time = time + 1
            tmp = [node * 2, node - 1, node + 1]
            for x in tmp:
                if 0 <= x <= 100000:
                    queue.append([x, time])


def main():
    n, k = map(int, input().split())
    print(bfs(n, k))


if __name__ == '__main__':
    main()
