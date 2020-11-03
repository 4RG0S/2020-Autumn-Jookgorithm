import sys

parent = {}
rank = {}

def make_set(v):
    parent[v] = v
    rank[v] = 0

def find(v):
    if parent[v] != v:
        parent[v] = find(parent[v])
    return parent[v]

def union(u, v):
    root1 = find(u)
    root2 = find(v)

    if root1 != root2:
        if rank[root1] > rank[root2]:
            parent[root2] = root1
        else:
            parent[root1] = root2
            if rank[root1] == rank[root2]:
                rank[root2] += 1

def kruskal(vertex_list, edges):
    for u in vertex_list:
        make_set(u)

    sum = 0
    for e in edges:
        cost, u, v = e
        if find(u) != find(v):
            union(u, v)
            sum += cost
    return sum

def main():
    N =int(input())
    M = int(input())

    vertices = []
    edges = []

    for i in range(1, N+1):
        vertices.append(str(i))
    for _ in range(M):
        u, v, c = sys.stdin.readline().rsplit()
        if u == v: continue
        edges.append((int(c), u, v))
    edges.sort()
    print(kruskal(vertices, edges))

if __name__ == "__main__":
    main()