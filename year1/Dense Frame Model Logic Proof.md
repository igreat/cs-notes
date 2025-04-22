## Statement
Let $M = (W, R)$. Then:
$$
M \models \square \square A \rightarrow \square A \iff M \text{ is dense}
$$
A frame is dense $\iff \forall w \forall v Rwv \rightarrow \exists u (Rwu \land Ruv)$. In other words, if there is a direct path from $w$ to $v$, then there is also a two way path from $w$ to $v$.
## Proof 
Let $M = (W, R)$ and assume $M$ is dense. Choose arbitrary $w \in W$ and valuation $\rho$. Assume $M, w \models_\rho \square \square A$. $\text{RTP: } M, w \models_\rho \square A$. 
Choose $v \in W$ such that $Rwv$. Since $M$ is dense. we know that there exists $u$ such that $Rwu$ and $Ruv$. But since $M, w \models_\rho \square \square A$ and $Rwu$, then $M, u \models_\rho \square A$. And since $Ruv$, then $M, v \models_\rho A$. Thus, $M, w \models_\rho \square A$. As required.

We now prove the converse: $M \text{ is not dense } \rightarrow (M, w \not \models_\rho \square \square A \rightarrow \square A)$. Let $M = (W, R)$ and assume $M$ is not dense. Hence, there exists $w \in W$ and $v \in W$ such that $Rwv$ and there is no $u \in W$ where $Rwu \land Ruv$. Now, we choose valuation $\rho(A) = W \setminus \{v\}$. Since $A$ is true in all worlds except $v$, but here is no two way path from $w$ to $v$, then we have $M, w \models_\rho \square \square A$. But since $Rwv$ and $v \not \in \rho(A)$, then $M, w \not \models_\rho \square A$. Hence, $M, w \not \models_\rho \square \square A \rightarrow \square A$. As required.
$$\blacksquare$$
## Alternative Proof 
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
