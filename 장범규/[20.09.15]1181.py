import sys

n = int(sys.stdin.readline())
word = {}

for i in range(n) :
    v = sys.stdin.readline().rstrip()
    word[v] = len(v)

word = sorted(word.items())
word = dict(word)
word = sorted(word.items(), key=(lambda x: x[1]))

for i in word :
    print(i[0])