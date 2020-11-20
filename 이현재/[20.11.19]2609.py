def gcd(a, b):
    if a % b == 0:
        return b
    else:
        return gcd(b, a % b)


if __name__ == '__main__':
    a, b = map(int, input().split())
    if a < b:
        a, b = b, a
    c_div = gcd(a, b)
    print(c_div)
    print(a * b // c_div)
