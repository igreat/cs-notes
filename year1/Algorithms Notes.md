## Fundamentals
### Weighted Union Find
```python
class UnionFind:
    parents: list[int]
    sizes: list[int]

    def __init__(self, size: int):
        self.parents = list(range(size))
        self.sizes = [1] * size

    def find(self, u: int) -> int:
        while u != self.parents[u]:
            u = self.parents[u]
        return u

    def union(self, u: int, v: int):
        root_u, root_v = self.find(u), self.find(v)

        if root_u == root_v:
            return

        if self.sizes[root_u] > self.sizes[root_v]:
            self.parents[root_v] = root_u
            self.sizes[root_u] += self.sizes[root_v]
        else:
            self.parents[root_u] = root_v
            self.sizes[root_v] += self.sizes[root_u]
```

|                 | `init` |   `union`    |    `find`    |
| --------------- |:------:|:------------:|:------------:|
| Time Complexity | $O(n)$ | $O(\log(n))$ | $O(\log(n))$ |
*Remark: I had to think a bit why all the nodes don't just end up having the same root so it's a one-layer tree. The multi-layer tree-like structure actually comes from when smaller trees already with a root are connected to a larger tree. The subtrees of the root of the smaller trees remain as its subtrees*

### Analysis of Algorithms
**Math Models**:
$$
\text{total running time} = \text{sum of (cost } \times \text{ frequency) for all operations}
$$
We approximate the time by ignoring all the lower order terms. $\frac{1}{2}N(N+1)$ becomes $\sim\frac{1}{2}N$.  

**Case Analysis**:
- Best Case: examining the *easiest* input.
- Worst Case: examining the *most difficult* input
- Average Case: examining the expected cost for *random* input

**Order of Growth**:
- Big O: *$f$ is asymptotically upper bounded by a constant multiple of $g$*. 
$$
f(x) = O(g(x)) \iff \exists M > 0, n_0 > 0, n \geq n_0 \rightarrow |f(n)| \leq Mg(n)
$$
- Big Omega: *$f$ is asymptotically lower bounded by a constant multiple of $g$*
$$
f(x) = \Omega(g(x)) \iff \exists M > 0, n_0 > 0, n \geq n_0 \rightarrow f(n) \geq Mg(n)
$$
- Big Theta: *$f$ is both asymptotically lower AND upper bounded by constant multiples of $g$*
$$
f(x) = \Theta(g(x)) \\
$$
$$
\exists M_1 > 0, M_2 > 0, n_0 > 0, (n \geq n_0 \rightarrow M_1g(n) \leq f(n) \leq M_2g(n))
$$

If $f(n) = O(g(n))$ and $f(n) = \Omega(g(n))$ then, $f(n) = \Theta(g(n))$.

**Important Remark**:
All Worst, Average and Best cases can have all Big O, Big Omega and Big Theta. We can have a 3x3 matrix to show all of them. *Don't mix the two concepts of case analysis and order of growth.*
### Abstract Data Types (ADTs)
|           | Definition                                                                                    | Basic Operations                                                                | Implementations |
| --------- | --------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | --------------- |
| **Array** | Fixed sized collection with random access read/write                                          | `set(index,element)`<br>`get(index)`                                               | array |
| **List**  | Collection to store sequential elements                                                       | `append(item)`<br>`prepend(item)`<br>`head()`<br>`tail()`                       | array, linked list |
| **Stack** | A collection restrictions where you can only add/remove elements in LIFO: last-in, first-out  | `push(item)`<br>`pop()`<br>`is_empty()`                                         | array, linked list |
| **Queue** | A collection restrictions where you can only add/remove elements in FIFO: first-in, first-out | `enqueue(item)`<br>`dequeue()`                                                  | array, linked list |
| **Set**   | A collection to store unindexed, unordered unrepeated elements                             | `insert(item)`<br>`remove(item)`<br>`contains(item)`                           | hashset, self-balancing bst |
| **Map**   | A collection that can hold data (key, value) pairs, where each key is unique.              | `insert(key, value)`<br>`remove(key)`<br>`update(key, value)`<br>`lookup(key)` | hashtable, self-balancing bst |
| **Priority Queue** | A queue in which items are inserted/removed based on a given priority |`enqueue(item, priority)`<br>`dequeue()`| binary heap |
## Sorting
**Stable Sorting**
A sorting algorithm is stable if it preserves the relative order of duplicated elements after sorting. Useful when sorting based on a certain value without ruining the previous sorting based on another value.
Examples:
- Merge sort
- Insertion sort

**In-place sorting**
A sorting algorithm is in-place if it uses $\leq c \log(N)$ extra memory.
- Selection, insertion and quick sort are in-place, but not merge sort.
### Selection Sort
```python
def selection_sort(a: list[int]):
	for i in range(len(a)):
		min_index = i
		for j in range(i+1, len(a)):
			if (a[j] < a[min_index]):
				min_index = j
		a[i], a[min_index] = a[min_index], a[i]
```
**Complexity Analysis**:
Number of compares: $(N-1) + (N-2) + \cdots + 1 + 0 = \frac{(N-1)(N)}{2} \sim \frac{1}{2} N^2$
Number of exchanges (swaps): $N$
*Worst Case Time Complexity*: $\Omega(N^2) = O(N^2) = \Theta(N^2)$

### Insertion Sort
```python
def insertion_sort(a):
    for i in range(1, len(a)):
        j = i
        while j > 0 and a[j] < a[j - 1]:
            a[j], a[j - 1] = a[j - 1], a[j]
            j -= 1
```
**Complexity Analysis**:
On average: $\sim \frac{1}{4} N^2$ compares and $\sim \frac{1}{4} N^2$ exchanges
Best case (already sorted): $N-1$ compares and $0$ exchanges
Worst case (reverse sorted): $\sim \frac{1}{2} N^2$ compares and $\sim \frac{1}{2} N^2$ exchanges
*Worst Case Time Complexity*: $\Omega(N), O(N^2), \Theta(N^2)$
==Come back to this, why $\Omega(N)$ here and not $\Omega(N^2)$? Why not the stronger lower bound? (ask in forums maybe)==
### Merge Sort
```python
def merge_sort(a, aux, low, high):
	if (high <= low):
		return
	mid = (low + high) // 2
	merge_sort(a, aux, low, mid)
	merge_sort(a, aux, mid+1, high)
	merge(a, aux, low, mid, high)
```

```python
def merge(a, aux, low, mid, high):
	for k in range(low, high+1):
		aux[k] = a[k]

	i = low
	j = mid+1

	for k in range(low, high+1):
		if (i > mid):           a[k] = aux[j]; j += 1
		elif (j > high):        a[k] = aux[i]; i += 1
		elif (aux[j] < aux[i]): a[k] = aux[j]; j += 1
		else:                   a[k] = aux[i]; i += 1
```

**Practical Improvement**
Avoid copying to the auxiliary array during each merge:
```python
def merge_sort(a, aux, low, high):
	if (high <= low): return

	mid = (low + high) // 2
	merge_sort(aux, a, low, mid)    # swap a and aux
	merge_sort(aux, a, mid+1, high) # swap a and aux
	merge(a, aux, low, mid, high)
```
- Initial full copy into aux 
- We keep swapping between aux and main array where one will act as the auxiliary array and the other as the main array.
- Also could early terminate when `a[mid] <= a[mid+1]`

**Time Complexity**
$O(N \log(N)) = \Omega(N \log(N)) = \Theta(N \log(N))$

### Quick Sort
```python
def partition(a: list[int], low: int, high: int) -> int:
    pivot = a[low]
    i = low + 1
    j = high
    while True:
        while i <= j and a[i] <= pivot: i += 1
        while i <= j and a[j] > pivot:  j -= 1
        if i >= j: break
        
        a[i], a[j] = a[j], a[i]
    a[j], a[low] = a[low], a[j]
    return j
```

```python
def quick_sort_recursive(a: list[int], low: int, high: int):
    if low >= high: return
    
    pivot = partition(a, low, high)
    quick_sort_recursive(a, low, pivot-1)
    quick_sort_recursive(a, pivot+1, high)
```

```python
def quick_sort_iterative(a: list[int], low: int, high: int):
    stack = []
    stack.append((low, high))
    while stack:
        low, high = stack.pop()
        pivot = partition(a, low, high)

        if pivot + 1 < high:
            stack.append((pivot+1, high))
            
        if pivot - 1 > low:
            stack.append((low, pivot-1))
```
**Complexity Analysis**:
- Average-case: number of compares $\sim N \log(N)$, $\Theta(N \log(N))$
- Worst-case (array already sorted): $\sim N^2$, $\Theta(N^2)$

Quick sort is **in-place** but is **not stable**.
### Heap 
#### Binary Heap Data Structure
A **complete binary tree** can be represented as an array `a`. 
- For convenience first node starts at index 1 (not 0).
- Parent of node `i` is at `a[i//2]`
- Children of node `i` are at `a[2i]` and `a[2i+1]`

A **Binary Heap** (Max Oriented) is a complete binary tree where:
- Priorities (keys) are stored in the nodes
- A parent's key is `>=` than its children keys
- The highest priority (largest key) is at `a[1]` (root of the tree)

**Binary Heap** enables a very efficient implementation of the Priority Queue ADT:
- Insertion: `enqueue(item, priority)`
- Max deletion: `dequeue()`

**Insertion**:
```python
def enqueue(heap, n, key):
	n += 1
	heap[n] = key;
	swim(heap, n)
```

*Keep swapping with parent (`a[i//2]`) until parent is larger priority*
```python
def swim(heap, i):
	while i > 1 and heap[i//2] < heap[i]:
		heap[i], heap[i//2] = heap[i//2], heap[i]
		i //= 2
```
*Time Complexity*: $O(\log(M))$

**Delete Max**:
```python
def dequeue(heap, n):
	max_element = a[1]
	a[1], a[n] = a[n], a[1]
	a[n] = None
	n -=1
	sink(heap, n, 1)
	return max_element
```

```python
def sink(heap, n, i):
	while 2*i <= n:
		j = 2*i
		if j < n and a[j] < a[j+1]: j += 1
		if a[i] >= a[j]: break
		a[i], a[j] = a[j], a[i]
		i = j
```
*Time Complexity*: $O(\log(M))$
#### Heap Sort
**Heapify**
```python
def heapify(heap, n):
	# a.insert(0, 0)
	for k in range(n//2, 0, -1):
		sink(heap, n, k)
```

```python
def heap_sort(heap, n):
	while n > 1:
		a[1], a[n] = a[n], a[1]
		n -= 1
		sink(heap, n, 1)
```
*Can't use `dequeue` directly because the way we've defined it completely removes the max element. We could put the max element in another list but then the sorting isn't in-place.*

==TODO: come back to understand exact WHY heapify works and its O(N). Why Bottom-Up is O(N) but Top-Down is O(N log(N))==

**Complexity Analysis**:
Mathematical:
- Heapify uses $O(N)$ compares/ exchanges ([nice StackOverflow answer explaining it](https://stackoverflow.com/questions/9755721/how-can-building-a-heap-be-on-time-complexity))
- Heapsort uses $O(N \log(N))$ compares/ exchanges

Properties:
- In-place
- $O(N \log(N))$ worst-case (unlike Quicksort)
- Not stable
- Poor use of cache

### Summary

|           | In-place | Stable |      Worst       |     Average      |       Best       |
| ---------:|:--------:|:------:|:----------------:|:----------------:|:----------------:|
| Selection |    ✅    |        |    $\sim N^2$    |    $\sim N^2$    |    $\sim N^2$    |
| Insertion |    ✅    |   ✅   |    $\sim N^2$    |    $\sim N^2$    |     $\sim N$     |
| Mergesort |          |   ✅   | $\sim N \log(N)$ | $\sim N \log(N)$ | $\sim N \log(N)$ |
| Quicksort |    ✅    |        |    $\sim N^2$    | $\sim N \log(N)$ | $\sim N \log(N)$ |
|  Heapsort |    ✅    |        | $\sim N \log(N)$ | $\sim N \log(N)$ | $\sim N \log(N)$ |

==*Notes on exercises*:==
- I remember being confused with how the idle times self-practice problem was solved, maybe come back to it at some point.
- I skipped over a lot of the whole pancake sorting stuff. Maybe come back to go through it.
## Search
**Symbol Table ADT**:
Also known as associative array, dictionary, or map.
Basic operations:
- `put(key, value)`: Insert a value with a specified key
- `get(key)`: Given a key, search for the corresponding value

Common assumptions:
- Keys are unique
- Values are not null
- Keys have a **total order relation**:
	- *Antisymmetry*: if $a \leq b$ and $b \leq a$ then $a = b$ 
	- *Transitivity*: if $a \leq b$ and $b \leq c$ then $a \leq c$
	- *Totality*: $a \leq b$ or $b \leq a$

### Implementations
#### Linked List With Sequential Search
Unordered linked list of `key-value` pairs.
- `get(key)`: linear scan to find value associated with `key`. $O(N)$
- `put(key, value)`: linear scan through array to find if `key` already exists.
	- If yes, replace it with this new value
	- If no, append a new node with the `key-value` pair to the front.

#### Ordered Array With Binary Search
Ordered array of `keys`, plus another array of their associated `values`.
- `get(key)`: binary search on `keys[]`, then lookup in `values[]`. The associated `value` with have the same index as the `key`.
	- $O(\log(N))$
- `put(key, value)`: binary search on `keys[]`
	- Inserting is still $O(N)$

#### Binary Search Tree (BST)

##### Overview
A **tree** is a non-linear ADT that can be either:
- Empty
- A tree consisting of one node called the root, and zero or one or more disjoint (sub)trees, called children

A **Binary Tree** is a tree with at most 2 children.

A **binary tree** is in **symmetric order** if each node has a key, and every node’s key is:
- **Larger** than all keys in its **left subtree**
- **Smaller** than all keys in its **right subtree**

A **Binary Search Tree** is a binary tree in symmetric order.
##### Implementation
```python
class Tree[T, V]: # T has to be comparable though
    def __init__(self, key, value):
        self.key:   T    = key
        self.value: V    = value
        self.left:  Self = None
        self.right: Self = None
```

```python
def get(self, key):
	return self._get(self._root, key)

def _get(self, node: Tree, key):
	if not node:
		return None
	if key < node.key:
		return self._get(node.left, key)
	elif key > node.key:
		return self._get(node.right, key)
	else:
		return node.value
```

```python
def put(self, key, value):
	self._root = self._put(self._root, key, value)

def _put(self, node, key, value):
	if not node:
		return Tree(key, value)
	if key < node.key:
		node.left = self._put(node.left, key, value)
	elif key > node.key:
		node.right = self._put(node.right, key, value)
	else:
		node.value = value
	return node
```

**Complexity Analysis**:
Cost (number of compare operations):
- Let $h$ be the depth (height) of the tree
- `get(key)`: $1 + h$
- `put(key, value)`: $1 + h$
In the average case, $h = O(\log(N))$, thus both `get` and `put` are $O(\log(N))$ on average.
##### Common Operations on BST:
- `min`: keep traversing to left subtree until left is empty. Return last key.
- `max`: keep traversing to right subtree until right is empty. Return last key.
- `In-order traversal`: 
	- traverse left subtree
	- enqueue key
	- traverse right subtree 
- `floor` (largest key ≤ a given key `k`): search for tree with key `k`
	- If found, return `k` itself
	- If not found, keep backtracking until key associated with latest right turn
- `ceiling` (smallest key ≥ a given key `k`): search for tree with key `k`
	- If found, return `k` itself
	- If not found, keep backtracking until key associated with latest left turn

All above operations are $O(\log(N))$ for BST in the **average case** (all proportional to the height of BST).

##### Deletion
**Delete Minimum**:
- Traverse to the left until finding a node with a null left link
- Replace that node by its right link
```python
def delete_min(node):
	if (node.left == null)
		return node.right
	node.left = delete_min(node.left)
	return node
```

**Hibbard Deletion**
- Search for note `t` with key `k`
- Case 0: `t` has no children
	- Delete `t` by setting parent link to null
- Case 1: `t` has 1 child
	- Delete `t` by replacing parent link with that 1 child (similar to `delete_min`)
- Case 2: `t` has 2 children
	- Find successor `x` of `t` (we could go right min or max left)
	- `x = find_min(t.right)`
	- `x.right = delete_min(t.right)`
	- `x.left = t.left`
	- Replace `t` with `x`

With Hibbard Deletion, average case takes $O(\sqrt{N})$. 

After many deletions and insertions,  BST height degrades to $O(N)$, so all other common operations degrade to $O(N^2)$.

An interesting problem that came during lectures: [[BST to Circular Doubly Linked List In-Place]]
#### Balanced Search Tree
##### 2-3 Search Tree
A 2-3 search tree is a tree where each node can be of two types:
- 2-node: one key `k`, two children 
	- same with BST
	- left child has keys strictly smaller than `k`
	- right child has keys strictly larger than `k`
- 3-node: two keys, `k1`, `k2`, three children
	- left child has keys strictly smaller than `k1`
	- right child has keys strictly larger than `k2`
	- middle child has keys between `k1` and `k2`
**Invariants**:
- Symmetric order: In-order traversal yields keys in ascending order
- Perfect balance. Every path from root to null link has the same length

`get` is implemented similar to BST keeping in mind the middle branch.

`put(key, value)` is where it gets interesting:
- Case 1: insert the new key in a 2-node
	- Transform the 2-node into a 3-node 
- Case 2: insert the new key in a 3-node
	- Add the new key to the 3-node, creating a temporary 4-node
	- Move the middle key of the 4-node into its parents and create two 2-node children
	- Repeat up the tree as necessary
	- If we reach the root and it's a 4-node, split it into 2-nodes. The mid value becomes a new node above and the height of the tree increases by 1.

*Evidently, the height only increases at the root, hence the perfect balance property.*

|                    Before                     |                    Step 1                     |                    Step 2                     |
| :-------------------------------------------: | :-------------------------------------------: | :-------------------------------------------: |
| ![[Screenshot 2024-04-30 at 12.04.49 PM.png]] | ![[Screenshot 2024-04-30 at 11.59.13 AM.png]] | ![[Screenshot 2024-04-30 at 11.59.20 AM.png]] |
*Example of inserting Z into a 2-3 tree*

**Complexity Analysis**
Even in the worst case, the height of the tree is $O(\log(N))$. Hence guaranteed logarithmic time for all common operations. Deletion is also $O(\log(N))$.

*2-3 search tree is tedious to implement in code, Red-Black BST is an easier and more elegant implementation of 2-3 search trees*.
##### Red-Black BST
Key idea: transform a 3-node in a 2-3 search tree into a **left-leaning** BST (two nodes connected by an *internal* red link).

| ![[Screenshot 2024-04-30 at 12.14.04 PM.png]] | ![[Screenshot 2024-04-30 at 12.14.16 PM.png]] |
| --------------------------------------------- | --------------------------------------------- |
**Properties of Left-Leaning Red-Black (LLRB) BST**:
- Every path from the root to leafs has the same number of **black** links
- No two consecutive red links (otherwise we'd have a 4-node)
- Red links lean left

*There exists a one-to-one correspondence between a 2-3 search tree and a LLRB BST*.

Key operations:
- `get` is the same as in BST 
- `put(key, value)` is where it's vastly different where after each insertion we have to make sure to balance the subtrees.
- Deletion, though not implemented here, can also be implemented in $O(\log(N))$

Implementation with notes found at [[Left-Leaning Red-Black BST]]

There's also **B-Trees** which are the same as 2-3 search trees but can have up to `B` keys in each node. The cost of accessing the disc is high, so storing as many keys within each node can significantly reduce this.
#### Hash Tables
Idea is to transform keys into indexes (hashing) of an array and then the lookup is constant time.
**Example of hashing a string**:
```python
def hash_str(s: str) -> int:
	hash = 0
	for c in s:
		hash = (R * hash + ord(c)) % M
	return hash
```
In practice collisions where two keys are mapped into the same index happen so different implementations resolve collisions in different ways. 
##### Separate Chaining 
Array of `M` `(<< N)` linked lists
1. Hash `<key>`: map key to integer `i` in `[0, M-1]`
2. Insert `<key, value>`: put value at the front of the `ith` chain (if not already there)
3. Search `<key>`: linearly scan the `ith` chain

**Performance**:
- `M` too large -> space waste (too many empty chains)
- `M` too small -> time waste (chains too long)
- `M ~ N/5` -> constant time search/insert on average.
##### Linear Probing
Two arrays of size `M > N` (one for keys, one for values)
- Hash `<key>`: map key to integer `i` in `[0, M-1]`
- Insert `<key, value>`: put value at index `i` if available, or else try `i+1`, `i+2`, and so on.
- Search `<key>`: access table index `i`; if occupied but no match, try `i+1`, `i+2`, and so one.

**Performance**
- `M` too large -> space waste (too many empty array entries)
- `M` too small -> search time blows up 
- `M ~ 2 * N` -> constant time search/insert on average.
##### Chaining vs Probing 
*Separate Chaining*
- Easier to implement 
- Performance degrades more gracefully 
- Less sensitive to poorly-designed hash function 
*Linear Probing (with dynamic array resizing)* 
- Less wasted space 
- Better performance on huge tables 
#### Summary of Symbol Tables 
![[Screenshot 2024-05-11 at 2.51.55 PM.png]]
## Graphs 
### Representation
- Adjacency matrix: a two dimensional matrix of boolean values representing if an edge exists between two nodes or not.
- Adjacency list: a list of lists where each element at index `i` represents a list of vertices accessible from `i`
**Adjacency list better in practice.**
### Depth First Search (DFS) 
```python
def dfs(adj_list, v, visited, edge_to):
	visited[v] = True
	for w in adj_list[v]:
		if not marked[w]:
			dfs(adj_list, w, visited, edge_to)
			edge_to[w] = v  
```

```python
def has_path_to(v, visited):
	return visited[v]
```

```python
def path_to(v, s, edge_to):
	if not has_path_to[v]: return None
	path = []
	x = v 
	while (x != s):
		path.append[x]
		x = self.edge_to[x]
	path.append[s]
	return path
```
### Breadth First Search (BFS)
*I could add the `edge_to` and `dist_to` part to this but it's trivial, and same with most other extra properties*
```python
def bfs(node, adjacent_nodes, visited):
    queue = deque()
    queue.append(node)
    visited[node] = True
    # dist_to[node] = 0
    while queue:
        node = queue.popleft()
        for next_node in adjacent_nodes[node]:
            if not visited[next_node]:
                visited[next_node] = True
                queue.append(next_node)
                # edge_to[w] = v
                # dist_to[w] = dist_to[v] + 1
```
Breadth first search **automatically** gets the **shortest path** between nodes when you keep track of the path using edge_to.
### Connected Components
```python
def dfs(adj_list, v, visited, cc, count):
	visited[v] = True 
	cc[v] = count
	for w in adj_list[v]:
		if not visited[w]:
			dfs(adj_list, w, visited, cc, count)	

def get_connected_components(adj_list):
	n = len(adj_list)
	count = 0
	visited = [False] * n
	cc = [-1] * n
	for v in range(n):
		if not visited[v]:
			dfs(adj_list, v, visited, cc, count)
			count += 1
	return cc
```
### Directed Acyclic Graph (DAG)
A directed graph containing no cycles.
One can check if a graph is a DAG or not as follows:
```python
def is_dag(adj_list):
	n = len(adj_list)
	active = [False] * n
	visited = [False] * n
	def dfs(v):
		visited[v] = True 
		active[v] = True
		for w in adj_list[v]:
			if active[w]: 
				return False
			if not visited[w] and not dfs(w):
				return False
			
		active[v] = False
		return True

	for v in range(n):
		if not visited[v] and not dfs(v):
			return False	

	return True	
```
### Topological Sort 
Challenge: given a directed acyclic graph (**DAG**), we want to redraw it so that all edges point upward. The **topological order** is then such that we follow from bottom up.
$$
\text{topological order} = \text{reverse post-order}
$$
```python
# gives post-order, but popping from stack gives topological order
def get_topological_order(adj_list):
    n = len(adj_list)
    visited = [False] * n
    order = []
    def dfs(v):
        visited[v] = True	
        for w in adj_list[v]:
            if not visited[w]:
                dfs(w)
        order.append(v)

    for v in range(n):
        if not visited[v]:
            dfs(v)
            
    return order
```
### Strongly Connected Component 
In Digraphs, two vertices, $w$ and $v$ and strongly connected if there is both a directed path from $v$ to $w$ and from $w$ to $v$.
Solved using **Kosaraju-Sharir** Algorithm as follows:
```python
# G is the adj_list, as usual
def get_strongly_connected_components(G):
	n = len(G)

	scc = [-1] * n
	count = 0
	visited = [False] * n
	def dfs(v):
		visited[v] = True
		scc[v] = count
		for w in G[v]:
			if not visited[w]:
				dfs(w)

	GR = reverse_graph(G) # reverses edges 
	# just run topological order on it, even though not a dag
	top_order = get_topological_order(GR)

	while top_order:
		v = top_order.pop()
		if not visited[v]:
			dfs(top_order.pop())
			count += 1
	
	return scc
```
### Minimum Spanning Tree (MST)
Given an undirected (and connected) graph $G$ with positive edge weights, a **spanning tree** of $G$ is a subgraph $T$ that:
- Is a **tree**: connected and acyclic
- **Spanning**: includes all the vertices.
 ![[Screenshot 2024-05-12 at 1.20.36 AM.png]]
#### Kruskal's Algorithm
Kruskal is an example of a **greedy algorithm**.
Definitions and Properties:
- A **cut** in a graph is a partition of its vertices into two disjoint (non-empty) sets 
- A **crossing edge** connects a vertex in one set with a vertex in the other
- Given any cut, the crossing bridge of **min weight** is in the MST 

Idea behind Kruskal:
- We get the edges in ascending order of weight 
- Add the next edge to the MST, unless doing so would create a cycle 
- Stop when all edges have been considered, or when `V-1`edges have been added
- Quick Weighted UnionFind can be used for efficient ($O(\log V))$ cycle detection for undirected graphs

*Kruskal takes advantage of the definitions above, since the min edge chosen won't have a cycle with the MST, and hence it is like 1 node vs all other nodes partition. The minimum crossing edge is the edge itself since it is the next min.*

```python
type Graph = list[tuple[int, int, float]]
type MST   = list[tuple[int, int]]
def mst_kruskal(graph: Graph) -> MST:
    n = len(graph)
    edges = sorted(graph, key=lambda x: x[2])

    uf = UnionFind(n)
    mst = []
    for u, v, _ in edges:
        # detect cycle
        if uf.find(u) == uf.find(v):
            continue
        
        uf.union(u, v)
        mst.append((u, v))

        if len(mst) == n - 1: # we assume a connected graph
            break
    return mst
```
**Performance**:
![[Screenshot 2024-05-12 at 2.13.13 AM.png]]
Actually building the priority queue can be done in $O(E)$ time using bottom-up heapify 😜
Doesn't matter though, the overall worst case time complexity of Kruskal will still be $O(E\log E)$.
### Prim's Algorithm 
Kind of a dual opposite of Kruskal. Also an example of a **greedy algorithm**.
Ideas:
- Start with vertex 0 and greedily grow Tree T
- Add to T the min-weighted edge with exactly one endpoint in T
- Stop when V-1 edges have been added 
```python
type Graph = list[tuple[int, float]]
type MST   = list[tuple[int, int]]

def mst_prim(adj_list: Graph) -> MST:
	n = len(adj_list)
    in_tree = [False] * n
    mst = []
    queue = PriorityQueue()
    # assume connected, so 0 will at least have one edge
    in_tree[0] = True
    for node, weight in adj_list[0]:
        queue.put((weight, (0, node)))
    # above could be done better with heapify but likely not worth it

    while not queue.empty() and len(mst) < n - 1:
        _, (a, b) = queue.get()
        if in_tree[a] and in_tree[b]:
            continue
        mst.append((a, b))
        in_tree[b] = True
        for node, weight in adj_list[b]:
            if not in_tree[node]:
                queue.put((weight, (b, node)))
    return mst
```
**Performance**:
![[Screenshot 2024-05-12 at 3.08.31 AM.png]]
Overall worst case time complexity $O(E\log E)$, same as Kruskal.
### Shortest Path of Directed Graph 
#### Dijkstra's Algorithm 
```python
type Graph       = list[list[tuple[int, float]]]
type DistancesTo = list[float]
type EdgesTo     = list[int]

def shortest_paths_dijkstra(source: int, adj_list: Graph) -> tuple[DistancesTo, EdgesTo]:
	n = len(adj_list)
    distances = [float('inf')] * n
    distances[source] = 0
    edge_to = [-1] * n
    
    pq = PriorityQueue() # min queue
    pq.put((0, source))  # (weighted_distance, node_to)
    while not pq.empty():
        distance, node = pq.get()
        if distance > distances[node]: # discard outdated entries
            continue
            
        for neighbor, weight in adj_list[node]:
		    # relaxing edge (node, neighbor)
            new_distance = distances[node] + weight
            if new_distance < distances[neighbor]:
                distances[neighbor] = new_distance
                edge_to[neighbor] = node
                pq.put((new_distance, neighbor))
                
    return distances, edge_to
```
**Performance**
![[Screenshot 2024-05-12 at 3.42.45 AM.png]]
Overall worst case time complexity $O(V + E \log V)$.
#### Edge-weighted DAG Algorithm 
Only works when graph is a DAG.
```python
type Graph       = list[list[tuple[int, float]]]
type DistancesTo = list[float]
type EdgesTo     = list[int]

def shortest_paths_dag(
        source: int,
        adj_list: Graph,
        n: int
    ) -> tuple[DistancesTo, EdgesTo] | None:
    if !is_dag(adj_list): 
	    return None 
    
    order = get_topological_order(adj_list)
    
    distances = [float('inf')] * n
    distances[source] = 0
    edge_to = [-1] * n
    while order:
	    node = order.pop()
        for neighbor, weight in adj_list[node]:
	        # relaxing edge (node, neighbor)
            new_distance = distances[node] + weight
            if new_distance < distances[neighbor]:
                distances[neighbor] = new_distance
                edge_to[neighbor] = node
    return distances, edge_to
```
Overall worst case time complexity $O(V + E)$ (same as topological sort as its the bottleneck of the algorithm)
### Bellman-Ford Algorithm 
```python
type Edge        = tuple[int, int, float]
type Graph       = list[Edge]
type DistancesTo = list[float]
type EdgesTo     = list[int]

def shortest_paths_bellman_ford(
        source: int,
        edge_list: ,
        n: int
    ) -> tuple[DistancesTo, EdgesTo] | None:
    distances = [float('inf')] * n
    distances[source] = 0
    edge_to = [-1] * n
    for _ in range(n - 1):
        for u, v, weight in edge_list:
	        # relaxing edge (node, neighbor)
            new_distance = distances[u] + weight
            if new_distance < distances[v]:
                distances[v] = new_distance
                edge_to[v] = u
                
    for u, v, weight in edge_list: # check for negative cycles
        if distances[u] + weight < distances[v]:
            return None
            
    return distances, edge_to
```
**Performance**:
- Worst case time complexity of $O(E \cdot V)$
- Not good, but practical improvements can make algorithm much faster
	- Like not relaxing any outgoing edge from an edge that has not changed in the previous pass 
	- Or early termination once a pass does not change anything from the previous pass 
- Still has worst case time complexity of $O(E \cdot V)$ even after improvements though
### Performance Comparisons
![[Screenshot 2024-05-12 at 4.10.31 AM.png]]
## Strings 
### String Sorting 
#### Key-Indexed Counting 
Assume keys are integers in `[0, R-1]`, where `R` is the radix (alphabet size).
- Example: Can be used for sorting surnames by first letter only.
- Implication: Because `R` is small, we can use key itself as an array index 
Algorithm Logic: 
- First pass: count the frequencies of each letter (frequency array offset by +1 for next step)
- Second pass: compute commutative frequencies `count[r+1] = count[r] + count[r+1]`
- Now count gives us how many letters smaller than `r` in the sorted array 
- Now we simply access this array to find position of where `r` should be 
```python
RADIX = 256
def sort_by_char(words: list[str], index: int = 0) -> list[str]:
    frequencies = [0] * (RADIX + 1) # +1 for the cumprod
    for word in words:
        c = word[index]
        frequencies[ord(c) + 1] += 1 

    # cumsum
    for i in range(1, RADIX + 1):
        frequencies[i] += frequencies[i - 1]
        
    result = [""] * len(words)
    for word in words:
        c = word[index]
        result[frequencies[ord(c)]] = word
        frequencies[ord(c)] += 1

    return result
```
**Analysis**:
- Time complexity $\Theta(N + R)$ 
- Space complexity $\Theta(N + R)$, hence not in place 
- **Stable**, maintains relative ordering 
#### LSD Radix Sort 
Assumption: All keys have the same (small) length `D`. 
Basic idea:
- Consider each character in turn, from right to left (least significant to most)
- At each pass, use key-indexed counting on the `dth` character to sort (stably)
```python
def lsd_radix_sort(strings: list[str]) -> list[str]:
    W = len(strings[0]) # assume all have length W
    for i in range(W - 1, -1, -1):
        strings = sort_by_char(strings, i)
    return strings
```
**Cost**:
- Time $\sim W \cdot (N + R) \rightarrow O(N)$ since $W$ and $R$ are assumed to be constant. 
- Space $\sim (N + R) \rightarrow O(N)$
#### MSD Radix Sort
Basic idea:
- Partition input into `R` pieces according to first character (using key-indexed counting to sort)
- Recursively sort all strings that start with the same character 
- *Note: key-indexed counts delineate sub-partitions to sort*
```python
RADIX = 256
def msd_radix_sort(strings: list[str]) -> list[str]:
    aux = [""] * len(strings)
    msd(strings, aux, 0, len(strings))
    return strings

def msd(strings, aux, low, high, index):
    if high - low <= 1: return
    
    frequencies = [0] * (RADIX + 2) # +1 for the cumsum, +1 for the sentinel
    for i in range(low, high):
        string = strings[i]
        if index < len(string):
            c = ord(string[index])
            frequencies[c + 2] += 1
        else:
            frequencies[1] += 1

    # cumsum
    for i in range(1, RADIX + 2):
        frequencies[i] += frequencies[i - 1]

    for i in range(low, high):
        string = strings[i]
        if index < len(string):
            c = ord(string[index])
            aux[frequencies[c + 1]] = string
            frequencies[c + 1] += 1
        else:
            aux[frequencies[0]] = string
            frequencies[0] += 1

    for i in range(low, high):
        strings[i] = aux[i - low]

    for i in range(RADIX):
        msd(strings, aux, frequencies[i], frequencies[i + 1], index + 1)
```
*Note, needed to essentially reimplement sort_by_char to make it in_place and account for out of bounds*
**Cost**:
- Time: Worst case: $\sim W \cdot N$. Average case: sublinear $\sim N \log_R N$
- Space: $\sim N + D \cdot R$. $D$ is depth of recursion (length of the longest prefix match)
==Revisit why $\sim N \log_R N$ is actually better than $\sim W \cdot N$ and why we call it sublinear?==
### String Searching 
#### R-way Tries 
Key idea: tree representation of symbol table
- Each node represents (i.e., stores) one character, not full keys 
- Each node has exactly R children, one for each possible character 
- Root node is only node with no character 
 Full implementation found at [[R-Way Trie]]
#### 3-way Tries 
Key idea: Same as R-way Tries, except: 
- Each node has exactly 3 children: smaller (left), equal (middle), larger (right)
Full implementation found at [[3-Way Trie]]
### Substring Search 
#### Brute Force Algorithm 
```python
def search_string_brute_force(text: str, pattern: str) -> int:
	n, m = len(text), len(pattern)
	for i in range(0, n - m + 1):
		j = 0
		while j < m and text[i + j] == pattern[j]:
			j += 1
		if j == m:
			return i
	return n
```
Worst case time complexity of `~N*M`
#### Knuth-Morris-Pratt Algorithm 
```python
RADIX = 256
def get_dfa(pattern: str) -> list[list[int]]:
    dfa = [[0] * len(pattern) for _ in range(RADIX)]
    dfa[ord(pattern[0])][0] = 1
    x = 0
    for j in range(1, len(pattern)):
        for c in range(RADIX):
            dfa[c][j] = dfa[c][x]
            
        dfa[ord(pattern[j])][j] = j + 1
        x = dfa[ord(pattern[j])][x]
        
    return dfa
    
def search_string_kmp(text: str, pattern: str) -> int:
	n, m = len(text), len(pattern)
	i, j = 0, 0
	dfa = get_dfa(pattern)
	while i < n and j < m:
		j = dfa[text[i]][j]
		i += 1
	if j == m:
		return i - m
	else:
		return n
```
**Cost** - Given a pattern of length `M`, a text of length `N` and an alphabet of radix `R`:
- Construction of `DFA[][]` `~R*M` (both space and time)
- Substring search `~M+N`
#### Boyer-Moore Algorithm 
```python
def search_string_bm(text: str, pattern: str) -> int:
    n, m = len(text), len(pattern)

    # precompute rightmost occurrence
    rightmost = [-1] * RADIX
    for k in range(m):
        rightmost[ord(pattern[k])] = k
        
    i, j = 0, m-1
    while i <= n - m:
        skip = 0
        j = m - 1
        while (j >= 0):
            if pattern[j] != text[i+j]:
                c = ord(text[i+j])
                skip = max(1, j - rightmost[c])
                break
            j -= 1
        i += skip
        if skip == 0:
            return i 

    return n
```
**Cost**:
- Preprocessing `~M`
- Substring matching:
	- Average case `~N/M`
	- Worst case `~M*N`
### Lossless Compression 
 Goal:
 - Message: Given an input binary data (bit-stream) B 
 - Compress: Generate a compressed representation C(B)
 - Expand: Reconstruct the original bitstream B without loss 

Compression ratio: bits in C(B) / bits in B, the smaller the better.
#### Run-length coding
Key idea: 
- Use counts to represent sequences of 0/1 bits 
- Representation: Use n-bit counts (e.g., n=8) to represent alternating runs of 0s and 1s.
```python
def compress():
	count = 0
	previous = False # assume starting with 0

	while not BinaryStdIn.is_empty():
		bit = BinaryStdIn.read_bool()
		if (bit == previous):
			count++
		else: # switch 
			BinaryStdOut.write(count, 8) # (n=8, byte)
			count = 0
			previous = not previous

	BinaryStdOut.write(count, 8) # write byte

def decompress():
	bit = False 
	while not BinaryStdIn.is_empty():
		count = BinaryStdIn.read(8) # read byte (n=8)
		for i in range(count):
			BinaryStdOut.write(bit)

		bit = not bit
``` 
Useful for black and white images, for example. Not very applicable in general though.
#### Huffman compression 
**Key idea:**
Instead of encoding every character in alphabet using the same number of bits, use fewer bits for characters that appear more often.

Key property: Huffman encodings generate prefix-free code, meaning no encoding is a prefix to another. This allows us to unambiguously represent variable length encodings for each character.

**Codeword Table**
Our prefix-free codes are represented as a **binary trie** 
- Chars in leaves (since no code is prefix to another)
- Codeword is bit sequence path from root to leaf (encode)
```python
class Node: 
	def __init__(self, ch, freq, left, right):
		self.ch    = ch 
		self.freq  = freq
		self.left  = left
		self.right = right

	def is_leaf(self):
		return self.left == None and self.right == None

	def compare_to(self, other_node):
		# positive if this freq is higher than other freq
		return self.freq - other_node.freq
```
 
```python
def decompress():
	root = read_trie()
	n = BinaryStdIn.read_int()

	for i in range(n):
		x = root 
		while not x.is_leaf():
			if not BinaryStdIn.read_bool():
				x = x.left
			else:
				x = x.right 
		BinaryStdOut.write(x.ch, 8)
```
**Cost**: `~N`

**Trie Construction**
```python
def build_trie():
	pq = new MinPQ()
	for i in range(R):
		if freq[i] > 0:
			new_node = Node(i, freq[i], None, None)
			pq.insert(new_node)
			
	while pq.size() > 1:
		x      = pq.del_min()
		y      = pq.del_min()
		parent = Node('', x.freq + y.freq, x, y) # merge 
		pq.insert(parent)

	return pq.del_min()
```

**Trie Transmission (writing & reading a trie)**
Writing (choice of how to encode it in binary):
- Pre-order traversal of the trie 
- For each internal node, emit 0
- For each leaf node, emit 1 followed by corresponding char 
```python
def write_trie(node):
	if node.is_leaf():
		BinaryStdOut.write(True)
		BinaryStdOut.write(node.ch, 8)
		return 
	
	BinaryStdOut.write(False)
	write_trie(node.left)
	write_trie(node.right)
```

Reading (called on `decompress()`):
- Reconstruct from pre-order traversal of the trie 
```python
def read_trie():
	if BinaryStdIn.read_bool():
		c = BinaryStdIn.read(8) # read byte 
		return Node(c, 0, None, None)

	x = read_trie()
	y = read_trie()
	return Node('', 0, x, y)
```

**Code Table**
We can build a lookup table once we have the trie for even faster compression 
```python
def code_table(root):
	table = [""] * R
	build_code_table(table, root, "")
	return table 

def build_code_table(table, node, bitstr):
	if node.is_leaf():
		table[node.ch] = bitstr 
		return 

	build_code_table(table, node.left,  bitstr + "0")
	build_code_table(table, node.right, bitstr + "1")
```

```python
def compress(text, table):
	for c in text:
		for cbit in table[c]: 
			BinaryStdOut.write(code[j] == "1")
```

**Cost**
`~N + R*log(R)`
