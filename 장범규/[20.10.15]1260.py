import sys
from collections import deque
sys.setrecursionlimit(10**8)
input = sys.stdin.readline

def dfs(graph,v) :
    if (chk_dfs[v]) :
        return
    print(v,end=" ")
    chk_dfs[v] = True
    try :
        for i in graph[v] :
            dfs(graph,i)
    except :
        return

def bfs(graph,v) :
    q = deque()
    chk_bfs[v] = True
    q.append(v)
    print(v,end=" ")
    try :
        while q :
            for i in graph[q.popleft()] :
                if (chk_bfs[i]) :
                    continue
                print(i,end=" ")
                q.append(i)
                chk_bfs[i] = True
    except :
        return
        
n,m,v = map(int, input().split())
graph = {}
chk_dfs,chk_bfs = [False for i in range(n+1)],[False for i in range(n+1)]
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

dfs(graph,v)
print()
bfs(graph,v)