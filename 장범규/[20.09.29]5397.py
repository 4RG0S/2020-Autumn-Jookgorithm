import sys
from collections import deque

n = int(input())
for i in range(n) :
    log = sys.stdin.readline().rstrip()
    pw = deque()
    tmp = []
    for c in log :
        if (c == '<') :
            if pw :
                tmp.append(pw.pop())
        elif (c == '>') :
            if tmp :
                pw.append(tmp.pop())
        elif (c == '-') :
            if pw :
                pw.pop()
        else :
            pw.append(c)
    tmp.reverse()
    pw.extend(tmp)
    print(''.join(pw))