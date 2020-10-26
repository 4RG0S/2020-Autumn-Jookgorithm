import re


def main():
    p = re.compile('(\d+)(:)(\d+)')
    s = input()
    num1 = int(p.match(s).group(1))
    num2 = int(p.match(s).group(3))

    for i in range(1,min(num1,num2)+1):
        if num1%i==0 and num2%i==0:
            op=i
    result = str(num1//op)+':'+str(num2//op)
    print(result)


if __name__ == '__main__':
    main()
