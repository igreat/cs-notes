import Data.Char (ord, toLower, toUpper)

testList :: [Integer]
testList = [3, 1, 2, 6, 2, 5, 10, 0, 4]

-- redoing exercises from lab and lectures for practice
qsort :: (Ord a) => [a] -> [a]
qsort [] = []
qsort (x : xs) =
  qsort [a | a <- xs, a <= x]
    ++ [x]
    ++ qsort [b | b <- xs, b > x]

applyTwice :: (a -> a) -> a -> a
applyTwice f x = f (f x)

foldr' :: (a -> b -> b) -> b -> [a] -> b
foldr' _ acc [] = acc
foldr' f acc (x : xs) = f x (foldr' f acc xs)

inRange :: Int -> Int -> [Int] -> [Int]
inRange _ _ [] = []
inRange l h (x : xs) =
  if x >= l && x <= h
    then x : inRange l h xs
    else inRange l h xs

countPositive :: [Int] -> Int
countPositive [] = 0
countPositive (x : xs) = (if x > 0 then 1 else 0) + countPositive xs

captialised :: String -> String
captialised [] = []
captialised (x : xs) = toUpper x : toLowerAll xs

toLowerAll [] = []
toLowerAll (x : xs) = toLower x : toLowerAll xs

title :: [String] -> [String]
title [] = []
title (word : words)
  | length word < 4 = toLowerAll word : title words
  | otherwise = captialised word : title words

insert :: (Ord a) => a -> [a] -> [a]
-- binary search isn't really possible with linked lists :(
insert x [] = [x]
insert x (y : ys) =
  if x <= y
    then x : y : ys
    else y : insert x ys

isort :: (Ord a) => [a] -> [a]
isort [] = []
isort (x : xs) = insert x (isort xs)

merge :: (Ord a) => [a] -> [a] -> [a]
merge xs [] = xs
merge [] ys = ys
merge (x : xs) (y : ys)
  | x < y = x : merge xs (y : ys)
  | y < x = y : merge (x : xs) ys
  | otherwise = x : y : merge xs ys

rotor :: Int -> String -> String
rotor shift text =
  if shift > 0 && shift < length text
    then drop shift text ++ take shift text
    else error "Shift out of bounds"

makeKey :: Int -> [(Char, Char)]
makeKey shift = zip alphabet (rotor shift alphabet)
  where
    alphabet = ['A' .. 'Z']

lookUp :: Char -> [(Char, Char)] -> Char
lookUp key [] = key
lookUp key ((key', value) : pairs)
  | key' == key = value
  | otherwise = lookUp key pairs

encipher :: Int -> Char -> Char
encipher shift c = lookUp c (makeKey shift)

normalise :: String -> String
normalise xs = [toUpper x | x <- xs, x /= ' ']

encipherStr :: Int -> String -> String
encipherStr shift text = [encipher shift x | x <- normalise text]
