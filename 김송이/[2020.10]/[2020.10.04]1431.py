
def main():
    n = int(input())
    guitar_list = []
    for _ in range(n):
        guitar = input()
        count =0
        for c in guitar:
            if c.isdigit():
                count+=int(c)
        guitar_list.append((guitar,count))

    guitar_list.sort(key=lambda x:(len(x[0]),x[1],x[0]))
    for s in guitar_list:
        print(s[0])

if __name__ == '__main__':
    main()
