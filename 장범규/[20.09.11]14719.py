h, w = map(int, input().split())
apt = [[0 for cow in range(w)] for row in range(h)]

lst = list(map(int, input().split()))

for i in range(w) :
    for j in range(lst[i]) :
        apt[j][i] = 1

sum = 0
for i in range(h) :
    chk = 0
    count = 0
    for j in range(w-1) :
        if (chk == 0) :
            if (apt[i][j] == 1 and apt[i][j+1] == 0) :
                chk = 1
        else :
            if (apt[i][j] == 0) :
                count += 1
            else :
                if (apt[i][j+1] != 0) :
                    chk = 0
                sum += count
                count = 0
    if (apt[i][w-1] == 1) :
        sum += count

print(sum)