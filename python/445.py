class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        l1_len = self.get_length(l1)
        l2_len = self.get_length(l2)
        if l1_len == 0 and l2_len == 0:
            return None
        if l2_len > l1_len:
            l1, l2 = l2, l1
        diff = abs(l1_len - l2_len)
        node = l1
        new_node = ListNode(node.val)
        ret = new_node
        diff -= 1

        while diff >= 0:
            if diff == 0:
                if node.next and l2.next and node.next.val + l2.next.val > 9:
                    new_node.val += 1
                node = node.next
                break
            node = node.next
            new_node.next = ListNode(node.val)
            new_node = new_node.next
            diff -= 1
        print(l1_len)

        while node.next is not None:
            if node.next.val + l2.next.val > 9:
                new_node.next = ListNode((node.val + l2.val + 1) % 10)
            else:
                new_node.next = ListNode((node.val + l2.val) % 10)
            node = node.next
            new_node = new_node.next
            l2 = l2.next

        self.print_listnode(ret)
        return ret

    def get_length(self, l: ListNode) -> int:
        length = 0
        while l != None:
            length += 1
            l = l.next
        return length

    def print_listnode(self, l: ListNode) -> None:
        while l.next is not None:
            print(l.val)
            l = l.next

a = ListNode(7)
b = ListNode(2)
c = ListNode(4)
d = ListNode(3)
a.next = b
b.next = c
c.next = d

z1 = ListNode(5)
z2 = ListNode(6)
z3 = ListNode(4)
z1.next = z2
z2.next = z3

s = Solution()
ans = s.addTwoNumbers(a, z1)
print(ans)
