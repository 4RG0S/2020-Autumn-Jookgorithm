# problem : https://www.acmicpc.net/problem/1026
def solve(n, a, b):
    ret = 0

    for i in range(n):
        ret += min(a) * max(b)
        a.remove(min(a))
        b.remove(max(b))
    return ret

n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

print(solve(n, a, b))