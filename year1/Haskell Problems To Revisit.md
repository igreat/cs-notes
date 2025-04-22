##  I **DID NOT** these on the first try.
-  What does this evaluate to? `(\v d -> v d) (\d -> d) 2`
- This `iter` implementation... I failed to come up with on first try instead I used `[0..n]`, not correct usage of `foldr`
```haskell  iter'' :: Int -> (a -> a) -> a -> a
iter'' n f = foldr (.) f (replicate (n - 1) f)
```

## General Notes
- Make sure to ask a question about whether we can use other prelude functions like replicate, all, any, etc.
- Try to remember how this works because it confused me A LOT during review
```haskell
evenList :: [Int] -> Bool
-- evenList = foldr (\num acc -> even num && acc) True
evenList = foldr ((&&) . even) True

myMap :: (a -> b) -> [a] -> [b]
-- myMap f = foldr ((\x acc -> f x : acc)) []
myMap f = foldr ((:) . f) []
```
- **Operator section**: a partially applied infix operator e.g.: `(+2)`, `(*3)`
- `foldr` and `foldl` accumulator function arguments are reversed:
```haskell
foldr (\element acc -> <term>) <start_acc> <list>
foldl (\acc element -> <term>) <start_acc> <list>
```
