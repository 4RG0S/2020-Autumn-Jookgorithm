A, P = input().split()

P = int(P)

li = list()
while A not in li:
    li.append(A)
    nextNum = 0
    for n in A:
        n = int(n)
        nextNum += n ** P

    A = str(nextNum)

print(li.index(A))