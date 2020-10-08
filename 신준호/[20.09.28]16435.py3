n, m = map(int, input().split())

foods = list(map(int, input().split()))
foods.sort()

idx = 0
for i in range(len(foods)):
    if i + m >= foods[i]:
        idx += 1
    else:
        break
        
print(idx + m)