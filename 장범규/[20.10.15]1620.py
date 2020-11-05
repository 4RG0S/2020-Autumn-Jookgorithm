import sys
input = sys.stdin.readline

n,m = map(int, input().split())
name_dict = {}
number_dict = {}
for i in range(n) :
    name = input().rstrip()
    name_dict[name] = i+1
    number_dict[i+1] = name
for i in range(m) :
    problem = input().rstrip()
    try :
        print(number_dict[int(problem)])
    except :
        print(name_dict[problem])