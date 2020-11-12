def preorder(tree, node, visit_list):  # V L R
    print(node,end='')
    if tree[node][0] != '.':
        preorder(tree, tree[node][0], visit_list)  # 자식노드1
    if tree[node][1] != '.':
        preorder(tree, tree[node][1], visit_list)  # 자식노드2


def inorder(tree, node, visit_list):  # L V R
    if tree[node][0] != '.':
        inorder(tree, tree[node][0], visit_list)
    print(node,end='')
    if tree[node][1] != '.':
        inorder(tree, tree[node][1], visit_list)


def postorder(tree, node, visit_list):  # L R V
    if tree[node][0] != '.':
        postorder(tree, tree[node][0], visit_list)
    if tree[node][1] != '.':
        postorder(tree, tree[node][1], visit_list)
    print(node,end='')


def main():
    n = int(input().strip())
    tree = {}
    visit_list = []
    node = None
    for _ in range(n):
        # V L R
        node_list = input().strip().split(' ')
        tree[node_list[0]] = [node_list[1], node_list[2]]
    #print(tree)
    preorder(tree, 'A', visit_list)
    print()

    visit_list = []
    inorder(tree, 'A', visit_list)
    print()

    visit_list = []
    postorder(tree, 'A', visit_list)
    print()


if __name__ == '__main__':
    main()
