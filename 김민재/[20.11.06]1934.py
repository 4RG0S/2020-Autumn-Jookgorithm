from sys import stdin


def GCD(X, Y):
    while (Y):
        X, Y = Y, X % Y
    return X


def LCM(X, Y):
    return (X * Y) // GCD(X, Y)


T = int(stdin.readline())
result = []

for i in range(T):
    A, B = map(int, stdin.readline().split())
    result.append(LCM(A, B))

for i in result:
    print(i)
