# problem : https://www.acmicpc.net/problem/1057

def solve(A, B, cnt):
    if A == B:
        return cnt

    else:
        A = (A + 1) // 2
        B = (B + 1) // 2
        cnt += 1
        return solve(A, B, cnt)

N, A, B = input().split()
A = int(A)
B = int(B)

print(solve(A, B, 0))