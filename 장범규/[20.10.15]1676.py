import sys,math
input = sys.stdin.readline

n = int(input())
count = 0
idx = 0
for i in reversed(list(str(math.factorial(n)))) :
    if (i != '0') :
        print(count)
        break
    count += 1