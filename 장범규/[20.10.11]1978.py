def prime_list(n):
    sieve = [True]*n

    m = int(n**0.5)
    for i in range(2,m+1) :
        if sieve[i] == True :
            for j in range(i+i,n,i):
                sieve[j] = False

    return [i for i in range(2, n) if sieve[i] == True]

n = int(input())
n_list = list(map(int, input().split()))

prime = prime_list(max(n_list)+1)
count = 0
for i in n_list :
    if (i in prime) :
        count += 1
print(count)