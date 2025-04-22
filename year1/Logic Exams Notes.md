### Exam 2019
Proof of 1.e
$$M \models \square \square A \rightarrow \square A \iff \text{M is dense}$$
First we rewrite $M \models \square \square A \rightarrow \square A$.
$$
\begin{split}
	&= \square \square A \rightarrow \square A \\
	&= \lnot \Diamond \lnot \square A \rightarrow \lnot \Diamond \lnot A \\
	&= \lnot \Diamond \lnot \lnot \Diamond \lnot A \rightarrow \lnot \Diamond \lnot A \\
	&= \lnot \Diamond \Diamond \lnot A \rightarrow \lnot \Diamond \lnot A \\ 
	&= \Diamond \lnot A \rightarrow \Diamond \Diamond \lnot A \text{ (contrapositive)}
\end{split}
$$
We may resubstitute $B=\lnot A$, and without loss of generality, drop the $\lnot$ to get $$\Diamond A \rightarrow \Diamond \Diamond A$$Now, let $M = (W, R)$ be a dense frame (hence $Rxz \text{ implies } \exists y. Ryz \land Rxz$).
We choose an arbitrary $w \in W$ and valuation $\rho$. 
Assume $M, w \models_p \Diamond A$. $\text{RTP}: M, w \models_p \Diamond \Diamond A$. Since $M, w \models_p \Diamond A$, then there exists $Rww''$ such that $w'' \in W$ and $M, w'' \models A$. Since $M$ is dense, if $Rww''$, then there exists $w' \in W$ such that $Rww' \land Rw'w''$. Thus, $M, w' \models_p \Diamond A$ since $Rw'w''$. Hence $M, w \models_p \Diamond \Diamond A$ since $Rww'$. 

We now prove the converse. If $M$ is not dense we show that $M, w \not \models_p \Diamond A \rightarrow \Diamond \Diamond A$. 
Assume $M$ is not dense. Let $M = (W, R)$. We choose arbitrary $w \in W$ and let $\rho(A) = \{ w' \}$ and $Rww'$ such that there is no two step path that goes from $w$ to $w'$ (satisfying $M$ not dense property).
Hence, since $A$ is true only in $w'$ and no two-step path goes from $w$ to $w'$, $M, w \not \models \Diamond \Diamond A$ 
$$\blacksquare$$
**Main lessons from the above question was that whenever there is an existential quantifier in the assumption I'm making, it's useful to prove something that works with existential quantifier. In this case, converting the formula from being in terms of $\square$s to $\Diamond$s.**

In 1.a.i, I correctly reasoned that it is satisfiable, but I incorrectly reasoned that it is not valid. **In this case, I should have just drawn out the full 8 row truth table**.

### Exam 2021 Notes
1.a.ii. In $-(a \cdot b) + -(b + c \cdot \bar a)$, the simplest answer is $\bar a + \bar b$. The key to this level of simplification was factoring out the $\bar b$s and getting $\bar a + \bar b (1 + \bar c + a)$, where $(1 + \bar c + a) = 1$. 

1.b.ii. I forgot to include that $\lnot (m = 0)$. 
1.b.iii. I made an oopsie somehow quantifying that $x$ must be equal to all $y$. 

1.c.ii. For quantifiers, I need to do the substitution thingy (value updating) next time. Aka $M \models_{p[x \rightarrow d]}$ and make it quantified over $d$.

### Exam 2022 LSA Notes
1.b.i Think about whether the definition of reachability here is an implication or possibly a bi-implication. I went for implication since that is the closest to how the definition was formulated.**
1.b.ii Not entirely clear if self-reachability is allowed here, but it did say "other" vertex, which kind of implies self-reachability isn't allowed. Hence, my answer of $\exists v. \forall x. \lnot R(v, x)$ is potentially incorrect, with the correct version being $\exists v. \forall x. \lnot (v = x) \rightarrow R(v, x)$.
1.b.iv Here, although **self-referencing** isn't mentioned in the phrasing, it is inherent to reachability. $x$ is by definition reachable to itself, so the $\lnot (x = y)$ condition can be safely dropped.

### Exam 2022 Notes
1.a.i Big Oopsie. I got lucky here because even though I read the $\rightarrow$ as a $\leftrightarrow$, the truth table ends up looking the same. Just be careful next time.

**1.a.ii I got this wrong, first even as a DNF, second because it asked for a CNF, not a DNF...** Carefully doing equivalences, one can reach to $A \lor C$ as the final answer.
*Another major lesson learned from 1.a.ii is to break down long and tedious computations as much as possible. For example, here I should definitely separate the distribution over many different complex terms to different parts of the page, and combine them all in the end.*
Alternatively, I could have written the truth table for $\lnot A$ where $A$ is the entire formula, and use this to get the DNF for $\lnot A$ (would have been easy on this one), flip the $\land$ and $\lor$ and negate all individual propositions. This is similar to Exercise Sheet 1: 1.7.

1.c I know I technically don't need to do both sides if I perform only equivalences, but most people are telling me I should just to be sure. So in the real exam, I will do both the implication and its converse.

1.b.iii go back to this one to ask others how they answered this one. It's unclear whether to use a quantifier here.
1.b.v I accidentally wrote $L(x, y)$ ($x$ likes $y$) instead of $L(y, x)$ ($x$ is liked by $y$): Corrected answer: $\forall x \forall y. (\exists z. L(y, z) \land L(z, x)) \rightarrow L(y, x)$  
