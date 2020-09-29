import sys

sys.setrecursionlimit(1000000)

result = 0
nodes = {}


def recursive_bfs(node):
    global result
    if node not in nodes:
        return 0
    elif not nodes[node]:
        return 0
    result_list = []

    for p, v in nodes[node]:
        result_list.append(recursive_bfs(p) + v)
    result = max(result, sum(sorted(result_list, reverse=True)[:2]))
    return max(result_list)


n = int(sys.stdin.readline().rstrip())

for _ in range(n - 1):
    a, b, value = map(int, sys.stdin.readline().rstrip().split())

    if a not in nodes:
        nodes[a] = [(b, value)]
    elif (b, value) not in nodes[a]:
        nodes[a].append((b, value))
    if b not in nodes:
        nodes[b] = []

recursive_bfs(1)
print(result)
