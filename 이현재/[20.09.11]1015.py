import sys

n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))
p = {}

# i = index, v = value
# 딕셔너리 p안에 v가 존재할 떄
# key의 값이 int이면 key에 리스트의 형태로 p[v]와 i를 묶어 저장한다>
# key의 값이 list이면 해당 리스트에 i를 추가한다.
for i, v in enumerate(sorted(a)):
    if v in p:
        if type(p[v]) is int:
            p[v] = [p[v], i]
        else:
            p[v].append(i)
    else:
        p[v] = i

# list로 저장되어 있으면 pop해 가장 처음의 값을 출력
# 아니면 p[i]를 출력

for i in a:
    if type(p[i]) is list:
        print(p[i].pop(0), end=' ')
    else:
        print(p[i], end=' ')






# b[p[0]] = a[0] = 2  1
# b[p[1]] = a[1] = 3  0
# b[p[2]] = a[2] = 1  1
#                     0
#                     1
# value로 정렬
# b[p[2]] = a[2] = 1
# b[p[0]] = a[0] = 2
# b[p[1]] = a[1] = 3

# p[2] = 0
# p[0] = 1
# p[1] = 2

# p[0] = 1
# p[1] = 2
# p[2] = 0

