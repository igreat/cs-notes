isPrime :: Integer -> Bool
isPrime n
  | n <= 1 = False
  | otherwise = isPrime' n (n - 1)

isPrime' :: Integer -> Integer -> Bool
isPrime' _ 1 = True
isPrime' n x = ((n `mod` x) /= 0) && isPrime' n (x - 1)

iter :: Int -> (a -> a) -> a -> a
iter 0 _ = id
iter n f = f . iter (n - 1) f

quarProd :: [Integer] -> Integer
quarProd xs = foldr1 (\x acc -> acc * iter 2 square x) (xs ++ [1])

square :: (Num a) => a -> a
square x = x * x

prodInts :: Int -> IO ()
prodInts acc = do
  line <- getLine
  let x = read line :: Int
  if x /= 0
    then prodInts (acc * x)
    else putStrLn (show acc)