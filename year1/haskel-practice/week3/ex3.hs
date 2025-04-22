mult :: (Num a) => [a] -> a
-- `product` does the exact same thing
mult = foldr (*) 1

posList :: [Int] -> [Int]
posList = filter (> 0)

trueList :: [Bool] -> Bool
-- `and` does the exact same thing
trueList = foldr (&&) True

evenList :: [Int] -> Bool
evenList = trueList . map even

maxList :: (Ord a) => [a] -> a
-- `maximum` does the exact same thing
maxList (x : xs) = foldr max x xs

inRange :: Int -> Int -> [Int] -> [Int]
inRange a b = filter (\x -> x >= a && x <= b)

countPositives :: [Int] -> Int
countPositives = foldr (\x y -> if x > 0 then y + 1 else y) 0

myLength :: [a] -> Int
-- foldr version
myLength = foldr (\_ y -> y + 1) 0

-- map version
-- myLength = sum . map (const 1)

myMap :: (a -> b) -> [a] -> [b]
myMap f = foldr (\x xs -> f x : xs) []