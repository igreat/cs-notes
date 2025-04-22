-- exam 2017 practice

fac :: Int -> Int
fac n = foldr (*) 1 [1 .. n]

sumFac :: Int -> Int
sumFac n = sum $ map fac [0 .. n]

cubes a b = [x | x <- [a .. b], let z = x ^ 3 in z >= 200 && z <= 1000]

-- haskell can lazily evaluate all whole numbers from 1 .. inifity
-- haskell would simply stop producing new values after the maximum whole number is reached
-- however a more efficient approach would be to mathematically calculate the bounds
-- or stop after the first value where the cube is greater than 2000

negSum :: [Int] -> Int
negSum = sum . map (^ 2) . filter (> 0)

cycle' [] = []
cycle' [x] = [x]
cycle' (x : y : ys) = y : cycle' (x : ys)

-- combi :: [(Float, Float)] -> (Float, Float)
-- combi pairs = foldr (\(a, b) (acca, accb) -> (acca + a, accb + b)) (0, 0) filteredPairs
--   where
--     filteredPairs = [(a, b) | (a, b) <- pairs, a > b]

combi :: [(Float, Float)] -> (Float, Float)
combi pairs =
  let filteredPairs = [(a, b) | (a, b) <- pairs, a > b]
   in (sum [a | (a, _) <- filteredPairs], sum [b | (_, b) <- filteredPairs])
