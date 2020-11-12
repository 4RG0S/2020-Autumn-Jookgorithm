import sys

input = sys.stdin.readline
n = int(input())
A = list(map(int, input().split()))
dic = dict()
for i in range(n):
    if A[i] not in dic:
        dic[A[i]] = 1
    else:
        dic[A[i]] += 1

m = int(input())
B = list(map(int, input().split()))

result = []
for i in range(m):
    if B[i] in dic:
        result.append(dic[B[i]])
    else:
        result.append(0)

print(*result)
