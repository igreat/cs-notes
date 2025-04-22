## General Notes
- Make sure to go back to textbook section on NFA -> DFA conversion, in case my method has something wrong.
- Notably difficult problems (potentially I should ask more about these)
	- 2021 LSA 2.d.ii
## Exam Notes
### 2019 Exam
- 2.a Very very tedious. Be very careful with epsilon closure (you only apply it when you are transitioning INTO a state which has epsilon transitions, I think)
- 2.b.ii, fairly proud of this one: $\{a^ib^jc^{i+j} \,|\ i, j \geq 0\}$.
- 2.c I got the proof correct, but perhaps for ensuring full marks I should state ALL the conditions of pumping lemma.
- 2.d I correctly answered "it is context-free", and presented a CFG describing it. But for a 10 mark answer it felt too little. Perhaps they want a proof by induction of the correctness of my CFG? *(according to Varun, no, I don't need)*
- 2.e. Not sure which approach was better here or if worth mentioning both:
	- Let $\text{TM } \bar M$ that describes $\bar L$ be: $\bar M = (Q, \Sigma, \Gamma, \delta, q_0, q_{\text{reject}}, q_{\text{accept}})$. Notice that I've simply switched the reject and accept states.
	- Another approach: Let $\text{TM } \bar M$ be such that on input $w$:
		1. Simulate and run $M$ on $w$
		2. If $M$ rejects, accept
		3. If $M$ accepts, reject 
	- Since $M$ is a decider for $L$, $M$ is guaranteed to terminate, so $\bar M$ is a decider for $\bar L$.
### 2021 Exam
- 2.a another tedious one, *still have no clue if I'm correct for sure*. My final answer was $a(bb^*ca)^*(ac \cup a) \cup \epsilon$ 
- 2.b $\epsilon \cup b(ab)^* \cup a(ba)^*$
- 2.c I'm being confused by ChatGPT if infinitely pumpable in (i) implies an infinitely long string, also confused about the split bit. (ii) is confusing because is it asking if ALL infinite languages are Turing decidable or just about the existence of one such language?
### 2022 LSA Exam
2.a On this one, honestly I should have just gone with the intuitive way of doing this, much faster, instead of doing the Regex -> NFA -> DFA. Just try to build the DFA directly.

2.b was arguably one of the WORST questions I've gotten way too tedious. Major lesson learned from this:
- During NFA -> DFA conversions, it's very important to be very structured in my approach so as not to miss anything. Do a sort of depth first search. Always search to the deepest, and mark nodes that I'm already completely done with (visited all their transitions). Breadth first search works as well, but just be structured.

2.d.ii: **this one I'll just straight up admit I could not get right. In retrospect, $L(G) = \{w \,|\ w \in \{0, 1\}^*, w \text{ has an even number of 1s and an even number of 0s}\}$.**
$$
\begin{align*}
S &\rightarrow 0A \,|\ 1B \,|\ \epsilon \\
A &\rightarrow 0S \,|\ 1C \\
B &\rightarrow 0C \,|\ 1S \\
C &\rightarrow 0B \,|\ 1A \\
\end{align*}
$$
==I got this wrong **TWICE**==. The method to see this clearly was to realize that this is of the form that could be directly translated into a DFA (I suspected this), and then the DFA spells out the language a lot more clearly.

2.e: my answer was yes, it is decidable, and here is how to construct a TM for it. *Confirm with others later.*

We know TM $M_\emptyset$ exists for deciding if a DFA accepts no string (i.e, if $L(\text{DFA}) = \emptyset$). Also, DFAs are closed under intersection (proved similarly to union closure, but at the end accept only if both DFA states are accept states). Furthermore, we can construct a DFA $M_{\text{ODD}}$ that accepts all odd-length strings $\rightarrow q_0 \xleftrightarrow[\Sigma]{\Sigma} \bar q_F$.
Now, we can finally construct TM $M$ that decides if a DFA $D$ accepts any odd-length. Define TM $M$ such that on input $\langle D \rangle$:
1. Construct $D'$ which is the intersection of $M_{\text{ODD}}$ and $D$ (accepts only if both $M_{\text{ODD}}$ and $D$ accept, can be done in finite steps)
2. Simulate and run $M_\emptyset$ on $D'$
	1. If $M_\emptyset$ accepts, accept
	2. If $M_\emptyset$ rejects, reject
Since $M_\emptyset$ itself is decidable, then the program is guaranteed to generate an answer. Hence $L$ is decidable. 
### 2022 Exam

2.c. For some reason I made a CFG that recognizes $w\#w^R$ (yikes). Didn't take me too long to get a correct CFG though:
$$
\begin{align*}
S &\rightarrow PE \\
P &\rightarrow 0P0 \,|\ 1P1 \,|\ T \\
T &\rightarrow \# \,|\ T0 \,|\ T1 \\
E &\rightarrow 1E \,|\ 0E \,|\ \epsilon
\end{align*}
$$
2.d. After revisiting it, I immediately found flaws in my pumping lemma proof. Specifically, the step I skipped was a bit different than the other steps, so skipping it was a "miss-step". Here was my second attempt:
No. It is NOT context-free. Proof:
Assume $L$ is a CFL. Then by pumping lemma, there exists pumping length p such that if $s \in L$, $|s| \geq p$, then s can be broken into $s = uvxyz$, such that $|vxy| \leq p$, $|vy| \geq 1$, $uv^ixy^iz \in L$ for all $i \geq 0$.
Let $s = 01^p\#01^p$, and assume pumping length p. Then $|s| \geq p$, so $s$ is pumpable.
Since $|vxy| <= p$, then $vxy$ can be divided into  3 main cases:
1. $vxy$ lies in the left $01^p$ section. Pumping UP breaks the pattern (now $|\text{substring}| > |\text{string}|$ should not be possible)
2. $vxy$ lies in the right $01^p$ section. Pumping DOWN breaks the pattern ($|\text{substring}| > |\text{string}|$ as well)
3. $vxy$ lie in the $1^p\#0$ section.
	1. Pumping UP can:
		1. Increase the number of $1s$, where there wont enough $1s$ on the right side to match it.
		2. Increase $\#$ immediately breaking the structure 
	2. Pumping DOWN can:
		1. Decrease the $0$ to nothing, so there won't be any $0$ to match the right's $0$ with.
All cases lead to breaking the pattern upon either pumping up or down. Hence, our assumption that $L$ is context-free was wrong. Thus, $L$ is not context-free.

2.e: Asked if $\{ w\#x \,|\ w \text{ is a substring of } x\}$ is Turing-decidable. My answer:
It is Turing-decidable. We design a TM $M$ that decides it:
High level logic: check if $w$ matches start of $x$. If so accept, if not, remove first character from $x$, and repeat. If at any point we reach the end of $x$ with no match, then we reject.
$M :=$ "on input a:
0. Mark start of tape as $\$$ and shift input one step right.
1. If tape head is at character $1$, mark it with $\dot 1$ and move tape head right until $\#$. Then, find first unmarked character. If it is not $1$ move to step 3. Otherwise, mark it $\dot 1$ and move left to first encounter of marked character to the left of $\#$. Then, move one step right. If we're at $\#$, **ACCEPT**.
2. If tape head is at character $0$, mark it with $\dot 0$ and move tape head right until $\#$. Then, find first unmarked character. If it is not $0$ move to step 3. Otherwise, mark it $\dot 0$ and move left to first encounter of marked character to left of $\#$. Then, move one step right, if we're at $\#$, **ACCEPT**.
3. Go left until we find $\#$ or $\text{X}$. Then, go right one step and write $\text{X}$ at the new location. Then, reset all $\dot 0 \rightarrow 0$ and $\dot 1 \rightarrow 1$. Go back to start of tape and repeat steps 1 and 2.
4. If we reach $\textvisiblespace$ (end of input), **REJECT**."
This machine is guaranteed to eventually reach end of input and reject if no matches are found, so it will terminate in finite time. Thus, $M$ decides $L$.

**Less detailed proof. As per suggestion of Dr. Nakamura, which were:**
- Too much low-level detail in TM
- Did not explicitly mention the Turing-recognizability (even though it is directly implied from decidability)

It is Turing-decidable (and hence Turing-recognizable too). We design a TM $M$ that decides it:
$M :=$ "on input $a$:
1. Identify $w$ and $x$ based on schema $w\#x$. Immediately **REJECT** if not in right format.
2. By zig-zagging, compare $w$ with the start of $x$ character by character. 
	1. If all $w$ matches start of $x$, **ACCEPT**
	2. Upon first mismatch or entirety of $w$ not matching, remove first character of $x$ (eg. marking it with $X$) and restart step 2.
	3. If at any point we encounter end of string $\textvisiblespace$ **REJECT** ($w$ is not yet fully matched but no more characters in $x$ to match it with.
"
This machine is guaranteed to eventually reach end of input and reject if no matches are found, so it will terminate in finite time. Thus, $M$ decides (and hence also recognizes) $L$.
