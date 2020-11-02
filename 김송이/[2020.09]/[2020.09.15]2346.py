class Node(object):
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList(object):
    def __init__(self):
        self.head = None
        self.count = 0

    # 마지막에 삽입
    def insert(self, node):
        if self.head == None:
            self.head = node
        else:
            head = self.head
            while head.next != None:
                head = head.next
            head.next = node

    # 인덱스에 맞는 값 삭제
    def deleteNodeAtIndex(self, index):
        # 리스트 초기화
        currentNode_i = 0
        currentNode = self.head
        previousNode = None
        nextNode = self.head.next

        if index == 0:
            self.head = nextNode
        else:
            while currentNode_i < index:
                previousNode = currentNode
                currentNode = nextNode
                nextNode = nextNode.next
                currentNode_i += 1
            deleteNode = currentNode
            previousNode.next = nextNode
        return deleteNode

    def print(self):
        currentNode = self.head
        while currentNode != None:
            print(currentNode.data)
            currentNode=currentNode.next


def main():
    balloon_list = LinkedList()
    balloon_list.insert(Node(1))
    balloon_list.insert(Node(2))
    balloon_list.insert(Node(3))
    balloon_list.insert(Node(4))
    balloon_list.insert(Node(5))
    balloon_list.deleteNodeAtIndex(3)
    balloon_list.print()


if __name__ == '__main__':
    main()
