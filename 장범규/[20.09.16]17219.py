import sys

n, m = map(int, sys.stdin.readline().split())
sp = {}

for i in range(n) :
    site, pw = sys.stdin.readline().split()
    sp[site] = pw

for i in range(m) :
    search = sys.stdin.readline().rstrip()
    print(sp[search])