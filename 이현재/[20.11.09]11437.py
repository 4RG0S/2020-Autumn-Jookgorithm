import sys
from collections import deque


def make_tree(n, edge_list):
    for _ in range(n - 1):
        a, b = map(int, input().split())
        edge_list[a].append(b)
        edge_list[b].append(a)


def dfs(n, edge_list, tree, depth, root):
    check = [0 for _ in range(n + 1)]
    check[root] = True

    q = deque([root])
    while len(q):
        now = q.popleft()
        for nxt in edge_list[now]:
            if check[nxt]:
                continue
            depth[nxt] = depth[now] + 1
            check[nxt] = True
            tree[nxt] = now
            q.append(nxt)


def lca(tree, depth, u, v):
    if depth[u] < depth[v]: u, v = v, u
    while depth[u] != depth[v]: u = tree[u]
    while u != v: u, v = tree[u], tree[v]
    return u


if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    edge = [[] for _ in range(N + 1)]
    make_tree(N, edge)

    tree, depth = [[0 for _ in range(N + 1)] for _ in range(2)]
    dfs(N, edge, tree, depth, 1)

    M = int(input())
    for _ in range(M):
        u, v = map(int, input().split())
        print(lca(tree, depth, u, v))
