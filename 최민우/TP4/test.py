import fractions


def GCD(a, b):
    while b != 0:
        d = a % b
        a = b
        b = d
    return a


def gcd_N(arr):
    gcd = arr[0]
    for item in arr:
        gcd = GCD(gcd, item)
    return gcd


tCase = int(input())

n = []
de = []
newN = []
for i in range(tCase):
    k = [int(N) for N in input().strip().split()]
    temp = fractions.Fraction(k[0], k[1])
    n.append(temp.numerator)
    de.append(temp.denominator)

lcm = 1
for item in de:
    a = lcm
    b = item
    while b > 0:
        a, b = b, a % b

    lcm = lcm * item // a

for i in range(tCase):
    tmp = lcm // de[i]
    newN.append(n[i] * tmp)

print(gcd_N(newN), lcm)
