def main():
    str = input()
    alphabet_list = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
    for alpha in alphabet_list:
        str = str.replace(alpha, '0')
    print(len(str))


if __name__ == '__main__':
    main()
