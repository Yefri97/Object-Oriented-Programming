#include <bits/stdc++.h>
using namespace std;

const int INF = 100;
const int MAX_SIZE = 200;

int size_board;
int board[MAX_SIZE + 10][MAX_SIZE + 10];
int ships[MAX_SIZE + 10];
int sum_row[MAX_SIZE + 10], sum_col[MAX_SIZE + 10];

void showBoard() {
  for (int i = 0; i < size_board; i++) {
    for (int j = 0; j < size_board; j++)
      cout << board[i][j];
    cout << endl;
  }
  cout << endl;
}

bool SAT() {
  for (int i = 0; i < size_board; i++)
    if (sum_row[i]) return false;
  for (int i = 0; i < size_board; i++)
    if (sum_col[i]) return false;
  for (int i = 0; i <= MAX_SIZE; i++)
    if (ships[i]) return false;
  return true;
}

bool Pruning(int r, int c) {
  for (int i = 0; i < size_board; i++)
    if (sum_row[i] < 0) return true;
  for (int i = 0; i < size_board; i++)
    if (sum_col[i] < 0) return true;
  return false;
}

bool Backtracking(int row, int col) {
  if (Pruning(row, col)) return false;
  if (row == size_board && col == 0) {
    if (!SAT()) return false;
    return true;
  }
  
  int next_row = (col == size_board - 1)? row + 1 : row, next_col = (col == size_board - 1)? 0 : col + 1;  
  
  if (board[row][col] == 1) {
    if (Backtracking(next_row, next_col)) return true;
    return false;
  }

  for (int size_ship = 0, free_squares; size_ship <= MAX_SIZE; size_ship++) {
    if (ships[size_ship]) {

      //Posición horizontal
      free_squares = 0;
      for (int l = 0; l < size_ship; l++) {
        int square = col + l;
        if (square == size_board) break;
        if (board[row][square] == 0) free_squares++;
      }
      if (free_squares == size_ship) {
        for (int l = 0; l < size_ship; l++) {
          board[row][col + l] = 1;
        }
        ships[size_ship]--;
        sum_row[row] -= size_ship;
        for (int l = 0; l < size_ship; l++) sum_col[col + l]--;
        if (Backtracking(next_row, next_col)) return true;
        for (int l = 0; l < size_ship; l++) {
          board[row][col + l] = 0;
        }
        ships[size_ship]++;
        sum_row[row] += size_ship;
        for (int l = 0; l < size_ship; l++) sum_col[col + l]++;
      }

      if (size_ship < 2) continue;
      //Posición Vertical
      free_squares = 0;
      for (int l = 0; l < size_ship; l++) {
        int square = row + l;
        if (square == size_board) break;
        if (board[square][col] == 0) free_squares++;
      }
      if (free_squares == size_ship) {
        for (int l = 0; l < size_ship; l++) {
          board[row + l][col] = 1;
        }
        ships[size_ship]--;
        sum_col[col] -= size_ship;
        for (int l = 0; l < size_ship; l++) sum_row[row + l]--;
        if (Backtracking(next_row, next_col)) return true;
        for (int l = 0; l < size_ship; l++) {
          board[row + l][col] = 0;
        }
        ships[size_ship]++;
        sum_col[col] += size_ship;
        for (int l = 0; l < size_ship; l++) sum_row[row + l]++;
      }
    }
  }
  return false;
}

int main() {
  int num_ships; cin >> size_board >> num_ships;
  memset(ships, 0, sizeof ships); ships[0] = size_board * size_board;
  for (int i = 0; i < num_ships; i++) {
    int size_ship; cin >> size_ship;
    ships[size_ship]++;
    ships[0] -= size_ship;
  }
  for (int i = 0; i < size_board; i++)
    cin >> sum_row[i];
  for (int i = 0; i < size_board; i++)
    cin >> sum_col[i];
  memset(board, 0, sizeof board);
  Backtracking(0, 0);
  showBoard();
  return 0;
}