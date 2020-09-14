import sys

n, m = map(int, sys.stdin.readline().split())

remain = []
allg = [0 for _ in range(n+1)]

for i in range(m) :
    remn = int(sys.stdin.readline())
    allg[remn] = 1
    remain.append(remn)

j = 0
for i in range(1,n+1) :
    if (allg[i] == 0) :
        chk = False
        while (j < m) :
            if (i < remain[j]) :
                print(i)
                chk = True
                break
            else :
                print(remain[j])
            j += 1
        if (chk == False) :
            print(i)

while (j < m) :
    print(remain[j])
    j += 1