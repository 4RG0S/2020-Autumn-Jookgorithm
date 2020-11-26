woods = list(map(int, input().split()))

def issorted(woods):
    for idx, num in enumerate(woods):
        if idx + 1 != num:
            return False
    return True

def printer(woods):
    print(' '.join(list(map(str, woods))))

def swap(woods, idx1, idx2):
    tmp = woods[idx1]
    woods[idx1] = woods[idx2]
    woods[idx2] = tmp

while not issorted(woods):
    if woods[0] > woods[1]:
        swap(woods, 0, 1)
        printer(woods)

    if woods[1] > woods[2]:
        swap(woods, 1, 2)
        printer(woods)

    if woods[2] > woods[3]:
        swap(woods, 2, 3)
        printer(woods)

    if woods[3] > woods[4]:
        swap(woods, 3, 4)
        printer(woods)

