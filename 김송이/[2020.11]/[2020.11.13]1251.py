def main():
    word = input()
    combi = []
    word_list = []
    combine = []

    for i in range(1,len(word)-1):
        for j in range(1,len(word)-i):
            combi.append((i,j))
    #print(combi)
    for i in combi:
        combine.extend(reversed(word[:i[0]]))
        combine.extend(reversed(word[i[0]:i[0]+i[1]]))
        combine.extend(reversed(word[i[0]+i[1]:]))
        word_list.append(''.join(combine))
        combine=[]
    word_list.sort()
    print(word_list[0])


if __name__ == '__main__':
    main()