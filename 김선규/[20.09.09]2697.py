def func(n):
    a = -1
    for i in range(len(n)-2, -1, -1):
        if n[i] < n[i+1] :
            a = i
            break
    
    if a == -1 :
        return "BIGGEST"

    b = n.index(max(n[a+1:]))
    for i in range(len(n)-1, a+1, -1):
        if n[a] < n[i] < n[b] :
            b = i
    
    n = swap(n, a, b)
    n = n[:a+1] + ''.join(sorted(n[a+1:]))
    return n

def swap(c, i, j):
    c = list(c)
    c[i], c[j] = c[j], c[i]
    return ''.join(c)

def main():
    n = int(input())

    for _ in range(0, n):
        num = input()
        print(func(num))

if __name__ == '__main__':
    main()