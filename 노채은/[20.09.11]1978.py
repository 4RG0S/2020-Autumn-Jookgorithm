#BOJ 1978

num = input()
count = int(num)
num2 = list(map(int,input().split(' ')))
if len(num2) == int(num):
    for i in num2:
        if i != 1:
            for j in range(2,i):
                if (i/j) % 1 == 0:
                    count -=1
                    break
        else:
            count -=1
else:
    pass
print(count)
