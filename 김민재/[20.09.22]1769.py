from sys import stdin

num = stdin.readline().rstrip()
count = 0

while len(num) > 1:
    num = str(sum(map(int,num)))
    count += 1

print(count)
print("YES" if int(num) % 3 == 0 else "NO")
