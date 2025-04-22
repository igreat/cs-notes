## Statement
Let $M = (W, R)$. Then:
$$
M \models \Diamond A \rightarrow \square A \iff M \text{ is functional}
$$
A frame is functional $\iff \forall w \forall u \forall v. (Rwv \land Rwu) \rightarrow v = u$. In other words, a world $w \in W$ can only have one transition at most.
## Proof 
Let $M = (W, R)$ and assume $M$ is functional. Choose arbitrary $w \in W$ and valuation $\rho$. Assume $M, w \models_\rho \Diamond A$. $\text{RTP: } M, w \models_\rho \square A$.
Since $M, w \models_\rho \Diamond A$, then there exists $w' \in W$ such that $M, w \models_\rho A$. Since A is functional, each world in $W$ can only have one transition at most, so $w'$ is the only world reachable from $w$. Hence, all $u \in W, Rwu$ have $M, u \models_\rho A$. Hence, $M, w \models_\rho \square A$.

We now prove the converse: $M \text{ is not functional } \rightarrow (M, w \not \models_\rho \Diamond A \rightarrow \square A)$. Let $M = (W, R)$ and assume $M$ is not functional. Hence, there exists $w, u, v \in W$ such that $Rwv \land Rwu$ but $v \neq u$. Now, let $\rho(A) = \{v\}$. Hence, since $M, v \models_\rho A$ and $Rwv$, we have $M, w \models_\rho \Diamond A$. However, since $A$ is only true in $v$ with valuation $\rho$ and by assumption $v \neq u$, then $M, u \not \models_\rho A$. And since $Rwu$ we have that not all worlds reachable from $w$ satisfy $A$. Hence, $M, w \not \models_\rho \square A$. Hence $M, w \not \models_\rho \Diamond A \rightarrow \square A$. As required. 

