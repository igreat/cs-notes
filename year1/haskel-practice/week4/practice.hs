-- practice, mostly repeated stuff I already did in ex4.hs

import Control.Monad qualified
import Data.List
import Test.QuickCheck hiding (Negative, Positive)

evalRPN :: (Num a, Read a) => String -> a
evalRPN = head . foldl procStack [] . words

procStack :: (Num a, Read a) => [a] -> String -> [a]
procStack (x : y : ys) "*" = (y * x) : ys
procStack (x : y : ys) "+" = (y + x) : ys
procStack (x : y : ys) "-" = (y - x) : ys
procStack xs numString = read numString : xs

type Matrix = [[Int]]

uniform :: [Int] -> Bool
uniform [] = True
uniform xs = all (== head xs) (tail xs)

valid :: Matrix -> Bool
valid [] = False
valid (x : xs) = not (null x) && uniform (map length (x : xs))

matrixWidth :: Matrix -> Int
matrixWidth xss = length (head xss)

matrixHeight :: Matrix -> Int
matrixHeight = length

plusM :: Matrix -> Matrix -> Matrix
plusM m n
  | ok = zipWith (zipWith (+)) m n
  where
    ok =
      valid m
        && valid n
        && matrixWidth m == matrixWidth n
        && matrixHeight m == matrixHeight n

reverseUnZip = uncurry ($)

-- IO STUFF

greet :: IO ()
greet = do
  putStrLn "What is your name?"
  name <- getLine
  putStrLn ("Hello " ++ name ++ ".")

-- redoing lab sheet 4 for practice
squares = map (^ 2)

sumSquares = sum . squares

allPositive :: [Integer] -> Bool
allPositive = all (> 0)

minFunctionValue :: (Ord b) => (Integer -> b) -> Integer -> b
minFunctionValue f n = minimum (map f [0 .. n])

functionValuesEqual :: (Eq b) => (Integer -> b) -> Integer -> Bool
functionValuesEqual f n = all ((== f 0) . f) [1 .. n]

allPositiveFunction f n = allPositive $ map f [0 .. n]

isMonotonicIncreasing :: (Integer -> Integer) -> Integer -> Bool
isMonotonicIncreasing f n = and $ zipWith (<=) values (tail values)
  where
    values = map f [0 .. n]

twice :: (a -> a) -> a -> a
twice f = f . f

iter :: (a -> a) -> Integer -> a -> a
iter f 1 = f
iter f n = f . iter f (n - 1)

powerOfTwo :: Integer -> Integer
powerOfTwo n = iter (* 2) n 1

-- ### REDOING BLOOD TYPE EXERCISE ###

data ABOType = A | B | AB | O deriving (Show)

data RhType = Positive | Negative

instance Show RhType where
  show Positive = "+"
  show Negative = "-"

type BloodType = (RhType, ABOType)

ahmedBloodType = (Positive, A)

aliBloodType = (Negative, B)

ggBloodType = (Positive, AB)

yourMotherBloodType = (Negative, O)

yourSisterBloodType = (Negative, AB)

showRh :: RhType -> String
showRh Positive = "+"
showRh Negative = "-"

showABO :: ABOType -> String
showABO A = "A"
showABO B = "B"
showABO AB = "AB"
showABO O = "O"

showBloodType :: BloodType -> String
showBloodType (rh, abo) = showABO abo ++ showRh rh

canDonateTo :: BloodType -> BloodType -> Bool
canDonateTo (rhFrom, aboFrom) (rhTo, aboTo) = rhCompatible rhFrom rhTo && aboCompatible aboFrom aboTo
  where
    rhCompatible Negative _ = True
    rhCompatible _ Negative = False
    rhCompatible _ _ = True

    aboCompatible O _ = True
    aboCompatible _ AB = True
    aboCompatible A A = True
    aboCompatible B B = True
    aboCompatible _ _ = False

-- ### EXAM 2018 PROBLEMS ###
take' :: Int -> [a] -> [a]
take' _ [] = []
take' n (x : xs)
  | n > 0 = x : take' (n - 1) xs
  | otherwise = []

divisors :: Int -> [Int]
divisors n = [x | x <- [1 .. n], n `mod` x == 0]

isPrime :: Int -> Bool
isPrime n
  | n <= 1 = False
  | otherwise = null [x | x <- [2 .. (n `div` 2)], n `mod` x == 0]

cuber :: [Int] -> Int
cuber = sum . map (^ 3)

mono :: (Int -> Int) -> Int -> Bool
-- mono f n = and $ zipWith (\x y -> y > x) values (tail values)
--   where
--     values = map f [0 .. n]
mono f n = all (\x -> f (x - 1) < f x) [1 .. n]

snoc :: a -> [a] -> [a]
snoc x xs = xs ++ [x]

rev :: [a] -> [a]
rev = foldr snoc []

iter' :: Int -> (a -> a) -> a -> a
iter' 1 f = f
iter' n f = f . iter' (n - 1) f

iter'' :: Int -> (a -> a) -> a -> a
iter'' n f = foldr (.) f (replicate (n - 1) f)

data NTree = NilTree | Node NTree Int NTree

ntSum :: NTree -> Int
ntSum NilTree = 0
ntSum (Node l a r) = a + ntSum l + ntSum r

ntList :: NTree -> [Int]
ntList NilTree = []
ntList (Node l a r) = ntList l ++ [a] ++ ntList r

fac1 :: Int -> Int
fac1 0 = 1
fac1 n = n * fac1 (n - 1)

fac2 :: Int -> Int
fac2 n = foldr (*) 1 [1 .. n]

prop_Fac_Product :: Int -> Property
prop_Fac_Product n =
  (n >= 0)
    ==> fac1 n
    == fac2 n
    && fac1 n == product [1 .. n]

testInts :: IO ()
testInts = do
  line <- getLine
  let n = read line :: Int
  if n /= 0
    then do
      putStrLn $ show (even n)
      testInts
    else return ()

splitHalf xs = splitHalf' [] xs (length xs `div` 2)

splitHalf' xs ys 0 = (reverse xs, ys)
splitHalf' xs [] _ = (xs, [])
splitHalf' xs (y : ys) n = splitHalf' (y : xs) ys (n - 1)