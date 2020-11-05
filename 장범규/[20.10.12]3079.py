n,m = map(int, input().split())
judge = []
for i in range(n) :
    judge.append(int(input()))

l,r,result = 0,max(judge)*m,max(judge)*m
search_list = []
while (l <= r) :
    mid = (l+r)//2
    search = 0
    for i in judge :
        search += mid//i
    if (search >= m) :
        result = min(result,mid)
        r = mid-1
    else :
        l = mid+1
print(result)