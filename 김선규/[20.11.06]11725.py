import sys
from collections import deque

def dfs(root, tree, n):
    parent = [ 0 for _ in range(n+1)]
    parent[root] = -1
    que = deque()
    que.append(root)

    while que:
        v = que.pop()
        for i in tree[v]:
            if parent[i] == 0:
                parent[i] = v
                que.append(i)

    return parent

def main():
    n = int(sys.stdin.readline())
    tree = [[] for _ in range(n+1)]
    for _ in range(n-1):
        a, b = map(int, sys.stdin.readline().split())
        tree[a].append(b)
        tree[b].append(a)
    
    parent = dfs(1, tree, n)
    
    for i in range(2, n+1):
        print(parent[i])

if __name__ == '__main__':
    main()