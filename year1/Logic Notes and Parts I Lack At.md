## General Lecture Notes
- I kind of slept during the proof of equivalence of **two-step** and **regular induction**
- I didn't attempt to prove the equivalence of **regular induction** and **complete induction**
- For proofs by induction, I need to make sure to make a **strong enough inductive hypothesis**. This can some times be like assuming a property holds **for all** $y$ (where $y$ the variable we're doing induction on).
- Note the direct equivalence of **Infinite Descent** and **Strong Induction**
- I feel iffy about proving things like ([good extra notes](http://www.jakubszymanik.com/ML/noteslogai.pdf)):
	1. $M \models \square A \rightarrow \square \square A \iff M \text{ is transitive}$
	2. $M \models \square A \rightarrow A \iff M \text{ is reflexive}$
- More proofs (all are my proofs, so prone to being wrong) 
	- [[Euclidean Frame Modal Logic Proof]]
	- [[Functional Frame Modal Logic Proof]]
	- [[Dense Frame Model Logic Proof]]
	- [[Convergent Frame Modal Logic Proof]]
- [Useful website for truth tables!](https://web.stanford.edu/class/cs103/tools/truth-table-tool/)
- Challenging (not really, just tedious and prone to error) formula to decompose into DINF using logical equivalences: $((P \rightarrow Q) \land (Q \rightarrow R)) \land (R \rightarrow P)$
- I somehow keep struggling to prove that $a \cdot 0 = 0$. Here's the simplest way to do it for reference:
$$
\begin{split}
a \cdot 0 &= a \cdot (a \cdot \bar a) \\
		  &= (a \cdot a) \cdot \bar a \\
		  &= a \cdot \bar a \\
		  &= 0
\end{split}
$$
- $a + 1 = 1$ is proved in a similar way by substituting $1$ for $\bar a + a \text{ (complement law)}$
- I noticed that $\text{NAND} \text{ (NOT AND)}$ is in fact not associative
- **Chaining modalities** ($\square$ or $\Diamond$) together can be interpreted like in the following examples.
	- $M, w \models \Diamond \Diamond A$ means that from $w$, there exists a world in which $\Diamond A$ is satisfied. In other words, there from $w$ and in two steps we can get to a world in which $A$ is satisfied
	- $M, w \models \square \Diamond A$ means that from $w$, all worlds directly accessible should satisfy $\Diamond A$
	- $M, w \models \square \square A$ means that from $w$, all worlds directly accessible should satisfy $\square A$. In other words, all possible two steps from $w$ satisfy $A$
- Generally, when proving validity modal logic formulas, we choose an arbitrary frame and an arbitrary valuation and an arbitrary world
- When proving implications, the general approach is to assume the left hand side and show how the right hand side is derived $\checkmark$
- I'm not very strong on the induction proofs using lexicographic ordering for multiple element objects
## Exercise Notes
==TODO: eventually do the Quiz 1 and Quiz 2 (forgot about them)==
### Practice Sheet 1
- 1.1.d: Apparently brackets around a single propositional letter doesn't count as a propositional formula (strictly speaking)
- 1.4.d: I somehow mistook the $\land$ for an $\lor$, leading me to conclude that $(P \rightarrow Q) \land (P \land \lnot Q)$ is satisfiable, when in fact it is **unsatisfiable**
- Note on **DNFS** and **CNFS**
	- DNFS:
		1. Useful for proving the (un)satisfiability of formulas: If a single conjunctive clause does not contain both $P$ and $\lnot P$ at the same time, then the formula is satisfiable. Otherwise it is unsatisfiable.
		2. When taking the negation of the formula, converting it to a DNF, you can prove that the formula is valid if the negation is unsatisfiable. 
	- CNFS:
		1. Useful for theorem proving (A is valid $\iff$ every clause of the CNF is valid). One can prove that a disjunctive clause is valid if it contains both its literal and its negation
- 1.7.c: **Harder**: Given a propositional formula A explain how to find an equivalent formula written in conjunctive normal form (CNF).
	- I answered as simply doing a series of equivalences. However, the answer given was to get the DNF of $\lnot A$, and then negate that DNF and with De Morgan laws we get a CNF.
- 2.3.2: Beware simplifications. 
### Practice Sheet 2
- 2. Valid usually will mean the mathematical definition of valid (with respect to whether it's FOL, Propositional Logic or Modal Logic)
- 5. I did the proof through a series of equivalences ($\iff$'s), but the answer sheet does it only through implications ($\rightarrow$'s) and proves both directions individually. Perhaps do the same thing for safety. 
- 6. This one felt like it was *too trivial* that I didn't even know how to start proving it. In the end, the idea is to establish that for sentences, all valuations $\rho$ will lead to the same result because all free variables agree for the trivial reason that there are no free variables.
### Practice Sheet 3
- 3. I shouldn't have been hesitant to assume addition here is defined as previously and that I could use properties already proven before (associativity and commutativity). Otherwise I can solve this one.
- 4. I forgot that associativity in multiplication wasn't proven and I shouldn't really take it for free without mentioning it. **I made a mistake taking it for granted during my proof**.
### Practice Sheet 4
- 1. My proof was wrong (I did induction on both x and y simultaneously, not something that should ever be done). The correct way to do it is to either do complete induction on the pair $(x, y)$ with lexicographic ordering. The other is to do ordinary induction on x, and then I'd come across a statement where I'd need to do ordinary induction on y to prove it. So two ordinary inductions. 
- Revisit 2. as well, I felt pretty iffy about the way it was solved in the answer sheet.
- 5. **BIG NEW REALIZATION HERE (ASSUMING A STRONGER IH)** : During the induction hypothesis, when there are multiple variables, we can assume that the proposition is true for all values. For example, the right induction hypothesis for 5. is: $$\text{rev2}(ks, ys)=\text{rev}(ks)@ys \text{ for all }ys$$
- This allows us to use the induction hypothesis as long as I have something of the form $\text{rev2}(ks, \cdots)$
- Another note on 5. and 6. is that I need to be always assume I can use previous question results on newer questions. Indeed, 5. and 6. are designed to be in the right order so as to use previous results.
- For questions like 9, proving is simply reducing formulas to their primitive definition and then just using common sense.

COME BACK TO PROOF OF $$M \models A \rightarrow \square \Diamond A \iff M \text{ is symmetric}$$
Ok so I tried to do the proof myself without looking, here is what I came up with:

Let $M = (W, R)$. Choose arbitrary $w \in W$ and valuation $\rho$. Assume $M$ is symmetric.
Assume $M, w \models_p A$. $\text{RTP: }M, w \models_p \square \Diamond A$. Since M is symmetric, then for all $Rww', w' \in W$ we have  $Rw'w$. Hence, since $A$ is true in $w$,  $M, w' \models_p \Diamond A$. Since this is true for all $Rww', w \in W$, then $M, w \models_p \square \Diamond A$.

Converse. Let $M = (W, R)$. Assume $M$ is NOT symmetric. $\text{RTP: } M \not \models A \rightarrow \square \Diamond A$. Since M is not symmetric, there exists $w \in W$ where not all $w' \in W, Rww'$ have $Rw'w$. Let $w' \in W$ be such world. Let $\rho(A) = \{w\}$. Thus, $M, w \models_p A$. We show that $M, w \not \models_p \square \Diamond A$. Since there is no one step path from $w'$ to $w$, and $A$ is only true in $w$, then $M, w' \not \models_p \Diamond A$. Thus, $M, w \not \models_p \square \Diamond A$, hence $M, w \not \models \square \Diamond A$, as required.
$$\blacksquare$$
Notes on proof: I checked the answer sheet and my proof idea is identical. Only difference is perhaps wording in answer sheet is better and more concise (maybe I should work on that).