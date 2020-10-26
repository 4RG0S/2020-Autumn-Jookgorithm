class stringSort(object):
    def __init__(self, s):
        self.s = s

    def __lt__(self, other):
        if self.s != other.s:
            return self.s < other.s


def main():
    S = list(input())
    suffix = ''
    array = []
    for i in range(len(S)):
        array.append(''.join(S))
        S.pop(0)
    array.sort(key=lambda x:stringSort(x))
    for i in array:
        print(i)


if __name__ == '__main__':
    main()
