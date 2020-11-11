import sys
from math import log2
from collections import deque

def main():
    n = int(sys.stdin.readline())
    logN = int(log2(n)+1)
    tree = [[] for _ in range(n+1)]
    parent = [0 for _ in range(n+1)]
    depth = [0 for _ in range(n+1)]
    for _ in range(n-1):
        x, y = map(int, sys.stdin.readline().rsplit())
        tree[x].append(y)
        tree[y].append(x)
    
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

    exp_parent = [[0 for _ in range(logN)] for i in range(n+1)]
    for i in range(n+1):
        exp_parent[i][0] = parent[i]
    for j in range(1, logN):
        for i in range(1, n+1):
            exp_parent[i][j] = exp_parent[exp_parent[i][j-1]][j-1]

    m = int(sys.stdin.readline())
    for _ in range(m):
        x, y = map(int, sys.stdin.readline().rsplit())
        if depth[x] > depth[y]:
            x, y = y, x
        dif = depth[y] - depth[x]
        for i in range(logN):
            if dif & 1<<i:
                y = exp_parent[y][i]

        if x == y:
            print(x)
            continue

        for i in range(logN-1, -1, -1):
            if exp_parent[x][i] != exp_parent[y][i]:
                x = exp_parent[x][i]
                y = exp_parent[y][i]
        
        print(exp_parent[x][0])

if __name__ == '__main__':
    main()