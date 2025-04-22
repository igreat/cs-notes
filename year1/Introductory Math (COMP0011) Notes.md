==THESE ARE **INCOMPLETE** NOTES OF SOME OF THE INTERESTING STUFF ONLY==
- I went through Exercise Sheets 7, 8 and 9 very quickly, might be worth a revisit.
## Complex Numbers
**In Complex Numbers**, when solving for roots of unity, I have to be careful with a sneaky second $k$ which could be what generates all the unique solutions. For example, doing the following won't work:
$$
\begin{align*}
z^n &= 1 \\
e^{i(\theta + 2 \pi k)n} &= e^{0} \\
i(\theta + 2 \pi k)n &= 0 \\
\theta &= -2 \pi k, k \in \mathbb{Z}
\end{align*}
$$
This only gets us one unique solution. There is a sneaky $2 \pi k_2$ here which should be on the RHS. So the equality should have been:
$$
\begin{align*}
z^n &= 1 \\
e^{i(\theta + 2 \pi k_1)n} &= e^{i(0 + 2 \pi k_2)} \\
\cdots &= \cdots
\end{align*}
$$
It's just that usually the first $2 \pi k_1$ doesn't get us any new solutions, but the RHS one matters (it's what we're solving for).
Moral of story, having a constant on only one side can be a subtle thing that I need to be careful of. For these problems though, just considering the **RHS** constant is sufficient. 
## Limits and Continuity
**Limit definition:**

|                        |                         $f(x) \rightarrow \infty$                         |                                      $f(x) \rightarrow b$                                       |
| :--------------------- | :-----------------------------------------------------------------------: | :---------------------------------------------------------------------------------------------: |
| $x \rightarrow \infty$ |          $\forall d > 0, \exists c > 0, x > c \implies f(x) > d$          |          $\forall \epsilon > 0, \exists c > 0, x > c \implies \|f(x) - b\| < \epsilon$          |
| $x \rightarrow a$      | $\forall d > 0, \exists \eta > 0, 0 < \|x - a\| < \eta \implies f(x) > d$ | $\forall \epsilon > 0, \exists \eta > 0, 0 < \|x - a\| < \eta \implies \|f(x) - b\| < \epsilon$ |

$x \rightarrow -\infty$ and $f(x) \rightarrow -\infty$ cases are similarly defined.

**Properties of limits:**
- $\lim_{x \to a}(f(x) + g(x)) = \lim_{x \to a}(f(x)) + \lim_{x \to a}(g(x))$
- $\lim_{x \to a}(f(x) - g(x)) = \lim_{x \to a}(f(x)) - \lim_{x \to a}(g(x))$
- $\lim_{x \to a}(f(x) \cdot g(x)) = \lim_{x \to a}(f(x)) \cdot \lim_{x \to a}(g(x))$
- $\lim_{x \to a}(\frac{f(x)}{g(x)}) = \frac{\lim_{x \to a}(f(x))}{\lim_{x \to a}(g(x))}$

**Little Oh and Big Oh:**
- $f = o(g)$ near value $b$ if $$\lim_{x \to b} \frac{f(x)}{g(x) }  = 0$$ "$f$ is **negligible** compared to $g$ when near $b$"
- $f = O(g)$ near value $b$ if $$\exists M \in \mathbb{R}, x_0 \in \mathbb{R}, \Big|\frac{f(x)}{g(x)}\Big| < M \text{ for all } x \text{ close enough to } x_0$$
 "$f$ and $g$ are **similar** near $b$"

**Continuity:**
A function $f$ is continuous if for all $a$ where $f(a)$ is defined, we have $$f(a) = \lim_{x \to a}{f(x)}$$
**Intermediate Value Theorem**
**Theorem**: Assume that $f$ is continuous on the closed interval $[a, b]$ and $a < b$ and $f(a) < f(b)$.
For any value $t$ such that $f(a) < t < f(b)$, there exists some $c \in (a, b)$ such that $f(c) = t$.
*Think about it like putting a pencil at $(a, f(a))$ and trying to reach $(b, f(b))$ without going backward or lifting the pencil. You'll have to cover all the interval $[f(a), f(b)]$ completely*
## Vector Spaces
Vector spaces are defined such that they are **closed** under **vector addition** and **scalar multiplication**.

**Linear Independence**:
Let $u_1, u_2, \cdots, u_n$ be vectors. They are **linearly independent** if there exists **no** scalars $a_1, a_2, \cdots, a_n$ (not **all** equal to $0$) such that: $$a_1 \cdot u_1 + \cdots + a_n \cdot u_n = \textbf{0}$$**Linear Mappings**:
Transformations which preserve the structure of the vector spaces:
For $K$-$\text{vector spaces}$ $V, W$, a mapping $f \to W$ is a linear mapping if: $$\forall u, v \in V, \forall a \in K, f(u + a * v) = f(u) + a*f(v)$$This is just a compact way of presenting the two conditions that: 
- $f(u + v) = f(u) + f(v)$ 
- $f(a*v) = a*f(v)$
Consequence of linearity $f(\textbf{0}) = \textbf{0}$. *(come back to prove this)*
Linear maps that map $V$ to $V$ are called **endomorphisms**.
## Sequences & Series
**Sequence Conversion Definition:**
We say that $l$ is the limit of the sequence $(u_n)$ if the $u_n$ become arbitrarily close to $l$ for $n$ large enough. 
$$
\forall \epsilon > 0, \exists N \in \mathbb{N}, n > N \implies |u_n - l| < \epsilon
$$
*Same as limit definition for function, except now the function argument is $n \in \mathbb{N}$*.

**Theorem of Monotone Convergence**
Let $(u_n)$ be a monotone sequence. Then it converges if and only if it is bounded.

**Squeeze Theorem**
Let $(u_n)$, $(v_n)$ and $w_n$ be sequences. If there exists $N$ such that: $$\forall n > N, u_n \leq v_n \leq w_n$$And if $\lim_{n \to \infty}{(u_n)} = \lim_{n \to \infty}{(w_n)} = l$, then we also have $\lim_{n \to \infty}{(v_n)} = l$.

**Series Convergence**
A series converges if its sequence of partial sums converges.
*Examples*:
- Geometric sequences converge to $u_0 \cdot \frac{1}{1-r}$ if $-1 < r < 1$.
- Harmonic sequence does **not** converge. 
- **Alternating** Harmonic sequence converges to $\ln(2)$.
A series $\sum{u_n}$ is absolutely convergent if $\sum{|u_n|}$ converges. Alternating Harmonic sequence is *not* absolutely convergent.
## Differential Calculus
- If $f$ is differentiable at $c$, then $f$ is continuous at $c$.
- Differentiability is stronger than continuity. Continuity "*comes for free*" when we define 

$$
f'(c) = \lim_{x \to c}{\frac{f(x) - f(c)}{x - c}}
$$ 
## Probabilities
**Probability Laws**
We measure likelihood of an event by using a probability law 
- $\Pr(A) \geq 0$
- $\Pr(\Omega) = 1$
- $\Pr(A \cup B) = \Pr(A) + \Pr(B)$ if $A$, $B$ are disjoint.

**Conditional Probability**
$$
\Pr(A|B) = \frac{\Pr(A \cap B)}{\Pr(B)}
$$
*Essentially the probability of both $A$ and $B$, normalized by $Pr(B)$. Renormalizing to $B$ being the new $\Omega$.*
Bayes' theorem follows directly from this: 
$$
\Pr(A|B) = \frac{\Pr(B|A)\Pr(A)}{\Pr(B)}
$$
**Law of Total Probability**
$$
\begin{align*}
\Pr(B) &= \Pr(B \cap A) + \Pr(B \cap \overline A) \\
\Pr(B) &= \Pr(A)\Pr(B|A) + \Pr(\overline A)\Pr(B|\overline A)
\end{align*}
$$
**Independent Events**
Two events are called independent if we have $$\Pr(A \cap B) = \Pr(A) \times \Pr(B)$$
Equivalently: $\Pr(A|B) = \Pr(A)$ and $\Pr(B|A) = \Pr(B)$.

**Random Variables**
We represent a random process as a *random variable* $X$:
$$
X: \Omega \mapsto [0, 1]
$$
*Although it is called "variable", it is technically a function (remark: this is similar to valuations $\rho$ in logic).*
Still fine to write $X=a$ to represent $X$ taking the value of $a$, and $\Pr(X=a)$ to get its corresponding probability.

*Bernoulli Random Variable*:
- Only two values $\{0, 1\}$ $$\Pr(X=1)=p,\,\,\, \Pr(X=0)=1 - p$$
- Example: coin toss, $p=0.5$ if fair.
- $E(X) = p$
- $\text{Var}(X) = p(1 - p)$

*Binomial Random Variable (with params $n, p$)*:
- Repeat a Bernoulli random variable $n$ times, count the number of $1$s. $$\Pr(X=k) = {n \choose k} p^k (1-p)^{n-k}$$
- ${n \choose k} = \frac{n!}{k!(n-k)!}$
- $E(X) = np$
- $\text{Var}(X) = np(1-p)$
- *Remark: $\text{Binomial}(n, p)$ is just a sum of $n$ independent $\text{Bernoulli}(p)$,*

*Variance* (how much values deviate from the mean, *squared*):
- $\text{Var}(X) = E((X - E(X))^2)$
- $\text{Var}(X) = E(X^2) - (E(X))^2$

*Normal Distribution*
Density function: 
$$
f(x) = \int_a^b{\frac{1}{\sigma \sqrt{2\pi}} e^{-\frac{1}{2}(\frac{x - \mu}{\sigma})^2}}
$$
*Standard Set of Cards*
- 52 total cards
- 13 cards for each of four suits: clubs (♣), diamonds (♦), hearts (♥) and spades (♠)
- Each suit contains 3 face cards (Joker, Queen and King) and 10 number cards.
- Card with number 1 is called Ace.
## Polynomials
Not functions, algebraic objects strictly speaking.
Remarks:
- $\deg(P + Q) \leq \max(\deg(P), \deg(Q))$ 
- $\deg(P \times Q) = \deg(P) + \deg(Q)$
- A polynomial is **irreducible** if it does not have *non-constant* factors.
	- $2X - 3$ is irreducible
	- $2X^3 - X^2 - 6X$ is not irreducible, as it can be factored into $X(X - 2)(2X + 3)$
	- Irreducible depends on what domain are we talking about 
		- Irreducible in $\mathbb{R}$?
		- Irreducible in $\mathbb{C}$?
## Integral Calculus
**Integration by Parts**
$$
\int_a^b{f'(x) \times g(x)}dx = [f(x) \times g(x)]_a^b - \int_a^b{f(x) \times g'(x)}dx
$$

Useful when integrating $f'(x)$ makes it simpler (*with some exceptions, like integrating $\ln(x)$*) and differentiating $g(x)$ doesn't make too complex.

**Integration by Change of Variable (u-substitution)**
$$
\int_a^b{f'(g(x)) \times g'(x)}dx = \int_{u(a)}^{u(b)}{f'(u)}du = [f(u)]_{u(a)}^{u(b)}
$$
where we let $u = g$ (substitution).

**Riemann Sum**
Area under a graph from $a$ to $b$ can be approximated with $n$ rectangles as follows:
$$
\sum_{k=0}^{n-1}{\frac{b-a}{n}f(a+k\frac{b-a}{n})}
$$
The more rectangles, the finer the approximation.
$$
\lim_{n \to \infty}\Big(\sum_{k=0}^{n-1}{\frac{b-a}{n}f(a+k\frac{b-a}{n})}\Big) = \int_a^b{f(x)}dx
$$
Here we have:
- $\frac{b-a}{n}$ is the equivalent of $dx$.
- $\sum$ is the equivalent of $\int$
- $a + k\frac{b - a}{n}$ is the equivalent of $x$

### Statistics
*Confidence Intervals*
The formula for the confidence interval is:
$$
\Big[m - z\Big(\frac{\sigma}{\sqrt{N}}\Big), m + z\Big(\frac{\sigma}{\sqrt{N}}\Big)\Big]
$$
where
- $m$ is the sample mean
- $\sigma$ is the sample standard deviation (also sometimes $s$ to differentiate it from population std)
- $N$ is the sample size
- $(\frac{\sigma}{\sqrt{N}})$ combined refers to the standard deviation of the **sampling distribution**. (central limit theorem stuff here) 
- $z$ is the critical value which depends on the confidence interval. 
	- Precisely, it refers to the number of standard deviations away from the mean I would be so as from $-z$ to $z$ I'd have an area under the normal PDF equal to the confidence level.
	- A 95% confidence level has a $z$-value of 1.96.
## Exercise Notes
### Exercise Sheet 1: Complex Numbers
In 1.2 and 1.3, my method was to start on both sides and show how they both get to the same value. I should follow the more conventional way of starting from one side and deriving the other side through a series of equivalences. 

In 1.4, the way to get the modulus is by doing $|z| = |x + iy| = \sqrt{x^2 + y^2}$. I didn't do this and caused myself confusion for no reason. Overall I got this one wrong too, because I assumed an increment of $\pi$ is fine. Here, for both $x$ and $y$ to be negative, the increment has to be across the whole unit circle: $2 \pi$.

In 3.1, possibly a better way was to make use one known factor, and match coefficients. I used quadratic formula which also worked.

**Remark: a general problem solving tool I should use is to treat $\theta = \arg(z)$ and $R = |z|$ separately to solve for each.**
### Exercise Sheet 2: Limits and Continuity 
In 3.2, I could have been more rigorous by mentioning that all conditions for the IVT are verified, and hence I can use it (like stating that $h$ is continuous at $(a, b)$ and so on).

In 4.6, I forgot to combine the two inequalities together to obtain a single $n$ that satisfies both. Or simply realize that one of the inequalities implies the other, so only consider one 😒

### Exercise Sheet 3: Vector Spaces
2.1: which asked: 
![[Screenshot 2024-04-22 at 2.08.03 PM.png]]
I answered with $U = \{[1, 0], [-1, 0], [0, 0]\}$ which (I think, check with others) holds. But a more interesting one like the one mentioned was $\mathbb{Z}$.

4.2: 
	Show that every linear map from a one-dimensional vector space to itself is multiplication by some scalar. More precisely, prove that if $\dim(V) = 1$ and $T$ is a linear map $V \mapsto V$, then there exists $a \in \mathbb{K}$. such that $T(v) = a*v$ for all $v \in V$.
I couldn't do this proof. The key idea here was to consider that $V = \text{span}(v_0)$ for some $v_0 \in V$, since $V$ is one-dimensional (so it only needs one vector to describe it). Then, we consider $T(v_0)$, which itself would be $a \cdot v_0$ for some scalar $a$. Then we choose arbitrary $v \in V$, and let $v = b \cdot v_0$ for some scalar $b$. Then: 
$$
\begin{align*}
T(v) &= T(b \cdot v_0) \\
	 &= b T(v_0) \text{ (linearity)} \\
	 &= ba \cdot v_0 \\
	 &= a (b\cdot v_0) \text{ (commutativity)} \\
	 &= a \cdot v \\
	 &\blacksquare
\end{align*}
$$
### Exercise Sheet 4: Matrices

I skipped 5.1, 5.2 and 5.3 because I remember them involving [Cayley–Hamilton theorem](https://en.wikipedia.org/wiki/Cayley%E2%80%93Hamilton_theorem), which I can't be arsed to remember. We did NOT do this in class (unless he expects us to solve this the painstakingly long way, which $100\%$ I will not be able to do with $0$ errors 🤪). ==Come back to this if have time.==

5.6 Interesting change of basis concept. Watch video to refresh my mind on this: [3B1B Change of Basis](https://www.youtube.com/watch?v=P2LTAUO1TdA&ab_channel=3Blue1Brown). 

### Exercise Sheet 5: Sequences and Series
1.1 Did I need to mention that the sequence is decreasing here (as in the answer sheet)?

### Exam Prep Questions
(3) Perhaps I should have explicitly checked if the result values are negative, since I technically solved for either both negative or both positive I think.

(6) I accidentally differentiated $\sin(x)$ to be $-\cos(x)$ 🤦🏽 (there shouldn't be a negative).

(11) doesn't really have to be a proof by contradiction. Perhaps a direct proof is a bit simpler.

