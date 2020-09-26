import math

def calc(A, B):
    opt = float('inf')
    if A == B:
        return 0
    if A > B:
        return opt

    opt = min(calc(A * 2, B) + 1, opt)
    opt = min(calc(int(str(A) + '1'), B) + 1, opt)

    return opt



A, B = input().split(' ')
A = int(A)
B = int(B)

val = calc(A, B)
if val == float('inf'):
    print(-1)
else:
    print(val + 1)