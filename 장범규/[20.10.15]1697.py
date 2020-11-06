import sys
from collections import deque
input = sys.stdin.readline

def bfs(graph,n,k) :
    q = deque()
    visit = [False for i in range(200001)]
    time = [0 for i in range(200001)]
    q.append(n)
    visit[n] = True
    while q :
        dot = q.popleft()
        if (dot == k) :
            break
        for i in graph[dot] :
            try :
                if (visit[i]) :
                    continue
                q.append(i)
                visit[i] = True
                time[i] = time[dot]+1
            except :
                continue

    return time[k]

n,k = map(int, input().split())
graph = {}
for i in range(200001) :
    if (i == 0) :
        graph[i] = [0]
        graph[i].append(1)
        continue
    graph[i] = [i-1]
    graph[i].append(i+1)
    graph[i].append(i*2)

print(bfs(graph,n,k))