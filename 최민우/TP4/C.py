import sys
from fractions import Fraction

result = None
for _ in range(int(sys.stdin.readline().rstrip())):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    if result:
        result += Fraction(a, b)
    else:
        result = Fraction(a, b)
    print(result)

print(1, result)
