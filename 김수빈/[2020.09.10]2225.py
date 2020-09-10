def fact(n):
    a =1
    for i in range(1, n+1):
        a *= i
    return a

n, k = input().split()
n = int(n)
k = int(k)
print(fact(n+k-1)//(fact(k-1)*fact(n))%1000000000)