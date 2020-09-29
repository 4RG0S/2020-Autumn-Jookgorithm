from collections import Counter
from pprint import pprint

if __name__ == '__main__':
    standard = Counter(input())
    for _ in range(int(input())):
        var = Counter(input())
        flag = True
        for i in var:
            try:
                standard[i] -= var[i]
            except:
                print(0)
                break
    flag = True
    for i in standard:
        if standard[i] != 0:
            flag = False
    print(1 if flag else 0)
