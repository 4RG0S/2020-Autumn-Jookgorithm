t = int(input())

for _ in range(t):
    sound = input().split()

    s = None
    animals = list()
    while s != 'what does the fox say?':
        s = input()
        animals.append(s.split()[2])

    fox = list()
    for v in sound:
        if v not in animals:
            fox.append(v)

    print(' '.join(fox))