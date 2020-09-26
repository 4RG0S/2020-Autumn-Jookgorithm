import sys

sys.setrecursionlimit(1000000)

nodes = {}

for _ in range(int(sys.stdin.readline().strip())):
    inputs = sys.stdin.readline().strip().split(' ')
    nodes[inputs[0]] = [inputs[1], inputs[2]]


def preorder_travel(node):
    return node + preorder_travel(nodes[node][0]) + preorder_travel(nodes[node][1]) if node != '.' else ''


def inorder_travel(node):
    return inorder_travel(nodes[node][0]) + node + inorder_travel(nodes[node][1]) if node != '.' else ''


def postorder_travel(node):
    return postorder_travel(nodes[node][0]) + postorder_travel(nodes[node][1]) + node if node != '.' else ''


print(preorder_travel('A'))
print(inorder_travel('A'))
print(postorder_travel('A'))
