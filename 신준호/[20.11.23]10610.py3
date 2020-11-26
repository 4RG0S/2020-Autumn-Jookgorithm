n = list(map(int, list(input())))

if (0 not in n) or (sum(n) % 3 != 0):
    print('-1')
else:
    n.sort(reverse=True)
    print(''.join(list(map(str, n))))