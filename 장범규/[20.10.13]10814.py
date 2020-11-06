import sys
input = sys.stdin.readline

n = int(input())
register = {}
for i in range(n) :
    age,name = input().split()
    age = int(age)
    if (age in register) :
        register[age].append(name)
    else :
        register[age] = [name]

register = sorted(register.items(),key=lambda x:x[0])

for i in range(len(register)) :
    for j in range(len(register[i][1])) :
        print(register[i][0],register[i][1][j])