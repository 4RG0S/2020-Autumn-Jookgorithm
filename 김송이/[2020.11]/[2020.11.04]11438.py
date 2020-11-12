from math import log2
from collections import deque


def generate_tree(tree, N):
    for _ in range(N - 1):
        parent, child = map(int, input().split())
        tree[child].append(parent)
        tree[parent].append(child)
        # child에서 parent로 돌아가는 링크도 필요하므로
        # 부모든 자식이든 인접해있으면 추가


def dfs(tree, parent_list, depth, N):
    visited = [False for _ in range(N + 1)]
    q = deque()
    q.append(1)

    while q:
        p = q.popleft()
        visited[p] = True
        for i in tree[p]:
            if visited[i] == False:
                q.append(i)  # 탐색할 정점 스택에 추가
                parent_list[i] = p
                depth[i] = depth[p] + 1


def compute_exp_parent(exp_parent, N):
    logN = int(log2(N) + 1)
    for i in range(1, N + 1):
        for j in range(1, logN):
            # 정점 i의 2^j번째 부모 노드 결정
            exp_parent[i][j] = exp_parent[exp_parent[i][j - 1]][j - 1]  # 2^n = 2^n-1 + 2^n-1


def search_lca(exp_parent, depth, N, M):
    logN = (int)(log2(N) + 1)
    for _ in range(M):
        a, b = map(int, input().split())
        if depth[a] > depth[b]:
            a, b = b, a  # 즉 길이가 긴것이 b, 작은것이 a가 됨
        level_diff = depth[b] - depth[a]
        for i in range(logN):
            if level_diff & (1 << i):
                b = exp_parent[b][i]  # 길이가 긴 것을 짧은것에 맞춘다.

        if a == b:  # a와 b의 높이 맞추었는데 그게 조상노드인 경우
            print(a)  # 최소 공통 조상 노드 찾은 것
            continue

        for i in range(logN - 1, -1, -1):  # 최소 공통 조상노드를 찾기위해 위에서부터 내려가는 것 (2->1->0)
            if exp_parent[a][i] != exp_parent[b][i]:  # a의 parent와 b의 parent가 같지 않으면
                # a와 b위로 이동
                a = exp_parent[a][i]
                b = exp_parent[b][i]
        print(exp_parent[b][0])  # 최소 공통 조상 노드(2^0 즉 첫번째 parent)


def main():
    N = int(input())
    tree = [[] for _ in range(N + 1)]
    generate_tree(tree, N)  # 트리 구현

    parent_list = [0 for _ in range(N + 1)]
    depth = [0 for _ in range(N + 1)]
    dfs(tree, parent_list, depth, N)  # dfs로 탐색(parent_list만들기)

    logN = (int)(log2(N) + 1)
    exp_parent = [[0 for _ in range(logN)] for i in range(N + 1)]
    for i in range(N + 1):
        exp_parent[i][0] = parent_list[i]
    compute_exp_parent(exp_parent, N)
    M = int(input())
    search_lca(exp_parent, depth, N, M)


if __name__ == '__main__':
    main()
