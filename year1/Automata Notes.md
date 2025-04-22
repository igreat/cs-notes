- **Lecture 9** won't come in the exam content, so I skipped it. Might be worthwhile coming back to it for understanding if have time.
- I don't fully get the proofs of the properties of pumping lemma for CFL
- [Useful website for testing equivalence of Regexes](https://bakkot.github.io/dfa-lib/regeq.html)
- I'm weak on proofs of equivalences, if they come on exam, make sure to review.
	- Especially $\text{TM} \iff \text{Multi-tape TM} \iff \text{Non-deterministic TM}$

|     |    DFA    |     PDA     |     TM      |                                                                                                                                            |
| --: | :-------: | :---------: | :---------: | ------------------------------------------------------------------------------------------------------------------------------------------ |
|   A | Decidable |  Decidable  | Undecidable | Sets of $\langle \text{automata}, w \rangle$ pairs where $\text{automata}$ accepts $w$                                                     |
|   E | Decidable |  Decidable  | Undecidable | Sets of $\langle \text{automata} \rangle$ that reject all input                                                                            |
| ALL | Decidable | Undecidable | Undecidable | Sets of $\langle \text{automata} \rangle$ that accept all strings in $\Sigma^*$                                                            |
|  EQ | Decidable | Undecidable | Undecidable | Sets of $\langle \text{automata}, \text{automata} \rangle$ pairs $\langle M_1, M_2 \rangle$ where $M_1$ and $M_2$ accept the same language |

## Exercises
==The question that asked to find PDA that matches w#wR was interesting. Revisit it as a similar problem came up in a past exam==
### Exercise Sheet 1 Notes
- 5. Here, I kind of hand-wavingly said Yes, but the answer is **No**. The key lies in the fact that NFA transition functions outputs a set, which can contain more than one element. The NFA "keeps track" of all possible branches when reading the input, and will accept if **any** of the branches ends in an accept state. For the complement, accepting in the new NFA would mean rejecting inputs where **any** branches end in an accept state, but reversing the accept and reject states only reject when **all** are accept states. **Too permissive** as not all strings that were previously accepted will be rejected. 
- 6. I got the right high-level idea, but I didn't proceed with the technical details that were in the answer sheet. For example, I needed to show, based on the definition of acceptance of NFAs, that the DFA I've constructed will accept all languages of the form $w^R$. (extra waffle basically).
- 8.7, I said $(c \cup \epsilon)(a \cup b)^*$, when it should have been $(cb \cup \epsilon)(a \cup b)^*$
### Exercise Sheet 2 Notes
- 1. I have to make sure to spell out my assumption, namely that $\text{rev}(R_{1}) \text{ and } \text{rev}(R_{2})$ are valid regexes representing the reverses, and then show how $\text{rev}(R)$ is a valid regex representing the reverse of $R$.
- 2. I managed to get the regex $a^* \cup a^*b (aa^*b)(aa^* \cup \epsilon)$ correctly, but I made quite a lot of errors along the conversions from GNFA to regex. I missed a lot of transitions that I needed to take care of before plucking out a state *(be careful next time)*

### Exercise Sheet 3 Notes
- 2. Perhaps make sure be specific, like saying
	- All strings, IN $\Sigma^* \text{ (where } \Sigma = \{a, b\})$, of odd length 
### Exercise Sheet 4 Notes
- 1. I got the idea wrong first, but before looking up the solution I got the right idea, only I was too lazy to write it down 😛
- 3. I couldn't immediately solve this one. The key to this one is realizing that the current length can be kept track of by simply appending to an enumeration tape (so to speak). I had to idea of using the $n^2 = \text{sum of first n odd numbers}$, but I couldn't implement it as an enumeration 😔
- Generally if I can't think of how certain bits of my algorithm can be implemented in a Turing Machine, just skip explaining that bit and assume it's possible, otherwise explain. **The idea of enumeration is important, though.**
- In 4. I'm correct because I did not assume $L(\text{DFA}) = \emptyset$ is decidable. So I did a proof that is very similar to the one that shows that $L(\text{DFA}) = \emptyset$ is decidable (essentially inverted the logic). However, it probably would have been better to just assume that property and just take the complement of the DFA (Regular Languages are closed under complement).
- 5. I actually got this one pretty much completely correctly, but I didn't further explain why regular languages are closed under intersection. Perhaps for something that isn't explained in the lectures like this, I should further justify.
### Quiz 3 Notes
- I got 8. wrong because I wasn't careful enough. Once again, with DFA -> REGEX I have to be VERY VERY careful not to miss certain transitions. Safest thing is to just always carefully and painstakingly do the GNFA -> REGEX conversion. 
- I got 9. for similar silly reasons, but this one was even sillier.
- 6. caught me off guard, it takes a bit more thinking to realize that $L = \{w | w \text{ contains as many occurrences of ``01" as ``10"}\}$ is regular. Essentially, the 01 and 10 bits represents transitions from 0 to 1 and 1 to 0. This is very doable with DFAs and probably even easier with NFAs (TODO: create a DFA that recognizes that $L$).
### Quiz 4 Notes
- 2. $$
\begin{align*} 
X &\rightarrow 01 \,|\ RXR \,|\ \epsilon \\
R &\rightarrow 001 \,|\ \epsilon \\
\end{align*}
$$Actually represents a regular language (I got this part wrong). Though there's no way to immediately prove a language IS regular, I could have attempted to create a regex and easily gotten this $$(001)^*(01)^*(001)^*$$ (I think)
- 3. I said $L = \{a^i b^j c^k \mid j > k, i = j-k\}$ was not a CFL when in fact **it is INDEED context-free**. Took me some time but I managed to even make a CFG for it.
$$
\begin{align*}
1. & \quad S \rightarrow aAbB \\
2. & \quad A \rightarrow aAb \,|\, \epsilon \\
3. & \quad B \rightarrow bBc \,|\, \epsilon
\end{align*}
$$
- Main lesson learned on 3. is that if I can't immediately *see* that it's a CFG, then try pumping lemma, if I can't get pumping lemma to prove its not a CFL, then try a bit more to make a CFG\\PDA for it (or a rough one, just want to be confident enough that it exists). Chances are it is a CFL.