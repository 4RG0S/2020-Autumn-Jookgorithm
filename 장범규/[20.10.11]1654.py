import sys

k,n = map(int, sys.stdin.readline().split())
line_list = []

for i in range(k) :
    line_list.append(int(sys.stdin.readline()))

l,r = 1,max(line_list)
while (l <= r) :
    m = (l+r)//2
    count = 0
    for i in line_list :
        count += i//m

    if (count >= n) :
        l = m+1
    else :
        r = m-1
print(r)