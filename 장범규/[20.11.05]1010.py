from math import factorial

t = int(input())
for i in range(t) :
    n,m = map(int, input().split())
    combi = factorial(m)//(factorial(n)*factorial(m-n))
    print(combi)