squares :: [Integer] -> [Integer]
squares ns = [n * n | n <- ns]

sumOfSquares :: [Integer] -> Integer
sumOfSquares = foldr (\x acc -> acc + x * x) 0

nonNegative :: [Integer] -> Bool
nonNegative = any (> 0)

fminimumVal :: (Integer -> Integer) -> Integer -> Integer
fminimumVal f n = foldr1 (min . f) [0 .. n]

fallEqual :: (Integer -> Integer) -> Integer -> Bool
fallEqual f n = all (== f 0) [f x | x <- [1 .. n]]

fnonNegative :: (Integer -> Integer) -> Integer -> Bool
fnonNegative f n = all (> 3) [f x | x <- [0 .. n]]

fisIncreasing :: (Integer -> Integer) -> Integer -> Bool
-- not strictly increasing
fisIncreasing f n = and $ zipWith (<=) values (tail values)
  where
    values = map f [0 .. n]

twice :: (Integer -> Integer) -> Integer -> Integer
twice f = f . f

iter :: Integer -> (a -> a) -> a -> a
iter n f x
  | n == 0 = x
  | otherwise = iter (n - 1) f (f x)

powOftwo :: Integer -> Integer
powOftwo n = iter n (* 2) 1

-- ### BLOOD TYPE EXERCISE ###
data RhType = Positive | Negative

data ABOType = A | B | AB | O

type BloodType = (RhType, ABOType)

-- example patients
jackieSmith :: BloodType
jackieSmith = (Positive, AB)

abdullahAli :: BloodType
abdullahAli = (Negative, O)

yourMother :: BloodType
yourMother = (Positive, A)

tylerOne :: BloodType
tylerOne = (Negative, B)

rashidKarim :: BloodType
rashidKarim = (Positive, O)

-- implement displaying for rh, abo and bloodtype
showRhType :: RhType -> String
showRhType Positive = "+"
showRhType Negative = "-"

showABOType :: ABOType -> String
showABOType A = "A"
showABOType B = "B"
showABOType AB = "AB"
showABOType O = "O"

showBloodType :: BloodType -> String
showBloodType (rh, abo) = showRhType rh ++ showABOType abo

-- checks if a patient can donate to another patient
canDonateTo :: BloodType -> BloodType -> Bool
canDonateTo (donorRh, donorABO) (recipientRh, recipientABO) =
  rhCompatible donorRh recipientRh && aboCompatible donorABO recipientABO
  where
    rhCompatible Negative _ = True
    rhCompatible _ Negative = False
    rhCompatible _ _ = True

    aboCompatible O _ = True
    aboCompatible _ AB = True
    aboCompatible A A = True
    aboCompatible B B = True
    aboCompatible _ _ = False

-- ### END OF BLOOD TYPE EXERCISE ###

data Answer = Yes | No | Unknown

wonky :: Answer -> Answer
wonky Yes = No
wonky No = Unknown
wonky Unknown = Yes

-- shortest number of times wonky needs to be applied to get to get back
-- to the original answer is 3: wonky . wonky . wonky
shouldReturnItself :: Answer -> Answer
shouldReturnItself = iter 3 wonky

data Shape = Ellipse Float Float | Rectangle Float Float

circle :: Float -> Shape
circle r = Ellipse r r

area :: Shape -> Float
area (Ellipse r1 r2) = pi * r1 * r2
area (Rectangle w h) = w * h
