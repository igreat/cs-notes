## Statement
Let $M = (W, R)$. Then:
$$
M \models \Diamond A \rightarrow \square \Diamond A \iff M \text{ is euclidean}
$$
A frame is euclidean $\iff \forall w \forall u \forall v. (Rwv \land Rwu) \rightarrow Rvu$. In other words, if two worlds are accessible from $w \in W$, then they must be accessible directly from themselves too.
## Proof 
Let $M = (W, R)$ and assume $M$ is euclidean. Choose arbitrary $w \in W$ and valuation $\rho$. Assume $M, w \models_\rho \Diamond A$. $\text{RTP: } M, w \models_\rho \square \Diamond A$. 
Since $M, w \models_\rho \Diamond A$, then there exists $u \in W$ such that $Rwu$ and $M, u \models_\rho A$. Assume another worlds $v$ such that $Rwv$. Since $M$ is euclidean, then since $Rwv \land Rwu$, then $Rvu$. Thus, we also have $M, v \models_\rho \Diamond A$. Thus, for all $w' \in W$ if $Rww'$, then $M, w' \models_\rho \Diamond A$. Hence, $M, w \models_\rho \square \Diamond A$. As required.

We now prove the converse: $M \text{ is not euclidean } \rightarrow (M, w \not \models_\rho \Diamond A \rightarrow \square \Diamond A)$. Let $M = (W, R)$ and assume $M$ is not euclidean. Hence, there exists $(Rwu \land Rwv)$ such that $\lnot Ruv$. Now, let $\rho(A) = \{v\}$. Hence, since $M, v \models_\rho A$ and $Rwv$, we have $M, w \models_\rho \Diamond A$. However, we have $Rwu$, but $\lnot Ruv$. Since $A$ is only true in $v$ with $\rho$, then $M, u \not \models_\rho \Diamond A$. Hence, not all worlds $w' \in W$ accessible from $w$ satisfy $M, w' \models_\rho \Diamond A$. Hence, $M, w \not \models_\rho \square \Diamond A$. As required.


