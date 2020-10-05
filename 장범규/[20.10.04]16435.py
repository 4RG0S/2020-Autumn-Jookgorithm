f,l = map(int, input().split())
fruit = list(map(int, input().split()))
fruit.sort()

for i in range(f) :
    if (fruit[i] <= l) :
        l += 1
print(l)