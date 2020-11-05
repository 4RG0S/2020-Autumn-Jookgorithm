import sys
from collections import deque
input = sys.stdin.readline

def bfs(graph,v) :
    q = deque()
    chk = [False for i in range(n+1)]
    chk[v] = True
    q.append(v)
    judge = 0
    tmp = -1
    total = 0
    deep = 1
    while q :
        val = q.popleft()
        if (val == tmp) :
            deep += 1
            judge = 0
        for i in graph[val] :
            if (chk[i]) :
                continue
            q.append(i)
            total += deep
            if (judge == 0) :
                tmp = i
                judge = 1
            chk[i] = True
    return total

n,m = map(int, input().split())
graph = {}

for i in range(m) :
    a,b = map(int, input().split())
    if (a not in graph) :
        graph[a] = [b]
    else :
        graph[a].append(b)
    if (b not in graph) :
        graph[b] = [a]
    else :
        graph[b].append(a)

for i in graph.values() :
    i.sort()

games = []
for i in range(1,n+1) :
    games.append(bfs(graph,i))
print(games.index(min(games))+1)