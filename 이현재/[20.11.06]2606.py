from collections import deque


def dfs(graph):
    stack = deque()
    stack.append(1)
    visit = []

    while stack:
        n = stack.pop()
        if n not in visit:
            visit.append(n)
            for e in graph[n]:
                if e not in visit:
                    stack.append(e)
    return visit


def main():
    n = int(input())
    e = int(input())

    graph = [[] for _ in range(n + 1)]

    for _ in range(e):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    print(len(dfs(graph)) - 1)


if __name__ == '__main__':
    main()
