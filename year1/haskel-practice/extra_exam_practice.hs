import Data.Char (isLower, toLower, toUpper)
import Data.List
import Test.QuickCheck

reverse' :: [a] -> [a]
reverse' [] = []
reverse' (x : xs) = reverse' xs ++ [x]

prop_RevUnit x = reverse' [x] == [x]

prop_RevApp xs ys = reverse' (xs ++ ys) == reverse' ys ++ reverse xs

prop_RevRev xs = reverse' (reverse' xs) == xs

square :: Integer -> Integer
square x = x * x

pyth :: Integer -> Integer -> Integer
pyth a b = square a + square b

prop_square :: Integer -> Bool
prop_square x = square x >= 0

prop_squares :: Integer -> Integer -> Bool
prop_squares x y = square (x + y) == square x + square y + 2 * x * y

prop_pyth :: Integer -> Integer -> Bool
prop_pyth x y = square (x + y) == pyth x y + 2 * x * y

cwordFind :: Char -> Int -> Int -> [String] -> [String]
cwordFind letter pos len words = [wd | wd <- words, length wd == len, wd !! pos == letter]

cwordFindRec :: Char -> Int -> Int -> [String] -> [String]
cwordFindRec letter pos len [] = []
cwordFindRec letter pos len (x : xs) =
  if (length x == len) && (x !! pos == letter)
    then x : cwordFindRec letter pos len xs
    else cwordFindRec letter pos len xs

cwordFindHO :: Char -> Int -> Int -> [String] -> [String]
cwordFindHO letter pos len = filter p
  where
    p x = (length x == len) && (x !! pos == letter)

prop_cwfCompRec :: Char -> Int -> Int -> [String] -> Bool
prop_cwfCompRec letter pos len w = (pos >= len || pos < 0) || (cwordFind letter pos len w == cwordFindRec letter pos len w)

prop_cwfRecH0 :: Char -> Int -> Int -> [String] -> Bool
prop_cwfRecH0 letter pos len w = (pos >= len || pos < 0) || cwordFindRec letter pos len w == cwordFindHO letter pos len w

mult :: Int -> Int -> Int
mult x 0 = 0
mult x y
  | even y = 2 * mult x (y `div` 2)
  | otherwise = x + 2 * mult x (y `div` 2)

evalRPN :: (Num a, Read a) => String -> a
evalRPN = head . foldl procStack [] . words

procStack :: (Num a, Read a) => [a] -> String -> [a]
procStack (x : y : ys) "*" = (y * x) : ys
procStack (x : y : ys) "+" = (y + x) : ys
procStack (x : y : ys) "-" = (y - x) : ys
procStack xs numString = read numString : xs

monadd :: (Monad m, Num b) => m b -> m b -> m b
monadd mx my = do
  x <- mx
  y <- my
  return $ x + y

main :: IO ()
main = do
  putStrLn "yessir"
  return ()

swapAround = do
  line <- getLine
  if null line
    then return ()
    else do
      putStrLn $ reverseWords line

reverseWords :: String -> String
reverseWords = unwords . map reverse . words

prop_zip :: (Eq a, Eq b) => [(a, b)] -> Bool
prop_zip xs = uncurry zip (unzip xs) == xs

negSum :: [Integer] -> Integer
negSum = sum . map (^ 2) . filter (< 0)

-- isPrime :: Integer -> Bool
-- isPrime n
--   | n <= 1 = False
--   | n == 2 = True
--   | even n = False
--   | otherwise = all (\x -> n `mod` x /= 0) [3, 5 .. floor (sqrt (fromIntegral n))]

isPrime :: Integer -> Bool
isPrime n = isPrime' n (n - 1)

isPrime' :: Integer -> Integer -> Bool
isPrime' _ 1 = True
isPrime' n x = ((n `mod` x) /= 0) && isPrime' n (x - 1)

iter' :: Int -> (a -> a) -> a -> a
iter' 0 _ = id
iter' n f = f . iter' (n - 1) f

quarProd :: [Integer] -> Integer
quarProd xs = foldr1 (\x acc -> acc * iter' 2 square x) (xs ++ [1])

sumAcc :: [Integer] -> Integer -> Integer
sumAcc [] acc = acc
sumAcc (x : xs) acc = sumAcc xs (acc + x)

prodInts :: Int -> IO ()
prodInts acc = do
  line <- getLine
  let x = read line :: Int
  if x /= 0
    then prodInts (acc * x)
    else putStrLn (show acc)

cuber :: [Integer] -> Integer
cuber = sum . map (^ 3) . filter (> 0)

mono :: Int -> (Int -> Int) -> Bool
mono n f = and $ zipWith (<) outputs (tail outputs)
  where
    outputs = map f [0 .. n]

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

allOdd :: [Int] -> Bool
allOdd = all odd

elem' :: (Eq a) => a -> [a] -> Bool
elem' z [] = False
elem' z (x : xs)
  | z == x = True
  | otherwise = elem' z xs

prop_Elem :: Int -> Int -> Int -> Bool
prop_Elem low high number =
  (number <= high && number >= low) == elem' number [low .. high]

prop_ElemConcat :: (Eq a) => [a] -> [a] -> a -> Bool
prop_ElemConcat xs ys n = (elem' n xs || elem' n ys) == elem' n (xs ++ ys)

data Tree a = Nil | Node a (Tree a) (Tree a) deriving (Eq, Ord, Show, Read)

depth :: Tree a -> Int
depth Nil = 0
depth (Node _ left right) = 1 + max (depth left) (depth right)

stupid :: IO ()
stupid = do
  putStrLn "Enter a whole number my friend"
  line <- getLine
  let number = read line :: Int
  printStupidNTimes number

printStupidNTimes :: Int -> IO ()
printStupidNTimes n = do
  if n <= 0
    then return ()
    else do
      putStrLn "Stupid!"
      printStupidNTimes (n - 1)

raised :: IO ()
raised = do
  putStrLn "Input text my friend"
  line <- getLine
  let lineUpper = toUpperAll line
  putStrLn lineUpper

toUpperAll :: String -> String
toUpperAll = map toUpper

coalesce :: (Eq a) => [(a, Float)] -> [(a, Float)]
coalesce [] = []
coalesce ((k, v) : pairs) = (k, v + countValue k pairs) : coalesce (removeKey k pairs)

countValue :: (Eq a) => a -> [(a, Float)] -> Float
countValue key pairs = sum [v | (k, v) <- pairs, k == key]

removeKey :: (Eq a) => a -> [(a, Float)] -> [(a, Float)]
removeKey key pairs = [(k, v) | (k, v) <- pairs, k /= key]

dist :: [(a, Float)] -> Bool
dist pairs = (sum values == 1) && all (<= 1) values
  where
    values = map snd pairs

normalise :: [(a, Float)] -> [(a, Float)]
normalise pairs
  | dist pairs = pairs
  | total == 0 = error "Cannot normalize a zero distribution"
  | otherwise = [(k, v / total) | (k, v) <- pairs]
  where
    total = sum $ map snd pairs

distribution :: (Eq a) => [(a, Float)] -> [(a, Float)]
distribution pairs = normalise $ coalesce pairs

prop_equivalentToDiv :: Int -> Int -> Property
prop_equivalentToDiv x y = (x /= 0 && y /= 0) ==> (div x y) == (x `div` y)

divDum :: Int -> Int -> Int
divDum n m
  | n < m = 0
  | otherwise = 1 + divDum (n - m) m

insert' :: (Ord a) => a -> [a] -> [a]
insert' x [] = [x]
insert' x (y : ys)
  | x > y = y : insert' x ys
  | otherwise = x : y : ys

iSort :: (Ord a) => [a] -> [a]
iSort = reverse . foldr insert' []

allLow :: String -> Bool
allLow = foldr1 (&&) . map isLower

merge :: [Int] -> [Int] -> [Int]
merge [] ys = ys
merge xs [] = xs
merge (x : xs) (y : ys)
  | y < x = y : merge (x : xs) ys
  | otherwise = x : merge xs (y : ys)

foldr' :: (a -> b -> b) -> b -> [a] -> b
foldr' _ acc [] = acc
foldr' f acc (x : xs) = f x (foldr' f acc xs)

prop_Foldr :: (Eq a) => [a] -> Bool
prop_Foldr xs = foldr' (:) [] xs == xs

a :: Int
a = head [x * x | x <- [1 ..], x * x > 1000000]

divides :: Int -> Int -> Bool
divides a b = b `mod` a == 0

prime :: Int -> Bool
prime n
  | n <= 1 = False
  | n == 2 = True
  | otherwise = not $ foldr1 (||) [divides x n | x <- [2 .. (n - 1)]]

mySum :: (Num a) => [a] -> a
mySum xs = foldr (+) 0 (map cube xs)

cube :: (Num a) => a -> a
cube n = n * n * n

merge' :: (Ord a) => [a] -> [a] -> [a]
merge' [] ys = ys
merge' xs [] = xs
merge' (x : xs) (y : ys)
  | x < y = x : merge' xs (y : ys)
  | otherwise = y : merge' (x : xs) ys

mSort :: (Ord a) => [a] -> [a]
mSort [] = []
mSort [x] = [x]
mSort xs = merge' (mSort left) (mSort right)
  where
    (left, right) = splitAt (length xs `div` 2) xs

splitHalf :: [a] -> ([a], [a])
splitHalf xs = splitAt' xs [] (length xs `div` 2)

splitAt' :: [a] -> [a] -> Int -> ([a], [a])
splitAt' xs ys 0 = (reverse ys, xs)
splitAt' (x : xs) ys n = splitAt' xs (x : ys) (n - 1)