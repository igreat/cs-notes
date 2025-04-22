- a bit week on proofs using Hilbert system, try to prove the questions on the notes

**Exercise Sheet 2 1c 3**
I misinterpreted "unique" here to mean every node has a distinct color from every other node, but here it clearly should mean **a node has only one color**.

**Exercise Sheet 2 1c 4**
"Write down a first-order formula that means that two nodes connected by an edge must have different colours." **I got it wrong**.
I said $\forall x \forall y (E(x, y) \implies \exists a \exists b (\lnot (a = b) \land \rho(x, a) \land \rho(y, b)))$. This is wrong because it already assumes each node has one unique color, which isn't part of the original statement. It could be that x is both red and blue, and y is both red and blue. This shouldn't be true in the original statement but it is true in mine.
A corrected version is this: $\forall x \forall y (E(x, y) \implies \lnot \exists a (\rho(x, a) \land \rho(y, a)))$

**Exercise Sheet 2 1c 5**
I mistakenly ignored the domain restriction implication thinking it wasn't necessary, but it actually is here (think about why!)

**Exercise Sheet 4 3**
$$∀x∀y(∃zF(y,z) → F(x,y)), F(a,b) \vdash ∀y∃xF(y,x)$$
I couldn't solve this because I didn't notice that $∃z$ is bound only to $F(y,z)$, not the other side of the implication... This would allow it to be converted into a $\lnot \exists F(y,z)$, which is an $\alpha$ formula, so I don't have the restriction of "new constant".

**Exercise Sheet 6 1**
Here maybe I should have been a lot more detailed. The answer sheet goes into detail about what a proof exists actually means in different proof systems (tableau and axiomatic system)

**Exercise Sheet 7 4a**
I was asked what $\Diamond \top$ meant if valid in a frame, I got that right: there exists an outgoing arrow from each world in that frame. I got the second part wrong, as in what this meant in conjunction with being transitive and irreflexive and hastily said "fully connected", which is super wrong since it's very easy to find an example where the above is true but not fully connected. The actual answer stems from continuously building the model, realizing you have to add infinitely many worlds. So this means there are infinitely many worlds in this frame.

**Exercise Sheet 7 4b**
This one was hard and I got it wrong. MUST REVISIT

**Exercise Sheet 8 1c 2**
There are ways here to reduce infinite model into a finite one by checking essentially equivalent nodes, at some point in winter break I did it but forgot the exact details. **COME BACK THIS LATER**, could be very useful though unlikely to be necessary for exam (answer sheet uses infinite model).

==There's barely any info on Epistemic logic in slides, fully read the [wiki page](https://en.wikipedia.org/wiki/Epistemic_modal_logic) for it==

*Interestingly, Temporal Logic is an example of multi-modal logic (two modalities to be specific), but we didn't need to introduce a separate accessibility relation, because each are inverses of one another (so we just needed to change how the modalities are defined rather than introduce a new accessibility relation and define it as the inverse of the other).*

**Description of Tableau for Temporal Logic (just know basic definitions as prof said)**
Same as modal logic tableau, except I have to force the transitive forward property, and whenever I introduce a new world I have to take care of $G$s and $H$s by updating my graph, much like how I dealt with $\Box$. $F$ and $P$ operate much like $\Diamond$, where I introduce a new constant. Also here I have to think about linearity if requested, by default maybe assume linearity?. Basically yah if I want linearity then I shouldn't have any branching timelines. For linearity, I also need to consider ONE OF THREE POSSIBILITIES for satisfying the linearity condition, check slides.

**Exercise Sheet 9 3c**
Here it's actually ==very important== to consider how these relations need to be atomic. Hence, $1'$ and $o$ shouldn't be overlapping. In this way, $o$ is the overlap but not equivalent, similarly overlap but not contained in or contains. Very very important when constructing the composition table.

**Exercise Sheet 9 3d**
Very interesting stuff, once again, atomicy of $1'$ and $\subset;\subset$ play a big role here. Revisit!

**IMPORTANT NOTE MENTIONED IN REVISION**
Become comfortable with proving stuff with ==**compactness theorem**==, they could arguably be what differentiates a B from a first class, which is what I'm aiming for.

**Exam 2023 3.d**
Here, I mistakenly made a base 3 model, which was wrong. My mistake was not realizing that **when we say $a;b = b$, that means that ALL $b$ transitions can be represented as some $a$ followed by some $b$**.
