## Fundamental Concepts
### Functions 
**Total vs Partial**:
$$
f: X \to Y
$$
- $\text{domain}(f) = \{x \,|\, f(x) \text{ is defined}\} = X$
- $\text{image}(f) = \{y \,|\, \exists x. (x \in X) \land (y = f(x))\}$
- $\text{domain}(f) = X$, $\text{image}(f) = f(X)$

*A partial function is one in which: $\text{domain}(f) \subseteq X$ (undecidable problems, for example).*

**Injective (One-to-one) Functions**:
$f: X \to Y$ is an injection, or encoding $\iff$ for any $x_1$ and $x_2$ from $X$
$$
\begin{split}
(x_1 \neq x_2) &\implies (f(x_1) \neq f(x_2)) \\
\text{or} &\text{ } \text{equivalently} \\
(f(x_1) = f(x_2)) &\implies (x_1 = x_2) \\
\end{split}
$$
**Surjective (Onto) Functions:**
$f: X \to Y$ is a surjection $\iff$ $f(X) = Y$, i.e.
$$
\forall y \in Y. (\exists x \in X (f(x) = y))
$$
**Bijective Functions (One-to-one and Onto):**
$f: X \to Y$ is a bijection $\iff$ $f$ is injective **and** surjective.
The inverse bijection $f^{-1}$ does exist.
$$
\begin{align*}
f^{−1}&: Y \to X \\
f^{−1}(y) = x &\iff f(x) = y
\end{align*}
$$

*Injective, Surjective and Bijective functions are closed under function composition $h = f \circ g$.*

**Inverses**
Let $f: X \to Y$ and $g: Y \to X$ be functions:
- We say that $g$ is a **left inverse** to $f$, and that $f$ is a **right inverse** to $g$ if $g \circ f = \text{id}_X$
- We say that $f$ is **invertible** if there is a function $h: Y \to X$ such that $f \circ h = \text{id}_Y$ and $h \circ f = \text{id}_X$. $h$ here is called the **two-sided inverse** (or simply **inverse**).

Let $f: X \to Y$ be a function.
1. $f$ has a **left inverse** if and only if it is **injective**.
2. $f$ has a **right inverse** if and only if it is **surjective**.
3. $f$ is **invertible** if and only if it is a **bijection**.
### Cardinality of Sets
We say that
$$
|X| \leq |Y|
$$
if there exists an injective function/ encoding from $X$ into $Y$
$$
f: X \to Y
$$
*in other words, for any element in $X$, we can get a unique element in $Y$*

**Countable Sets**
A set is countable if it is finite or has a bijection with $\mathbb{N}$.
### Counting
**Cartesian Product**:
$$
A \times B = \{(x, y) \,|\, (x \in A) \land (y \in B)\}
$$
**The multiplication principle**:
Used to count the number of tuples $(a, b, c, \cdots)$ where $a, b, c, \cdots$ are selected from *independent* sources.
For any sets $A_1, A_2, \cdots, A_n$:
$$
|A_1 \times A_2 \times \cdots \times A_n| = |A_1| \cdot |A_2| \cdots |A_n|
$$
Examples: 
- Number of $(x, y)$ coordinates in a $15 \times 3$ grid is $15 \cdot 3 = 45$. 
- There are $2^3 = 8$ vertices in a cube. 
- The number of Boolean $n$-tuple is $2^n$.

**The addition principle**:
For any sets $A$ and $B$:
$$
|A \cup B| = |A| + |B| - |A \cap B|
$$
The $-|A \cap B|$ is to remove the double counting in case it's there.
### Bijective Maps and Permutations
**Two-row tuple form:**
$$
\begin{pmatrix}
1 & 2 & 3 & \cdots & n \\
\sigma(1) & \sigma(2) & \sigma(3) & \cdots & \sigma(n)
\end{pmatrix}
$$
*Not to be confused with disjoint cyclic notation, which I was confused about before. For example this is cyclic notation (one row, not two): $\sigma = (1\,3\,4\,5)\,(2)$, which means 1 goes to 3, 3 goes to 4, 4 goes to 5, and 5 goes to 1. 2 goes to 2*
$S_n$ is the set of all possible permutations of $n$ distinct elements, and $|S_n| = n!$.

**Order of permutation**
The **order** of a permutation $\sigma$ is the smallest positive integer $k$ such that 
$$
\begin{align*}
\sigma^k = \varepsilon \\
\text{order}(\sigma) = k
\end{align*}
$$
where $\varepsilon$ is the identity permutation.
When in disjoint cyclic form, $\text{order}(\sigma)$ is just equal the $\text{LCM}$ of the length all the cycles.

**Sign of permutation**
The **sign** of a permutation $\sigma$ is defined as:
$$
\text{sgn}(\sigma) =  \left\{
\begin{array}{ll}
      +1, & l \text{ is even} \\
      -1, & l \text{ is odd} \\
\end{array} 
\right.
$$
where $l$ is the number of “disorders” - that is the number of pairs $(x, y)$ such that $x < y$, but $\sigma(x) > \sigma(y)$. When we rewrite $\sigma$ as a product of transpositions (2-element cycles), parity of a permutation is also defined as whether the number of transpositions is even or odd.

The easiest way to get the sign of a permutation is to convert it to a product of $\sigma$ to a product of transpositions.
$$
\sigma = (1\,3\,4\,5) = (1\,3)\,(1\,4)\,(1\,5)
$$
As a rule of thumb, number of transpositions of a disjoint cycle is one less than the length of the cycle. And if the permutation is composed of multiple cycles, we can use the identity:
$$
\text{sgn}(\sigma_1\sigma_2) = \text{sgn}(\sigma_1)\text{sgn}(\sigma_2)
$$
to compute the overall sign.

*One can also get the sign by counting the number of crossings when drawing the individual lines (without any backward movement) from each element to its result, both put in order. If even number of crossings, $l$ is even, otherwise it is odd*.
### Equivalence Relations
**Definition of Equivalence Relation**
A binary relation $E(x, y)$ is an equivalence relation if and only if it satisfies the following properties:
- **Reflexivity**: $\forall x. E(x, x)$
- **Symmetry**: $\forall x, y. (E(x, y) \rightarrow E(y, x))$
- **Transitivity**: $\forall x, y, z. ((E(x, y) \land E(y, z)) \rightarrow E(x, z))$
*Exactly how an equivalence frame is defined in modal logic!*

**Set Partitioning**
Let $E_2(x, y) = x - y \text{ is even}$.
Then, this equivalence relation can get us a partition of $\mathbb{Z}$ as follows:
$[k]_2 = \{y \,|\, E_2(k, y)\}$
Partition $[0]_2 = \{0, 2, -2, 4, -4, \cdots, 2n, -2n, \cdots\}$
Another partition $[1]_2 = \{1, 3, -1, -3, \cdots, 2n+1, \cdots\}$

We notice that any other $k$ produces either of those two partitions.
Also notice that the union $[0]_2 \cup [1]_2 = \mathbb{Z}$
Thus $\mathbb{Z} / E_2 = \{\text{EVEN}, \text{ODD}\}$.
In other words, the equivalence relation $E_2$ partitions $\mathbb{Z}$ into the set of even integers and set of odd integers.
*$/$ here is set quotient, not set difference which would be $\setminus$.*
$\newcommand{\Mod}[1]{\ (\mathrm{mod}\ #1)}$
### Modular Arithmetic 
Example of equivalence relation is $x$ "congruent with" $y$ modulo $m$.
$$
x \equiv y \Mod m
$$
All these statements are referring to the same concept:
$$
\begin{align*}
E_m(x, y) &= (x − y) \text{ is divisible by } m \\
E_m(x, y) &= (y = x + qm) \text{ for some integer } q \\
a \Mod m &= [a]_m = \{y \,|\, (y − a) \text{ is divisible by } m\} \\
[a]_m &= \{y \,|\, y = a + qm, \text{ for some integer } q\}
\end{align*}
$$

Set of remainders $G_m$ for $m$:
$$
G_m = \{0, 1, 2, . . . , m−2, m−1\}
$$
*The $x \equiv y \Mod m$ equivalence relation can partition $\mathbb{Z}$ into $m$ distinct partitions.*

**Properties of modulo arithmetic**:
If $a_1 \equiv a_2 \Mod m$ and $b_1 \equiv b_2 \Mod m$, then:
$$
\begin{split}
a_1 + b_1 \equiv a_2 + b_2 \Mod m \\
a_1 \cdot b_2 \equiv a_2 \cdot b_2 \Mod m
\end{split}
$$
### Groups
A non empty set $G$ together with a binary operation $\circ: G \times G \to G$:
$$
(G, \circ)
$$
is a group if and only if:
1. **Closure**: $\forall x, y. ((x \in G) \land (y \in G) \rightarrow (x \circ y \in G))$
2. **Associativity**: For any $x, y, z \in G$, $(x \circ y) \circ z = x \circ (y \circ z)$
3. **Neutral**: For some unique $\varepsilon \in G$, $\exists x \in G. (x \circ \varepsilon = \varepsilon \circ x = x)$
4. **Invertibility**: $\forall x \in G. (\exists y \in G (x \circ y = y \circ x = \varepsilon))$

*Remark: commutativity is not required, as for example, **invertible** matrices and matrix multiplication form a group even though matrix multiplication is not commutative*

Examples of groups:
- $(G_m, + \Mod m)$: additive group
- $(\mathbb{R}^+, \times)$: multiplicative group
- $(G, \circ)$ where $G$ is the set of permutations and $\circ$ is permutation composition
### Subgroups
**Definition**:
Let $(G, \circ)$ be a group. A subset $H \subseteq G$ is a **subgroup** of $G$ if and only if:
1. **Closure**: $\forall x, y. ((x \in H) \land (y \in H) \rightarrow (x \circ y \in H))$
2. **Neutral**: $\varepsilon \in H$
3. **Invertibility**: $\forall x \in H (x^{-1} \in H)$

Basically iff $(H, \circ)$ itself is a group as well.

*Example: Rational numbers are a subgroup of real numbers under multiplication and addition. "Even Integers" are a subgroup of integers under addition, but not Odd Integers.*

**Cyclic Subgroups**
A group $H$ is cyclic if it can be generated by a single element $a$.
The **cyclic subgroup** generated by element $a$ is defined as:
$$
\{a^k \,|\, k \in \mathbb{Z}\} = \{\cdots, a^{-2}, a^{-1}, \varepsilon, a, a^2, a^{3}, \cdots \}
$$
Example:
Let $G_{7}^*$ be a set over **positive** remainders of integers when divided by $7$. 
$$
G_{7}^* = \{1, 2, 3, 4, 5, 6\}
$$
A cyclic subgroup of $G_{7}^*$ would be:
$$
\begin{split}
\text{starting from } a = 2,\,&\{1, 2, 4\} \\
\text{starting from } a = 3,\,&\{1, 2, 3, 4, 5, 6\} = G_7^*
\end{split}
$$
**Lagranges Theorem**:
Let $(G, *)$ be a finite group of order (size) $n$:
$$
G = \{g_1, g_2, g_3, \cdots, g_n\}
$$
and $(H, *)$ be its subgroup of order $k$:
$$
H = \{h_1, h_2, \cdots, h_k\}
$$
Then $k$ **divides** $n$. Namely, for some natural number $l$, $G$ can be partitioned into $l$ **disjoint** subsets of the same size $k$, so that $|G| = |H| \cdot l$ or $n=kl$. 
$$
G =  \left\{
\begin{array}{ll} 
	g_{i_1}H \\
	g_{i_2}H \\
	\vdots \\
	g_{i_l}H
\end{array} 
\right.
$$

*Example*:
Consider finite multiplicative group $(G, *)$ of order $4$:
$$
G = \{1, 3, 7, 9\}
$$
And $H$ which is a subgroup of $G$: 
$$
H = \{1, 9\}
$$

| $* \Mod {10}$ |   Result    |
| :-----------: | :---------: |
| $1 \times H$  | $1$     $9$ |
| $3 \times H$  | $3$     $7$ |
| $7 \times H$  | $7$     $3$ |
| $9 \times H$  | $9$     $1$ |

$$
G =  \left\{
\begin{array}{ll} 
	1*H = \{1, 9\}\\
	3*H = \{3, 7\}\\
\end{array} 
\right.
$$
Notice how $|H| = 2$ and $n = kl$, $4 = 2 \cdot 2$.

### Finite Groups
The order of an element $a$ in a group is the smallest positive integer $k$ such that
$$
a^k = \varepsilon
$$
*similar to definition of order of a permutations*

Given a finite group $G$ of order $n$, for any $a$ from $G$, such a $k$ does exists, and this $k$ divides $n = |G|$. In particular, for any $a$ from $G$,
$$
a^{|G|} = 1
$$
This basically says that if a group is finite, then starting from any element we will end up back at the identity after $n$ applications. The fact that $k$ divides $n$ comes directly from Lagrange's Theorem (explored more in proof of Euler's Theorem).
### Euler's Totient Function
The integers coprime to $m$ form a **multiplicative group of integers modulo $m$.**
$$
G_m^{\times} = \{a \,|\, (1 \leq a < m) \land (gcd(a, m) = 1)\}
$$
**Euler's Totient Function**
Defined as:
$$
\varphi(m) = |G_m^{\times}|
$$

**Euler's Theorem**
If $a$ is coprime to $m$, then it is part of $|G_m^{\times}|$ and we have that $a^k = 1 \Mod m$ where $k$ is the size of the subgroup we get generated by $a$ (cyclic subgroup). By Lagrange's Theorem, we have that $k$ divides $|G_m^{\times}| = \varphi(m)$. Thus, $\varphi(m) = kM$ for some integer $M$. 
$$
\begin{align*}
a^k &\equiv 1 \Mod m \\
(a^k)^M &\equiv 1^M \Mod m\\
a^{kM} &\equiv 1 \Mod m \\
a^{\varphi(m)} &\equiv 1 \Mod m \\
\end{align*}
$$
And we arrived at **Euler's Theorem**. To put it separately:
$$
a^{\varphi(m)} \equiv 1 \Mod m
$$
where $a$ and $m$ are coprime
Useful for solving something like $2^{100} \Mod {17}$ 
Since 2 and 17 are coprime:
$$
\begin{align*}
2^{\varphi(17)} &\equiv 1 \Mod {17} \\
2^{16} &\equiv 1 \\
2^{100} \equiv 2^{6 \cdot16} \cdot 2^{4} &\equiv 1 \cdot 16 \equiv 16 \Mod {17}
\end{align*}
$$
*Useful identities involving $\varphi(m)$:*
- If $m$ is prime, then $\varphi(m) = m-1$
- If $n_1$ and $n_2$ are coprime, then $\varphi(n_1 \cdot n_2) = \varphi(n_1) \cdot \varphi(n_2)$
- Thus, if $m = pq$ for primes $p$ and $q$, then $\varphi(m) = \varphi(pq) = \varphi(p) \cdot \varphi(q) = (p - 1)(q - 1)$.
- **Generalization**:
	- $m = \varphi(p_1^{k_1} \cdots p_n^{k_n}) = \varphi(p_1^{k_1}) \cdots \varphi(p_n^{k_n}) = p_1^{k_1 - 1} (p_1 - 1) \cdots p_n^{k_n - 1} (p_n - 1)$ where $p_1 \cdots p_n$ are prime numbers.
### Euclid's Algorithm
Greatest Common Divisor:
```rust
fn gcd(a, b)
    while b ≠ 0
        a, b := b, a mod b
    return a
```
**Properties**:
- $\gcd(k \cdot a, k \cdot b) = k \cdot \gcd(a, b)$
**Example:**
Compute $\gcd(34, 13)$:
$$
\begin{align*}
a \text{ mod } b &= a - k(b) \\
8 &= 34 - 2(13) \\
5 &= 13 - 1(8) \\
3 &= 8 - 1(5) \\
2 &= 5 - 1(3) \\
1 &= 3 - 1(2) \\
0 &= 2 - 2(1) \text{ (terminate here)}
\end{align*}
$$
Thus, $\gcd(34, 13) = 1$.
We can use this to get integers $k_1$ and $k_2$ such that:
$$
1 = k_{1}32 + k_{2}13
$$
$$
\begin{align*}
1 &= 3 - 1(2) \\
1 &= 3 - 1(5 - 1(3)) \\
1 &= 3 - 1(5) + 1(3) \\
1 &= -1(5) + 2(3) \\
1 &= -1(5) + 2(8 - 1(5)) \\
1 &= -1(5) + 2(8) - 2(5) \\
1 &= 2(8) - 3(5) \\
1 &= 2(8) - 3(13 - 1(8)) \\
1 &= 2(8) - 3(13) + 3(8) \\
1 &= -3(13) + 5(8) \\
1 &= -3(13) + 5(34 - 2(13)) \\
1 &= -3(13) + 5(34) - 10(13) \\
1 &= 5(34) - 13(13) \\
\end{align*}
$$
Thus $k_1 = 5$ and $k_2 = -13$. 

This result can also in turn be used to solve for:
$$
13 \cdot y \equiv 1 \Mod {34}
$$
Since we have:
$$
\begin{align*}
-13(13) &\equiv 1 - 5(34) \\
-13(13) &\equiv 1 \Mod {34}
\end{align*}
$$
Simplifying, we have $21 = -13 \Mod {34}$. Thus, $y = 21$. 
### Inverse of Modular Power
Solving for $x$ in $x^a = b \Mod m$ requires a combination of the techniques used in Euclid's algorithm and Euler's Theorem.
First, we can write $x$ as 
$$
\begin{align*}
x &\equiv b^y \Mod m \\
x^a &\equiv (b^y)^a \Mod m \\
x^a &\equiv b^{ya} \Mod m \\
\end{align*}
$$
But we're stuck here. It would be very helpful if $ya$ can be expressed as:
$$
y \cdot a =1+k\varphi(m)
$$
because then we would have:
$$
\begin{align*}
x^a &\equiv b^{ya} \Mod m \\ 
x^a &\equiv b^{1 + k\varphi(m)} \Mod m \\ 
x^a &\equiv b \cdot b^{k\varphi(m)} \Mod m \\ 
x^a &\equiv b \cdot 1 \Mod m \text{ (Euler's Theorem)} \\
x^a &\equiv b &\blacksquare 
\end{align*}
$$

So all we need is for a $y$ such that $y \cdot a =1+k\varphi(m)$. This can be simplified to the following problem we already know how to solve using Extended Euclidean algorithm:
$$
y \cdot a \equiv 1 \Mod {\varphi(m)}
$$
And then we just use that $y$ to compute $x \equiv b^y \Mod m$.
### Modular Arithmetic Problem Solving Techniques
As a summary:
- $a \cdot x \equiv b \Mod m$: solved using Extended Euclid's Algorithm
- $a^k \Mod m$: solved using Euler's Theorem
- $x^a \equiv b \Mod m$: solved by inverse of modular power

*The solvability of these problems depends on whether I can actually apply the theorems. For example I can't solve $a \cdot x \equiv b \Mod m$ with Extended Euclid $gcd(a, m)$ doesn't divide $b$, or $a^k \equiv b \Mod m$ with Euler's Theorem if $a$ and $m$ are not coprime.*
### Public-key Cryptography (RSA)
RSA makes use of inverse modular power:
$$
\text{encrypt}(m) \coloneqq m^e \Mod n
$$
- Message $m$ is encrypted by exponentiating it with $e$ modulo $n$. 
- $n$ is chosen such that $n = pq$ for two very large prime numbers $p$ and $q$. 
- $e$ is chosen such that $d \cdot e \equiv 1 \Mod {\varphi(pq)}$, which means anybody who has $d$ can simply decrypt $c$ as follows: 

$$
\text{decrypt}(c) \coloneqq c^d \Mod n
$$
- This follows directly from the technique for solving inverse of modular power.

Now, one can send a public key $(n, e)$, anybody can easily encrypt a message $m$, but only the person who has the private key $d$ can decrypt the message efficiently (in polynomial time).
## Linear Algebra
$A \cdot x = b$, where $A$ is a matrix and $x, b$ are vectors, can be solved with Cramer's rule:

$$
x_i = \frac{\det(A_i)}{\det{(A)}}, \,\,\, i = 1, \cdots, n
$$
Where $A_i$ is the matrix formed by replacing the $i$-th column with the vector $b$.

This has exponential time complexity. A better way to solve equations is using [Gaussian Elimination](https://en.wikipedia.org/wiki/Gaussian_elimination).

For any square matrix $A$,
$$
f(x) = Ax \text{ is bijective iff } \det(A) \neq 0
$$
### Determinant
Leibniz formula:
$$
\det(A) = \sum_{\sigma \in S_n} \Big(\text{sgn}(\sigma) \prod_{i=1}^n {a_{i, \sigma_i}} \Big)
$$
Also recursive definition probably found in [[Introductory Math (COMP0011) Notes]] (I lied)

$$
A \text{ is invertible} \iff \det(A) \neq 0
$$

**Properties of determinant (assuming $A$ and $B$ are invertible)** :
- $\det(A^{-1}) = \frac{1}{\det{A}}$
- $\det(A^{\top}) = \det(A)$
- $\det(aA) = a^n \det(A)$ for $n \times n$ matrix $A$ and scalar $a$
- $\det(A \cdot B) = \det(A) \cdot \det(B)$

If we have a triangular matrix $A$ of the form:
$$
\begin{bmatrix}
\lambda_1 & * & \cdots & * & * \\ 
0 & \lambda_2 & \cdots & * & * \\
0 & 0 & \lambda_3 & \cdots & * \\
0 & 0 & \cdots &\cdots & *     \\
0 & 0 & \cdots & 0 & \lambda_n \\
\end{bmatrix}
$$
$$
\det(A) = \lambda_1\lambda_2\lambda_3\cdots\lambda_n
$$
Intuitively, a triangular matrix represents a transformation that will be a $\text{shear} \circ \text{scale}$. Shearing does not scale the volume of the unit square (or cube, or hyper cube) representing the basis, so only scaling comes from the scaling coefficients found in the diagonal. 
$\require{amsmath}$
$\det$ can be computed alongside Gaussian Elimination if we keep track of manipulations that change the $\det$ (and essentially invert each change so that $\det$ remains same).
$$
\det(A) = \left\{
\begin{array}{ll} 
	\det(A'), & \text{if } A \xrightarrow{R_2' = R_2 + \gamma R_1} A'\\
	-\det(A'), & \text{if } A \xrightarrow{\text{swap } R_1 R_2} A' \\
	\gamma \cdot \det(A'), & \text{if } A \xrightarrow{R_2 =  \frac{1}{\gamma}R_2} A' \\
\end{array} 
\right.
$$
Where $R_1$ and $R_2$ are the rows being manipulated, and $A'$ is the matrix after being manipulated. Once we reach triangular form, $\det(A')$ can be computed by product of diagonal as shown.
### Eigen Stuff
A real number $\lambda$ is an **eigenvalue** of $A$ and a non-zero vector $v$ is an **eigenvector** of $A$ associated with the $\lambda$, if
$$
\begin{align*}
&Av = \lambda v, & v \neq 0
\end{align*}
$$
$$
Av - \lambda v = (A - \lambda E) \cdot v = 0 \iff \det(A - \lambda E) = 0
$$
$E$ represents the identity $I$.

**Properties**:
- If $A$ is symmetric, we can guarantee that $v^{\lambda_1}$ and $v^{\lambda_2}$ are orthogonal:
$$
A \text{ is symmetric } \iff A = A^{\top}\\
$$
$$
v^{\lambda_1} \cdot v^{\lambda_2} = 0 \iff v^{\lambda_1} \text{ and } v^{\lambda_2} \text{ are orthogonal}
$$
