
# def isSafe(board, row, col,H):
#     for i in range(col):
#         if(board[row][i] == 1):
#             return False
    
#     for i,j in zip(range(row,H), range(col,-1,-1)):
#         if(board[i][j] == 1):
#             return False
#     for i,j in zip(range(row,-1,-1), range(col,-1,-1)):
#         if(board[i][j] == 1):
#             return False
#     return False

# def HVQueensRooks(board,col,H):
#     if(col >= H):
#         return True
#     for i in range(H):
#         if(isSafe(board, i, col,H)):
#             board[i][col] = 1
#             if(HVQueensRooks(board,col+1,H)):
#                 return True
#             board[i][col] = 0
#     return False

# def solveHV(H,V):
#     board = [[0 for _ in range(V)] for _ in range(H)]
#     HVQueensRooks(board,0,H)
def countQueens(Q, r, n,H):
  #mengembalikan banyaknya peletakan Queen yang legal jika Q[1..r-1] sudah terisi 
  if r == H:
    return 1
  else:
    result = 0
    for j in range(n):
      legal = True
      for i in range(r):
        if Q[i] != None and Q[i] == j or Q[i] == j+r-i or Q[i] == j-r+i:
          legal = False
      if legal:
        Q[r] = j
        print(Q)
        result = result + countQueens(Q, r+1, n,H)
    return result

def nQueen(H,V):
  Q = [0 for _ in range(min(H,V))]
  print(countQueens(Q,0,min(H,V),H))
def main():
    nQueen(8,4)

if __name__ == "__main__":
    main()