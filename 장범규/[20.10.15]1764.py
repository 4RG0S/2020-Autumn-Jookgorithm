import sys
input = sys.stdin.readline

l,s = map(int, input().split())
no_listen = {}
no_see = {}
for i in range(l) :
    no_listen[input().rstrip()] = None
for i in range(s) :
    no_see[input().rstrip()] = None
no_lisee = {}
for i in no_listen :
    if (i in no_see) :
        no_lisee[i] = None
for i in no_see :
    if (i in no_listen) :
        no_lisee[i] = None

no_lisee = sorted(no_lisee.keys())
print(len(no_lisee))
for i in no_lisee :
    print(i)
