import re

def main():
    n = int(input())
    li= []
    for _ in range(n):
        li += re.findall('\d+', input())
    for i in range(len(li)):
        li[i] = int(li[i])
    li = sorted(li)
    for i in li:
        print(int(i))

if __name__ == '__main__':
    main()