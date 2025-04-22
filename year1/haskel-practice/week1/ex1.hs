import Data.Char (toLower, toUpper)

-- LabSheet1 Questions
square :: Int -> Int
square n = n * n

pyth :: Int -> Int -> Int
pyth x y = x + y

isTriplet :: Double -> Double -> Double -> Bool
isTriplet a b c = (a * a + b * b) == (c * c)

isTripletAny :: Double -> Double -> Double -> Bool
isTripletAny a b c = isTriplet a b c || isTriplet a c b || isTriplet b c a

halfEven :: [Int] -> [Int]
halfEven a = [if even n then div n 2 else n | n <- a]

inRange :: Int -> Int -> [Int] -> [Int]
inRange a b lst = [n | n <- lst, b >= n && n >= a]

countPositive :: [Int] -> Int
countPositive [] = 0
countPositive (x : xs) = if x > 0 then 1 + countPositive xs else countPositive xs

capitalised :: String -> String
capitalised [] = []
capitalised (x : xs) = toUpper x : [toLower c | c <- xs]

title :: [String] -> [String]
title lst =
  [ if length word > 3
      then capitalised word
      else [toLower c | c <- word]
    | word <- lst
  ]

-- First Lecture Questions
firstPlusOne :: [Int] -> Int
firstPlusOne [] = 0
-- firstPlusOne (x : xs) = x + 1
firstPlusOne xs = head xs + 1

addFirstTwo :: [Int] -> Int
addFirstTwo [] = 0
addFirstTwo [x] = x
-- addFirstTwo (x1 : x2 : xs) = x1 + x2
addFirstTwo xs = head xs + head (tail xs)

firstDigit :: Int -> Int
firstDigit a = mod a 10
