import sys
input = sys.stdin.readline

n,m,b = map(int, input().split())
block = []
for i in range(n) :
    block.append(list(map(int, input().split())))

process = {}
for h in range(257) :
    time = 0
    inven = b
    for i in range(n) :
        for j in range(m) :
            processing = h-block[i][j]
            if (processing > 0) :
                time += processing*1
            else :
                time += -processing*2
            inven -= processing
    if (inven >= 0) :
        if (time in process) :
            process[time].append(h)
        else :
            process[time] = [h]
process = sorted(process.items(),key=lambda x:x[0])
print(process[0][0],max(process[0][1]))