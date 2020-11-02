def main():
    n, m = map(int, input().split())
    n_list = set()
    m_list = set()

    for i in range(n):
        n_list.add(input())
    for j in range(m):
        m_list.add(input())

    result_list = list(n_list & m_list)
    print(len(result_list))
    for s in sorted(result_list):
        print(s)


if __name__ == '__main__':
    main()
