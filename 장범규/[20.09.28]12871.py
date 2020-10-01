import math

def lcm(data1, data2) :
    return data1*data2//math.gcd(data1,data2)

s = input()
t = input()
l_s = len(s)
l_t = len(t)
if l_s == l_t :
    if (s == t) :
        print(1)
    else :
        print(0)
else :
    l = lcm(l_s,l_t)
    s *= l//l_s
    t *= l//l_t
    if (s == t) :
        print(1)
    else :
        print(0)