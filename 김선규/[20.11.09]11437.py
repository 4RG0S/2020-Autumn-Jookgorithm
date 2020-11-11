import sys
from collections import deque

def dfs(tree, parent, depth):
    que = deque()
    que.append(1)
    parent[1] = -1
    depth[1] = 1
    while que:
        x = que.popleft()
        for i in tree[x]:
            if parent[i] != 0: continue
            parent[i] = x
            depth[i] = depth[x] + 1
            que.append(i)

def lca(x, y, parent, depth):
    if depth[x] < depth[y]:
        x, y = y, x
    while depth[x] != depth[y]:
        x = parent[x]
    while x != y:
        x = parent[x]
        y = parent[y]
    return x

def main():
    n = int(sys.stdin.readline())
    tree = [[] for _ in range(n+1)]
    parent = [0 for _ in range(n+1)]
    depth = [0 for _ in range(n+1)]
    for _ in range(n-1):
        x, y = map(int, sys.stdin.readline().rsplit())
        tree[x].append(y)
        tree[y].append(x)
    dfs(tree, parent, depth)

    m = int(sys.stdin.readline())
    for _ in range(m):
        x, y = map(int, sys.stdin.readline().rsplit())
        print(lca(x, y, parent, depth))

if __name__ == '__main__':
    main()