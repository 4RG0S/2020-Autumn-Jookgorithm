import re

str = input()

numbers = re.split('-|\+', str)
operation = re.findall('-|\+', str)

base = int(numbers.pop(0))

isSub = False

for op in operation:
    if isSub:
        base -= int(numbers.pop(0))
        continue

    if op == '-':
        isSub = True
        base -= int(numbers.pop(0))
    else:
        base += int(numbers.pop(0))

print(base)