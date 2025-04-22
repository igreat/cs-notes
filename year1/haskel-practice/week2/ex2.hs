import Data.Char (toLower, toUpper)
import Data.Foldable (maximumBy)
import Data.Map qualified as Map
import Data.Ord (comparing)

inRange :: Int -> Int -> [Int] -> [Int]
inRange a b (x : xs)
  | x < a = inRange a b xs
  | x > b = []
  | otherwise = x : inRange a b xs

countPositive :: [Int] -> Int
countPositive [] = 0
countPositive (x : xs) = if x > 0 then 1 + countPositive xs else countPositive xs

capitalised :: String -> String
capitalised (x : xs) = toUpper x : toLowerAll xs
  where
    toLowerAll [] = []
    toLowerAll (x : xs) = toLower x : toLowerAll xs

title :: [String] -> [String]
title [] = []
title (word : words)
  | length word > 3 = capitalised word : title words
  | otherwise = toLowerAll word : title words
  where
    toLowerAll [] = []
    toLowerAll (x : xs) = toLower x : toLowerAll xs

isort :: (Ord a) => [a] -> [a]
isort [] = []
isort (x : xs) = insert x (isort xs)
  where
    insert :: (Ord a) => a -> [a] -> [a]
    insert y [] = [y]
    insert y (z : zs)
      | y <= z = y : z : zs
      | otherwise = z : insert y zs

merge :: (Ord a) => [a] -> [a] -> [a]
merge xs [] = xs
merge [] ys = ys
merge (x : xs) (y : ys) =
  if x <= y
    then x : merge xs (y : ys)
    else y : merge (x : xs) ys

-- Simple Cipher
rotor :: Int -> String -> String
rotor shift text =
  if shift < 0 || shift >= length text
    then error "Shift out of bounds"
    else drop shift text ++ take shift text

makeKey :: Int -> [(Char, Char)]
makeKey shift = zip alphabet (rotor shift alphabet)
  where
    alphabet = ['A' .. 'Z']

lookUp :: Char -> [(Char, Char)] -> Char
lookUp c [] = c
lookUp c (pair : pairs) =
  if c == fst pair
    then snd pair
    else lookUp c pairs

encipher :: Int -> Char -> Char
encipher shift c = lookUp c (makeKey shift)

normalise :: String -> String
normalise xs = [toUpper x | x <- xs, x /= ' ']

encipherStr :: Int -> String -> String
encipherStr shift str = [encipher shift c | c <- normalise str]

actualFreqScores :: Map.Map Char Double
actualFreqScores =
  Map.fromList
    [ ('E', 12.02),
      ('T', 9.10),
      ('A', 8.12),
      ('O', 7.68),
      ('I', 7.31),
      ('N', 6.95),
      ('S', 6.28),
      ('R', 6.02),
      ('H', 5.92),
      ('D', 4.32),
      ('L', 3.98),
      ('U', 2.88),
      ('C', 2.71),
      ('M', 2.61),
      ('F', 2.30),
      ('Y', 2.11),
      ('W', 2.09),
      ('G', 2.03),
      ('P', 1.82),
      ('B', 1.49),
      ('V', 1.11),
      ('K', 0.69),
      ('X', 0.17),
      ('Q', 0.11),
      ('J', 0.10),
      ('Z', 0.07)
    ]

-- Calculate the total score of a string
textScore :: String -> Double
textScore str = sum [Map.findWithDefault 0 (toUpper c) actualFreqScores | c <- str]

-- Decipher a Caesar cipher string by finding the shift that maximizes the text score
decipherCeasar :: String -> String
decipherCeasar str = encipherStr bestShift str
  where
    bestShift = fst $ maximumBy (comparing snd) [(shift, textScore (encipherStr shift str)) | shift <- [0 .. 25]]

-- Lecture Excercises
isortd :: (Ord a) => [a] -> [a]
isortd [] = []
isortd (x : xs) = insert x (isortd xs)
  where
    insert :: (Ord a) => a -> [a] -> [a]
    insert a [] = [a]
    insert a (x : xs)
      | a > x = a : x : xs
      | a == x = insert a xs -- removes duplicates
      | otherwise = x : insert a xs
