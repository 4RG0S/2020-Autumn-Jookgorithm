n = int(input())
wait_line = []

for i in range(n) :
    wait_line.append(input().split())

w_l = []
for i in range(n) :
    w_l.extend(wait_line[i])

wait_line = w_l
order = []
for i in range(n*5) :
    v = wait_line[i].split("-")
    order.append([v[0],int(v[1])])

order.sort(key=lambda x:[x[0],x[1]])
odr = []
for i in range(n*5) :
    odr.append(order[i][0]+"-"+str(order[i][1]))

t_line = []
while True :
    if (len(wait_line) != 0 and odr[0] == wait_line[0]) :
        odr.pop(0)
        wait_line.pop(0)
    elif (len(t_line) != 0 and t_line[-1] == odr[0]) :
        odr.pop(0)
        t_line.pop() 
    else :
        if (len(wait_line) == 0) :
            print("BAD")
            break
        t_line.append(wait_line.pop(0))
    if (len(odr) == 0) :
        print("GOOD")
        break