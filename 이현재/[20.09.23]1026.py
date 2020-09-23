N = int(input())
A = B = [0 for _ in range(N)]

A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort(reverse=True)

min_sum = 0
for j in range(len(A)):
    temp_min = min(B)
    min_sum += A[j] * temp_min
    B.pop(B.index(temp_min))

print(min_sum)
