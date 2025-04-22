## Implementation
```python
BLACK = 0
RED = 1
class Node[T]:
    key: int
    value: T
    left: Self
    right: Self
    color: int
    def __init__(self, key, value, color=BLACK):
        self.key = key
        self.value = value
        self.left = None
        self.right = None
        self.color = color

class RedBlackTree[T]:
    root: Node[T]
    def __init__(self):
        self.root = None

    def insert(self, key: int, value: T):
        if self.root is None:
            self.root = Node(key, value, BLACK)
            return
        self.root = self._insert(self.root, key, value)
        self.root.color = BLACK

    def _insert(self, node: Node, key: int, value: T):
        if node is None:
            return Node(key, value, RED)
        if key == node.key:
            node.value = value
        elif key < node.key:
            node.left = self._insert(node.left, key, value)
        else:
            node.right = self._insert(node.right, key, value)

        # balancing
        if self.is_red(node.right) and self.is_black(node.left):
            node = self.rotate_left(node)
        if self.is_red(node.left) and self.is_red(node.left.left):
            node = self.rotate_right(node)
        if self.is_red(node.left) and self.is_red(node.right):
            self.flip_colors(node)
        
        return node
    
    def is_red(self, node: Node):
        return node is not None and node.color == RED
    
    def is_black(self, node: Node):
        return node is None or node.color == BLACK
    
    def rotate_left(self, node: Node):
        x = node
        y = x.right
        x.right = y.left
        y.left = x
        y.color = x.color
        x.color = RED
        return y
    
    def rotate_right(self, node: Node):
        x = node
        y = x.left
        x.left = y.right
        y.right = x
        y.color = x.color
        x.color = RED
        return y
    
    def flip_colors(self, node: Node):
        node.color = RED
        node.left.color = BLACK
        node.right.color = BLACK

    def get(self, key: int):
        return self._get(self.root, key)
    
    def _get(self, node: Node, key: int):
        if node is None:
            return None
        if key == node.key:
            return node.value
        if key < node.key:
            return self._get(node.left, key)
        return self._get(node.right, key)
```
## Balancing Operations
### Left Rotation
Orient a (temporarily) right-leaning red link so to lean left
![[Screenshot 2024-04-30 at 12.31.06 PM.png]]
```python
def rotate_left(A):
	B = A.right
	A.right = B.left
	B.left = A
	B.color = A.color
	A.color = RED
	return B
```
### Right Rotation
Orient a left-leaning red link so to (temporarily) lean right
![[Screenshot 2024-04-30 at 12.35.25 PM.png]]
```python
def rotate_right(B):
	A = B.left
	B.left = A.right
	A.right = B
	A.color = B.color
	B.color = RED
	return A
```
### Color Flip
Recolor to split a (temporary) 4-node into two 2-nodes.

| ![[Screenshot 2024-04-30 at 12.38.28 PM.png]] | ![[Screenshot 2024-04-30 at 12.38.35 PM.png]] |
| --------------------------------------------- | --------------------------------------------- |
```python
def flip_colors(B):
	B.color = RED
	B.left.color = BLACK
	B.right.color = BLACK
```
### Bringing it All Together
After inserting a value, we locally check if there is any broken RBT invariants in the current subtree, and appropriately apply the balancing operation.
```python
if self.is_red(node.right) and self.is_black(node.left):
	node = self.rotate_left(node)
if self.is_red(node.left) and self.is_red(node.left.left):
	node = self.rotate_right(node)
if self.is_red(node.left) and self.is_red(node.right):
	self.flip_colors(node)
```
![[Screenshot 2024-04-30 at 12.51.19 PM.png]]
*Example in slides. Shows why we check for consecutive red links before checking for potential color flips*

## Performance
- Every path from root to leaf has the same number of black links
- There are never two red links in a row
- Height of **LLRD** BST is `<= 2log(N)` even in the worst case.
- Worst case time complexity:
	- Insertion: $O(\log(N))$
	- Search: $O(\log(N))$
	- Delete (not shown): $O(\log(N))$
