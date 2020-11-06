import sys
input = sys.stdin.readline

n = int(input())
n_list = []
n_dict = {}
for i in range(n) :
    data = int(input())
    n_list.append(data)
    if (data in n_dict) :
        n_dict[data] += 1
    else :
        n_dict[data] = 1

print(round(sum(n_list)/n))
n_list.sort()
print(n_list[n//2])
order = sorted(n_dict.items(),key=lambda x:(-x[1],x[0]))
try :
    if (order[0][1] == order[1][1]) :
        print(order[1][0])
    else :
        print(order[0][0])
except :
    print(order[0][0])
print(n_list[-1]-n_list[0])