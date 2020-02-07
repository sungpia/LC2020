class Node:
    def __init__(self, val: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(val)
        self.next = next
        self.random = random
