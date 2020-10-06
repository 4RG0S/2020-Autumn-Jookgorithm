import re

t = int(input())
p = re.compile("(100+1+|01)+")
for _ in range(t):
    s = input()
    m = p.fullmatch(s)
    if m:
        print('YES')
    else:
        print('NO')