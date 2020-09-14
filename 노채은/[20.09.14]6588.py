#BOJ 6588

def primelist(n):
    primecheck = [True] * (n+1)

    m = int(n ** 0.5)
    for i in range(2, m+1) :
        if primecheck[i] == True :
            for j in range(i+i, n+1, i):
                primecheck[j] = False

    return [[i for i in range(2, n+1) if primecheck[i] == True], primecheck]

primarynum = primelist(1000000)[0]
primarybool = primelist(1000000)[1]

import sys
input = sys.stdin.readline

while(True) :
    N = int(input())
    if N == 0 :
        break
    for i in range(N // 2) :
        if primarybool[N - primarynum[i]] == True :
            print("{} = {} + {}".format(N, primarynum[i], N - primarynum[i]))
            break
