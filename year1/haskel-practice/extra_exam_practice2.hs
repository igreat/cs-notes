import Test.QuickCheck

insert :: (Ord a) => a -> [a] -> [a]
insert x [] = [x]
insert x (y : ys)
  | x > y = y : insert x ys
  | otherwise = x : y : ys

iSort :: (Ord a) => [a] -> [a]
iSort = reverse . foldr insert []

zip' :: [a] -> [b] -> [(a, b)]
zip' [] _ = []
zip' _ [] = []
zip' (x : xs) (y : ys) = (x, y) : zip' xs ys

unzip' :: [(a, b)] -> ([a], [b])
unzip' pairs = ([x | (x, _) <- pairs], [y | (_, y) <- pairs])

inverseUnzip :: ([a], [b]) -> [(a, b)]
inverseUnzip = uncurry zip'

triplets :: [(Int, Int, Int)]
triplets = [(a, b, c) | a <- [1 .. 20], b <- [1 .. 20], c <- [1 .. 20], a ^ 2 + b ^ 2 == c ^ 2, a * b > 200]

merge :: (Ord a) => [a] -> [a] -> [a]
merge [] ys = ys
merge xs [] = xs
merge (x : xs) (y : ys)
  | x < y = x : merge xs (y : ys)
  | otherwise = y : merge (x : xs) ys

swap :: (b -> c) -> (a -> b) -> (a -> c)
-- will apply f and g in the reverse order of the arguments
swap f g = f . g

allOdd :: [Int] -> Bool
allOdd = all odd

data Tree a = Nil | Node a (Tree a) (Tree a) deriving (Show)

depth :: Tree a -> Int
depth Nil = 0
depth (Node _ left right) = 1 + max (depth left) (depth right)

lmt :: (Num a) => [a] -> a
lmt xs = lmt' xs 1

lmt' :: (Num a) => [a] -> a -> a
lmt' [] acc = acc
lmt' (x : xs) acc = lmt' xs (x * acc)

allReverse :: [[a]] -> [[a]]
allReverse xss = reverse [reverse xs | xs <- xss]

zipWith' :: (a -> b -> c) -> [a] -> [b] -> [c]
zipWith' f xs ys = map (uncurry f) (zip xs ys)

type Vector = [Int]

ok :: Vector -> Vector -> Bool
ok v1 v2
  | null v1 || null v2 = False
  | otherwise = length v1 == length v2

dotProduct :: Vector -> Vector -> Int
dotProduct v1 v2
  | ok v1 v2 = sum $ zipWith' (*) v1 v2
  | otherwise = error "Vectors must be non empty and equal length"

take' :: Int -> [a] -> [a]
take' _ [] = []
take' 0 _ = []
take' n (x : xs) = x : take' (n - 1) xs

divisors :: Integer -> [Integer]
divisors n = [x | x <- [1 .. n], n `mod` x == 0]

isPrime :: Integer -> Bool
isPrime n
  | n <= 1 = False
  | otherwise = divisors n == [1, n]

cuber :: [Integer] -> Integer
cuber = sum . map (^ 3) . filter (> 0)

data MTree = NilTree | MNode MTree Int MTree deriving (Show)

ntSum :: MTree -> Int
ntSum NilTree = 0
ntSum (MNode t1 value t2) = ntSum t1 + value + ntSum t2

testTree = MNode (MNode NilTree 1 NilTree) 2 (MNode NilTree 3 NilTree)

ntList :: MTree -> [Int]
ntList NilTree = []
ntList (MNode t1 value t2) = ntList t1 ++ [value] ++ ntList t2

fac1 :: Integer -> Integer
fac1 0 = 1
fac1 n = n * fac1 (n - 1)

fac2 :: Integer -> Integer
fac2 n = foldr (*) 1 [1 .. n]

prop_FacInductive :: (Integer -> Integer) -> Integer -> Property
prop_FacInductive f x = x > 0 ==> f (x + 1) == (x + 1) * f x

prop_AlwaysIncreasing :: (Integer -> Integer) -> Integer -> Property
prop_AlwaysIncreasing f x = x > 0 ==> f (x + 1) >= f x

testInts :: IO ()
testInts = testInts' True

testInts' :: Bool -> IO ()
testInts' allEven = do
  line <- getLine
  let x = read line :: Int
  if x == 0
    then putStrLn (show allEven)
    else testInts' (allEven && even x)