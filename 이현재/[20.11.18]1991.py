def preorder(lst, root):
    print(root, end="")
    if lst[root][0] != '.':
        preorder(lst, lst[root][0])
    if lst[root][1] != '.':
        preorder(lst, lst[root][1])


def inorder(lst, root):
    if lst[root][0] != '.':
        inorder(lst, lst[root][0])
    print(root, end="")
    if lst[root][1] != '.':
        inorder(lst, lst[root][1])


def postorder(lst, root):
    if lst[root][0] != '.':
        postorder(lst, lst[root][0])
    if lst[root][1] != '.':
        postorder(lst, lst[root][1])
    print(root, end="")


if __name__ == '__main__':
    n = int(input())
    tree = {}
    for _ in range(n):
        r, lc, rc = input().split()
        if r not in tree:
            tree[r] = [lc, rc]
        else:
            tree[r].append([lc, rc])
    # print(tree)
    preorder(tree, 'A')
    print()
    inorder(tree, 'A')
    print()
    postorder(tree, 'A')
