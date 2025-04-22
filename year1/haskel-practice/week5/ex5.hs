-- Nim Game

data Player = Player1 | Player2 deriving (Eq)

instance Show Player where
  show :: Player -> String
  show Player1 = "1"
  show Player2 = "2"

data Heap = A | B | C

instance Show Heap where
  show A = "A"
  show B = "B"
  show C = "C"

type Board = (Int, Int, Int)

-- checks if a player has won
isWinning :: Board -> Bool
isWinning (0, 0, 0) = True
isWinning _ = False

-- checks if a move is valid
isValid :: Board -> Heap -> Int -> Bool
isValid (a, _, _) A n = n <= a
isValid (_, b, _) B n = n <= b
isValid (_, _, c) C n = n <= c

-- makes a move
move :: Board -> Heap -> Int -> Board
move (a, b, c) A n = (a - n, b, c)
move (a, b, c) B n = (a, b - n, c)
move (a, b, c) C n = (a, b, c - n)

-- not random, but goes to the first valid move
computerMove :: Board -> (Heap, Int)
computerMove (a, b, c)
  | a > 0 = (A, 1)
  | b > 0 = (B, 1)
  | c > 0 = (C, 1)

-- gets the next player
nextPlayer :: Player -> Player
nextPlayer Player1 = Player2
nextPlayer Player2 = Player1

-- gets the heap from a char
heapFromChar :: Char -> Heap
heapFromChar 'A' = A
heapFromChar 'B' = B
heapFromChar 'C' = C

-- checks if a heap is valid
isValidHeap :: Char -> Bool
isValidHeap 'A' = True
isValidHeap 'B' = True
isValidHeap 'C' = True
isValidHeap _ = False

-- plays the game
play :: Board -> Player -> IO ()
play board player = do
  putStrLn ("Player " ++ show player ++ "'s turn")
  putStrLn "Enter a heap: "
  heap <- getLine
  if not (isValidHeap (head heap))
    then do
      putStrLn "Invalid heap!"
      play board player
    else do
      putStrLn "Enter a number of stones: "
      stones <- getLine
      let heap' = heapFromChar (head heap)
      let stones' = read stones :: Int
      if isValid board heap' stones'
        then do
          let board' = move board heap' stones'
          print board'
          if isWinning board'
            then putStrLn ("Player " ++ show player ++ " wins!")
            else play board' (nextPlayer player)
        else do
          putStrLn "Invalid move!"
          play board player

-- Nim game with computer
playComputer :: Board -> Player -> IO ()
playComputer board player = do
  putStrLn ("Player " ++ show player ++ "'s turn")
  if player == Player2
    then do
      let (heap, stones) = computerMove board
      putStrLn ("Computer chose heap " ++ show heap ++ " with " ++ show stones ++ " stones")
      let board' = move board heap stones
      print board'
      if isWinning board'
        then putStrLn ("Player " ++ show player ++ " wins!")
        else playComputer board' (nextPlayer player)
    else do
      putStrLn "Enter a heap: "
      heap <- getLine
      if not (isValidHeap (head heap))
        then do
          putStrLn "Invalid heap!"
          playComputer board player
        else do
          putStrLn "Enter a number of stones: "
          stones <- getLine
          let heap' = heapFromChar (head heap)
          let stones' = read stones :: Int
          if isValid board heap' stones'
            then do
              let board' = move board heap' stones'
              print board'
              if isWinning board'
                then putStrLn ("Player " ++ show player ++ " wins!")
                else playComputer board' (nextPlayer player)
            else do
              putStrLn "Invalid move!"
              playComputer board player

-- END OF NIM GAME

-- simple excercises

-- factorial
fac :: Int -> Int
fac 0 = 1
fac n = n * fac (n - 1)

-- fibonacci
fib :: Int -> Int
fib 0 = 0
fib 1 = 1
fib n = fib (n - 1) + fib (n - 2)