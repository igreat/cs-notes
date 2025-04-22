This was a problem our prof presented in Lecture 6 of Algorithms (UCL 2023-2024)
Struggled to wrap my head around it but I managed to solve it eventually. This was a true test for my understanding of recursion, trees and linked lists, so worth a revisit for exam.
```python
class Node:
    left: Self
    right: Self
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def insert(root: Node, value: int) -> Node:
    if root is None:
        return Node(value)
    if value < root.value:
        root.left = insert(root.left, value)
    else:
        root.right = insert(root.right, value)
    return root

def bst_to_linked(root: Node) -> Node:
    if root is None:
        return None
    
    left_list = bst_to_linked(root.left)
    right_list = bst_to_linked(root.right)

    # making the root a circular linked list
    root.left = root
    root.right = root

    if left_list is None:
        left_list = root
    if right_list is None:
        right_list = root

    # stitching left with root
    left_list.left.right = root
    root.left = left_list.left

    # stitching left with right
    left_list.left = right_list.left
    right_list.left.right = left_list

    # stitching right with root
    right_list.left = root
    root.right = right_list

    return left_list
```

**For testing**:
```python
# test case
root = None
root = insert(root, 4)
root = insert(root, 2)
root = insert(root, 5)
root = insert(root, 1)
root = insert(root, 3)
root = insert(root, 6)

linked_list = bst_to_linked(root)
```