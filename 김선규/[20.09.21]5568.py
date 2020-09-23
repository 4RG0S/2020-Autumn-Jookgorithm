def func(li, k):
    result = []
    if k == 1:
        for i in li:
            result += [[i]]
    else:
        for i in li:
            copyli = li.copy()
            copyli.remove(i)
            for j in func(copyli, k-1):
                j.insert(0, i)
                if j not in result:
                    result.append(j)
    return result

def main():
    n = int(input())
    k = int(input())
    li = []
    for _ in range(n):
        li.append(input())
    
    li = func(li,k)
    li2 = []
    for i in li:
        s = ""
        for j in i:
            s += j
        li2.append(s)
    print(len(set(li2)))

if __name__ == "__main__":
    main()