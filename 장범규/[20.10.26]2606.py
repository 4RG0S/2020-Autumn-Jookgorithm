import sys
from collections import deque
input = sys.stdin.readline

def bfs(graph) :
    chk_bfs = [False for i in range(n+1)]
    q = deque()
    q.append(1)
    chk_bfs[1] = True
    count = 0
    while q :
        v = q.popleft()
        for i in graph[v] :
            if (not chk_bfs[i]) :
                count += 1
                q.append(i)
                chk_bfs[i] = True
    return count

n = int(input())
m = int(input())
graph = {}
for i in range(m) :
    a,b = map(int, input().split())
    if (a in graph) :
        graph[a].append(b)
    else :
        graph[a] = [b]
    if (b in graph) :
        if (a not in graph[b]) :
            graph[b].append(a)
    else :
        graph[b] = [a]

print(bfs(graph))