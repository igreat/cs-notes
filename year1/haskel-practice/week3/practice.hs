import Test.QuickCheck

-- redoing exercises from lab and lectures for practice

-- ### EFFICIENT HASKELL QUEUE: AMORTIZED O(1) ADD AND REMOVE ### ---
data Q a = Q [a] [a] deriving (Eq, Show)

empty = Q [] []

isEmpty q = q == empty

add x (Q front back) = fixQ (Q front (x : back))

front (Q (x : front) back) = x

remove (Q (x : front) back) = fixQ (Q front back)

fixQ (Q [] back) = Q (reverse back) []
fixQ q = q

-- ### DATA DECLARATIONS IN HASKELL ### ---
data Answer = Yes | No | Unknown deriving (Show)

flipAnswer :: Answer -> Answer
flipAnswer Yes = No
flipAnswer No = Yes
flipAnswer Unknown = Unknown

answers :: [Answer]
answers = [Yes, No, Unknown]

-- ### NATURAL NUMBERS ### ---
data Nat = Zero | Succ Nat deriving (Show)

nat2int :: Nat -> Int
nat2int Zero = 0
nat2int (Succ n) = 1 + nat2int n

int2nat :: Int -> Nat
int2nat 0 = Zero
int2nat n = Succ (int2nat (n - 1))

addNat Zero n = n
addNat (Succ m) n = Succ (addNat m n)

mulNat :: Nat -> Nat -> Nat
mulNat Zero n = Zero
mulNat (Succ m) n = addNat n (mulNat m n)

-- TODO: if have time implement the following exercise:
{-  A binary tree is complete if the two sub-trees of every node are of
    equal size. Define a function that decides if a binary tree is complete
-}

-- ### PROPS ### ---
reverse' :: [a] -> [a]
reverse' [] = []
reverse' (x : xs) = reverse' xs ++ [x]

prop_RevUnit x = reverse' [x] == [x]

prop_RevApp xs ys = reverse' (xs ++ ys) == reverse' ys ++ reverse' xs

prop_RevRev xs = reverse' (reverse xs) == xs

-- ### Cross Word ### ---
cwordFind :: Char -> Int -> Int -> [String] -> [String]
cwordFind letter pos len words = [wd | wd <- words, length wd == len, wd !! pos == letter]

cwordFindRec :: Char -> Int -> Int -> [String] -> [String]
cwordFindRec letter pos len [] = []
cwordFindRec letter pos len (x : xs) =
  if (x !! pos == letter) && (length x == len)
    then x : cwordFindRec letter pos len xs
    else cwordFindRec letter pos len xs

cwordFindHO :: Char -> Int -> Int -> [String] -> [String]
cwordFindHO letter pos len = filter p
  where
    p x = (x !! pos == letter) && (length x == len)

-- exercises
mult :: (Num a) => [a] -> a
mult = foldr (*) 1

popList = filter (> 0)

trueList :: [Bool] -> Bool
trueList = foldr (&&) True

evenList :: [Int] -> Bool
-- evenList = foldr (\num acc -> even num && acc) True
evenList = foldr ((&&) . even) True

maxList :: (Ord a) => [a] -> a
maxList xs = foldr max (head xs) xs

inRange :: Int -> Int -> [Int] -> [Int]
inRange l h = filter (\x -> x >= l && x <= h)

countPositives :: [Int] -> Int
countPositives xs = foldr (\_ acc -> acc + 1) 0 (filter (> 0) xs)

myLength :: [Int] -> Int
myLength xs = foldr (+) 0 (map (\x -> 1) xs)

myMap :: (a -> b) -> [a] -> [b]
-- myMap f = foldr ((\x acc -> f x : acc)) []
myMap f = foldr ((:) . f) []

myLength' :: [Int] -> Int
myLength' = foldr (\_ acc -> acc + 1) 0