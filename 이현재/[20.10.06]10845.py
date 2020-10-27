from collections import deque
import sys

n = int(sys.stdin.readline())

queue = deque()
for i in range(n):
    s = sys.stdin.readline().rstrip('\n').split(' ')
    if s[0] == 'push':
        queue.append(s[1])
    elif s[0] == 'pop':
        print(queue.popleft() if len(queue) != 0 else - 1)
    elif s[0] == 'size':
        print(len(queue))
    elif s[0] == 'empty':
        print(1 if len(queue) == 0 else 0)
    elif s[0] == 'front':
        print(queue[0] if len(queue) != 0 else -1)
    elif s[0] == 'back':
        print(queue[-1] if len(queue) != 0 else -1)
