from queue import Queue

wolf = input()
q = Queue()

for c in wolf :
    q.put(c)

w,o,l,f = 0,0,0,0
status = -1
while (not q.empty()) :
    c = q.get()
    if (status == -1) :
        if (c == 'w') :
            status = 0
        else :
            break
    if (c == 'w' and (status == 0 or status == 3)) :
        if (status == 3 and not (w == o and o == l and l == f)) :
            status = -1
            break
        if (status == 0 or status == 3) :
            w += 1
            status = 0
        else :
            status = -1
            break
    elif (c == 'o') :
        if (status == 0 or status == 1) :
            o += 1
            status = 1
        else :
            status = -1
            break
    elif (c == 'l') :
        if (status == 1 or status == 2) :
            l += 1
            status = 2
        else :
            status = -1
            break
    elif (c == 'f') :
        if (status == 2 or status == 3) :
            f += 1
            status = 3
        else :
            status = -1
            break

if (status == 3 and (w == o and o == l and l == f)) :
    print(1)
else :
    print(0)