from sys import stdin

numbers = sorted(list(map(int, stdin.readline().split())))

result = numbers[2]

while True:
    count = 0
    for number in numbers:
        if result % number == 0:
            count += 1
    if count > 2:
        break
    result += 1

print(result)