def find_leafnode(tree, i):
    if len(tree[i]) ==  0:
        if i == -1:
            return 0
        return 1
    else:
        sum = 0
        for j in tree[i]:
            sum += find_leafnode(tree, j)
        return sum

def main():
    n = int(input())
    tree = {i:[] for i in range(-1, n)}
    parent = list(map(int, input().split()))
    for i in range(n):
        tree[parent[i]].append(i)
    rm = int(input())
    tree[parent[rm]].remove(rm)
    print(find_leafnode(tree, -1))

if __name__ == '__main__':
    main()