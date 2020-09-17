N = int(input())

numbers = [(i, int(input())) for i in range(N)]
numbers_sorted = sorted(numbers, key=lambda x: x[1])

print(max([numbers_sorted[i][0] - i for i in range(N)]) + 1)