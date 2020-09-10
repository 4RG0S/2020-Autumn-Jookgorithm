def factorial(n):
    fac = 1
    for i in range(1, n + 1):
        fac *= i
    return fac


def count(n, r):
    fac_n = factorial(n)
    fac_r = factorial(r)
    fac_t = factorial(n - r)

    return fac_n // fac_t // fac_r


k = int(input())

for i in range(k):
    l = list(map(int, input().split()))
    result = count(l[1], l[0])
    print(int(result))