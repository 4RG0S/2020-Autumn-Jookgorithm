def dfs(matrix, n, count, x, y):
    matrix[x][y] = 0
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n:
            if matrix[nx][ny] == 1:
                count = dfs(matrix, n, count + 1, nx, ny)
    return count


def main():
    n = int(input())
    matrix = [list(map(int, input())) for _ in range(n)]

    apart_block = []
    for i in range(n):
        for j in range(n):
            if matrix[i][j] == 1:
                apart_block.append(dfs(matrix, n, 1, i, j))

    print(len(apart_block))
    for i in sorted(apart_block):
        print(i)


if __name__ == '__main__':
    main()
