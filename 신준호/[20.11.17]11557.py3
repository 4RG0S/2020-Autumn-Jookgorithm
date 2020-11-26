from functools import cmp_to_key

def compare(x, y):
    return 1 if x[1] < y[1] else -1

t = int(input())
for _ in range(t):
    n = int(input())
    schools = list()
    for _ in range(n):
        name, alcohol = input().split()
        alcohol = int(alcohol)
        schools.append([name, alcohol])

    schools = sorted(schools, key=cmp_to_key(compare))
    print(schools[0][0])
