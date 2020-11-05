import sys
from collections import deque
input = sys.stdin.readline

T = int(input())

for i in range(T) :
    cmd = list(input().rstrip())
    l = int(input())
    in_elements = input().rstrip()
    in_elements = in_elements.replace('[','').replace(']','')
    elements = deque(in_elements.split(','))
    status = 1
    reverse = False
    for j in cmd :
        if j == 'R' :
            reverse = not reverse
        else :
            if (l == 0) :
                print("error")
                status = 0
                break
            else :
                if (reverse) :
                    elements.pop()
                else :
                    elements.popleft()
                l -= 1
    if (status == 1) :
        if (l == 0) :
            print("[]")
        else :
            print("[",end="")
            if (reverse) :
                while elements :
                    if (l == 1) :
                        break
                    print(elements.pop(),end=",")
                    l -= 1
            else :
                while elements :
                    if (l == 1) :
                        break
                    print(elements.popleft(),end=",")
                    l -= 1
            print(elements.pop(),end="]\n")