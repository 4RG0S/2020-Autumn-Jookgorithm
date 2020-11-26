t = int(input())

for _ in range(t):
    n = int(input())
    votedList = list()

    for _ in range(n):
        votedList.append(int(input()))

    fun = lambda i: votedList[i]
    argmax = max(range(len(votedList)), key=fun)

    if votedList.count(votedList[argmax]) == 1:
        print('majority winner {}'.format(argmax + 1) if votedList[argmax] > sum(votedList) / 2 else 'minority winner {}'.format(argmax + 1))
    else:
        print('no winner')
