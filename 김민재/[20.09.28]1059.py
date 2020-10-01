from sys import stdin

stdin.readline()
Lucky_Set = sorted(list(map(int, stdin.readline().split())))
N = int(stdin.readline())

start = 1
if N in Lucky_Set:
    print(0)
else:
    for Lucky_num in Lucky_Set:
        if N > Lucky_num:
            start = Lucky_num + 1
        else:
            end = Lucky_num - 1
            break
    print(end - start + (end - N) * (N - start))
