n = int(input())

point = [[] for _ in range(n)]
paper = [[0 for _ in range(100)] for _ in range(100)]

for i in range(n):
    x, y = map(int, input().split())
    for ix in range(x, x+10):
        for iy in range(y, y + 10):
            paper[ix][iy] = 1

result = 0
for i in range(100):
    for j in range(100):
        if paper[i][j] == 1:
          result += 1

print(result)