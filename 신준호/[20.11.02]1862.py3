num = input()
num = num[::-1]

multiplier = 1
ret = 0
for n in num:
    n = int(n)
    if n > 4:
        n -= 1

    ret += n * multiplier
    multiplier *= 9

print(ret)