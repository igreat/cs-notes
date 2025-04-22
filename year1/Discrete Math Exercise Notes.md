Revisit problem
[[Crazy Set Theory Proof]]

==General Notes:==
- DON'T forget to say whether $f$ is bijective after proving whether it is injective or not and surjective or not. I forgot to do that in the 2022 exam.
### Main Exam 2018
Question 2 had a ton of new stuff. Check new section under **Functions** in [[Discrete Math Notes]].

Question 4b, operations on equivalence classes was not what I thought it was. Here $[5] + [7] = [5 + 7 \Mod 9] = [12 \Mod 9] = [3]$, not what I thought which was interpreting the $+$ as an $\lor$. In general, it will be an element-wise operation but I'm not sure if it's always well defined.

Question 4d had an interesting proof for 
$$
(\gcd(a, b))^2 \text{ divides } \gcd(a^2, b^2)
$$
Here was my attempt:
$$
\begin{align*}
a = k_1 \cdot \gcd(a, b) \iff a^2 = k_1^2 \cdot \gcd(a, b)^2 \\
b = k_2 \cdot \gcd(a, b) \iff b^2 = k_2^2 \cdot \gcd(a, b)^2 \\
\end{align*}
$$
Hence we have that $\gcd(a, b)^2$ divides both $a^2$ and $b^2$. 
$$
\gcd(a^2,b^2)=\gcd(k_1^2​ \cdot \gcd(a,b)^2,k_2^2​\cdot \gcd(a,b)^2)
$$
From properties of $\gcd$, we can factor out the $\gcd(a, b)^2$
$$
\gcd(a^2,b^2)= \gcd(a,b)^2 \cdot \gcd(k_1^2​,k_2^2​)
$$
Since there exists $k = \gcd(k_1^2, k_2^2)$ such that $\gcd(a^2, b^2) = k \cdot \gcd(a, b)^2$, then $\gcd(a, b)^2 \text{ divides } \gcd(a^2, b^2)$.

Actually here we could have gone further and made use of the fact that $k_1$ and $k_2$ must be coprime, and thus $\gcd(k_1^2​,k_2^2​) = 1$, to show that in fact $\gcd(a^2,b^2) = \gcd(a,b)^2$.

Question 7b.ii, when finding the second eigenvector I forgot I could use the first equation to determine that $x=0$.

### Main Exam 2017
Question 1. My solution:
$$
\text{Prove that } (A \cup B) \setminus (B \setminus A) = A
$$
$$
\begin{align*}
& (A \cup B) \setminus (B \setminus A) \\
&= (A \cup B) \cap (B \setminus A)^C \\
&= (A \cup B) \cap (B \cap A^C)^C \\
&= (A \cup B) \cap (B^C \cup A) \text{ (De Morgan)} \\
&= (A \cup B) \cap (A \cup B^C) \\
&= A \cup (B \cap B^C) \text{ (Distributive Law)} \\
&= A \cup (\emptyset) \\
&= A
&\blacksquare
\end{align*}
$$

Question 2.
![[Screenshot 2024-05-01 at 9.41.25 PM.png]]

Assume $\bigcap_{n \in N} B_n$ is non empty.
Then, $x = \frac{1}{i} \in (0, \frac{1}{i}]$ for some $i \in \mathbb{N}$. But then I can find $j = i + 1 \in \mathbb{N}$, which gives:
$$
x \not \in \Big(0, \frac{1}{j}\Big] = \Big(0, \frac{1}{i+1}\Big] \text{ since } \frac{1}{i+1} < \frac{1}{i}
$$
Hence a contradiction. $\bigcap_{n \in N} B_n$ must be empty.

### Problem Class 1
Problem 4: A fairly difficult proof (generalization of De Morgan's Laws):
$$
\Big(\bigcap_{i \in I} A_i\Big)^C = \bigcup_{i \in I} A_i^C
$$
Here is the proof for the first direction: We assume $x \in \Big(\bigcap_{i \in I} A_i\Big)^C$, and are required to prove that $x$ is also in $\bigcup_{i \in I} A_i^C$.
$$
\begin{align*}
x &\in \Big(\bigcap_{i \in I} A_i\Big)^C \\
x &\not \in \Big(\bigcap_{i \in I} A_i\Big) \\
x &\not \in (A_{i_1} \cap A_{i_2} \cap \cdots \cap A_{i_n} \cap \cdots) \\
\end{align*}
$$
For this to be true, there must $\exists i \in I, x \not \in A_i$, which means $x \in A_i^C$, and hence $x \in \bigcup_{i \in I} A_i^C$. The converse can (and must) be proven similarly.

Problem 6b: I suspected this but proving the equality requires doing something similar to proving a limit in Intro Math. 
$$
T_n = \Big[\frac{1}{n}, 1\Big] \text{ for any } n \in \mathbb{N}
$$
We have to prove that:
$$
\bigcup_{n \in \mathbb{N}} T_n = (0, 1]
$$
When we try to prove that if $x \in (0, 1]$ then $x \in \bigcup_{n \in \mathbb{N}} T_n$, we need to show that for any value $x$ we can find an $n$ that satisfies $x \in [\frac{1}{n}, 1]$. This one turned out to be $n \geq \frac{1}{x}$. This is very similar to proving that a limit exists using the limit definition.
### Problem Class 6
In 1, we check if a linear map $T$ is injective by making sure that 
$$
\text{Ker}(T) = \{\textbf{0}\}
$$
In other words, $T\textbf{x} = \textbf{0}$ has only one solution, and that is the $\textbf{0}$ vector itself.
Be weary of wrong answer sheet for Q3.

### Problem Class 7 & 8
Interesting problem: solve for $\det(B^{-1})$
$$
-4A^{\top} = A \cdot B^2
$$
where $A$ and $B$ are $4 \times 4$ matrices.
Solving this requires these properties of determinant:
- $\det(A^{-1}) = \frac{1}{\det{A}}$ assuming invertible $A$.
- $\det(A^{\top}) = \det(A)$
- $\det(aA) = a^n \det(A)$ for $n \times n$ matrix $A$ and scalar $a$
- $\det(A \cdot B) = \det(A) \cdot \det(B)$
Using these properties one can easily arrive at $\det(B^{-1}) = ± \frac{1}{16}$

