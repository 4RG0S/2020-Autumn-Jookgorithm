import sys
input = sys.stdin.readline

n = int(input())
length = int(input())
ioi = input().rstrip()
i,count,result = 1,0,0
while (i < length-1) :
    if (ioi[i-1] == 'I' and ioi[i] == 'O' and ioi[i+1] == 'I') :
        count += 1
        if (count == n) :
            result += 1
            count -= 1
        i += 1
    else :
        count = 0
    i += 1
print(result)