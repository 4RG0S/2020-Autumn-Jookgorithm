n = int(input())
a = list(map(int, input().split()))

m = int(input())
b = list(map(int, input().split()))

dict = {}
for i in a:
    dict[i] = True

for i in b:
    try:
        dict[i]
        print(1)
    except:
        print(0)
