def preorder(tree, node):
    print(node, end="")
    if tree[node][0] != '.':
        preorder(tree, tree[node][0])
    if tree[node][1] != '.':
        preorder(tree, tree[node][1])

def inorder(tree, node):
    if tree[node][0] != '.':
        inorder(tree, tree[node][0])
    print(node, end="")
    if tree[node][1] != '.':
        inorder(tree, tree[node][1])

def postorder(tree, node):
    if tree[node][0] != '.':
        postorder(tree, tree[node][0])
    if tree[node][1] != '.':
        postorder(tree, tree[node][1])
    print(node, end="")

def main():
    n = int(input())
    tree = { chr(i):[] for i in range(65, 91)}
    for i in range(n):
        p, l, r = input().split()
        if l == '.':
            tree[p].append('.')
        else:
            tree[p].append(l)
        if r == '.':
            tree[p].append('.')
        else:
            tree[p].append(r)
    preorder(tree , 'A')
    print()
    inorder(tree, 'A')
    print()
    postorder(tree, 'A')

if __name__ == '__main__':
    main()