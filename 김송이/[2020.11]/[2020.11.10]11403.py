
def bfs(graph, i, j, find):
    visits = []
    queue = []
    visits.append(i)
    queue.append(i)

    while queue:
        k= queue.pop(0)
        for v in graph[k]:
            if v == j:
                print(1,end=' ')
                find = True
                break
            if v not in visits:
                queue.append(v)
                visits.append(v)
        if find == True:
            break
    if not find:
        print(0,end=' ')

def main():
    n = int(input())
    matrix = []
    for i in range(n):
        matrix.append(list(map(int, input().split())))
    #print(matrix)
    graph = {}
    for i in range(n):
        graph[i] = []
        for j in range(n):
            if matrix[i][j] == 1:
                graph[i].append(j)
    #print(graph)
    for i in range(n):
        for j in range(n):
            find = False
            bfs(graph, i, j, find)
        print()


if __name__ == '__main__':
    main()
