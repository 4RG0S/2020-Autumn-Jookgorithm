import sys
input = sys.stdin.readline

n_list = list(map(int, input().split()))
i = min(n_list)
while True :
    count = 0
    for j in range(5) :
        if (i%n_list[j] == 0) :
            count += 1
    if (count >= 3) :
        print(i)
        break
    i += 1