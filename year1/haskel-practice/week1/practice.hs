import Data.Char (toLower, toUpper)

-- redoing the exercises from week 1 for practice

square :: Int -> Int
square n = n * n

isTriple :: Int -> Int -> Int -> Bool
isTriple x y z = z ^ 2 == x ^ 2 + y ^ 2

isTripleAny :: Int -> Int -> Int -> Bool
isTripleAny x y z = isTriple x y z || isTriple x z y || isTriple z x y

halfEvens :: [Int] -> [Int]
halfEvens xs = [if even x then x `div` 2 else x | x <- xs]

inRange :: Int -> Int -> [Int] -> [Int]
inRange l h xs = [x | x <- xs, x >= l && x <= h]

countPositive :: [Int] -> Int
countPositive xs = sum [1 | x <- xs, x > 0]

capitalised :: String -> String
capitalised "" = ""
capitalised (x : xs) = toUpper x : [toLower c | c <- xs]

title :: [String] -> [String]
title [] = []
title words =
  [ if length word >= 4
      then capitalised word
      else [toLower x | x <- word]
    | word <- words
  ]