n = int(input())
card = list(map(int, input().split()))
m = int(input())
search = list(map(int, input().split()))

c = dict.fromkeys(card,0)
for i in card :
    c[i] += 1

for i in search :
    if (i in c) :
        print(c[i],end=" ")
    else :
        print(0,end=" ")