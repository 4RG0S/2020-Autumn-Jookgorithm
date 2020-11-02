def swap(num1, num2):
    if num1 < num2:
        temp = num1
        num1 = num2
        num2 = temp


def gcd(num1, num2):
    mod = num1 % num2
    if mod == 0:
        return num2
    else:
        return gcd(num2, mod)


a, b = map(int, input().split())
if a < b:
    swap(a, b)
m = gcd(a, b)
print(m)
print(int(a * b / m))
