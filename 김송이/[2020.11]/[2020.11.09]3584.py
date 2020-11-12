def make_tree(N, tree, parent_list):
    for i in range(N - 1):
        parent, child = input().split()
        tree[parent] = child
        tree[child] = parent
        parent_list[child] = parent


def main():
    case = int(input())
    for i in range(case):
        N = int(input())
        tree = {}
        parent_list = {}
        make_tree(N, tree, parent_list)

        for i in tree.keys():
            if i not in parent_list.keys():
                parent_list[i]=0

        targetA, targetB = input().split()
        # a,b의 부모노드를 차례로 저장할 리스트(아래->위)
        A_parent = [targetA]
        B_parent = [targetB]

        while parent_list[targetA]:
            A_parent.append(parent_list[targetA])
            targetA = parent_list[targetA]

        while parent_list[targetB]:
            B_parent.append(parent_list[targetB])
            targetB = parent_list[targetB]
        # 루트 노드에서부터 달라질 때까지 검사
        depthA = len(A_parent)-1
        depthB =len(B_parent)-1

        while A_parent[depthA] == B_parent[depthB]:
            depthA-=1
            depthB-=1

        print(A_parent[depthA+1])


if __name__ == '__main__':
    main()
