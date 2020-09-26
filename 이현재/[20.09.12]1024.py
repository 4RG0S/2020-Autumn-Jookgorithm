"""
N의 총합은 x부터 x + l - 1까지의 합이다
N = lx + l * (l - 1) / 2
x는 N에서 0부터 l - 1까지의 합을 뺀 것을 l로 나누었을 때의 몫이다
따라서 l로 나누었을 때 나머지가 0이고 몫이 양수가 나온다면 x를 찾은 것이다.
"""
import sys

N, L = map(int, sys.stdin.readline().split())
x = k = -1
for i in range(L, 101):
    T = int(i * (i - 1) / 2)
    if (N - T) % i == 0 and (N - T) // i >= 0:
        x = (N - T) // i
        k = i
        break

if x != -1:
    for i in range(0, k):
        print(x + i, end=" ")
else:
    print(-1)
