import sys
sys.setrecursionlimit(10000)

def dfs(root):
    visits[root] = 1
    for i in range(1, n + 1):
        if visits[i] == 0 and matrix[root][i] != 0:
            dfs(i)


n, m = map(int, input().split())
visits = [0 for _ in range(n + 1)]  # 노드의 방문 상태를 저장하는 리스트
matrix = [[0] * (n + 1) for _ in range(n + 1)]
count = 0

for k in range(m):
    i, j = map(int, input().split())
    matrix[i][j] = 1
    matrix[j][i] = 1
for j in range(1, n + 1):
    if visits[j] == 0:
        dfs(j)
        count += 1

print(count)
