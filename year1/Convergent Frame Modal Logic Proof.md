## Statement
Let $M = (W, R)$. Then:
$$
M \models \Diamond \square A \rightarrow \square \Diamond A \iff M \text{ is convergent}
$$
A frame is convergent $\iff \forall w \forall v \forall x. (Rwv \land Rwx) \rightarrow \exists u(Rvu \land Rxu)$. In other words, if two worlds are accessible from $w$, then there is also a world that is accessible from both.
## Proof
Let $M = (W, R)$ and assume $M$ is convergent. Choose arbitrary $w \in W$ and valuation $\rho$.
Assume $M, w \models_\rho \Diamond \square A$. $\text{RTP: } M, w \models_\rho \square \Diamond A$.  
Since $M, w \models_\rho \Diamond \square A$, then there exists $u \in W$ such that $M, u \models_\rho \square A$. Also choose arbitrary $v \in W$ such that $Rwv$. Since $M$ is convergent, then since $Rwu \land Rwv$, then we there exists $x \in W$ such that $Rux$ and $Rvx$. Since $M, u \models_\rho \square A$ and $Rux$, then $M, x \models_\rho A$. But also since $Rvx$, then we also have $M, v \models_\rho \Diamond A$. Hence, we proved that for any arbitrary $v \in W$ accessible from $w$, we have $M, v \models_\rho \Diamond A$. Thus $M, w \models_\rho \square \Diamond A$. As required.

We now prove the converse: $M \text{ is not convergent } \rightarrow M \not \models \Diamond \square A \rightarrow \square \Diamond A$. Let $M = (W, R)$ and assume $M$ is not convergent. Hence, there exists $w, v, x \in W$ such that  $Rwv \land Rwx$ but $\lnot \exists u(Rvu \land Rxu)$. Let $A = P$ and choose $\rho(P) = \{v' \,|\, Rvv'\}$ (all worlds reachable from $v$). Thus, we have that $M, v \models_\rho \square A$. Hence, since $Rwv$, $M, w \models_\rho \Diamond \square A$. 
However, since $Rwv \land Rwx$ and by the non-convergence assumption, non of the worlds accessible from $v$ will be accessible from $x$. And since $A$ is only true in worlds accessible from $v$, then no world accessible from $x$ satisfies $A$. Hence, $M, x \not \models_\rho \Diamond A$. Hence, since $Rwx$, then $M, w \not \models_\rho \square \Diamond A$, as required.  
