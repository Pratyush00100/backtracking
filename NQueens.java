package backtracking;


    public class NQueens {
        private int count = 0;
    
        public int totalNQueens(int n) {
            boolean[] cols = new boolean[n];           
            boolean[] diagonals = new boolean[2 * n];   
            boolean[] antiDiagonals = new boolean[2 * n]; 
    
            placeQueens(0, n, cols, diagonals, antiDiagonals);
            return count;
        }
    
        private void placeQueens(int row, int n, boolean[] cols, boolean[] diagonals, boolean[] antiDiagonals) {
            if (row == n) { 
                count++;
                return;
            }
    
            for (int col = 0; col < n; col++) {
                int diagIndex = row - col + n;            
                int antiDiagIndex = row + col;           
    
                if (cols[col] || diagonals[diagIndex] || antiDiagonals[antiDiagIndex]) {
                    continue; 
                }
    
                cols[col] = diagonals[diagIndex] = antiDiagonals[antiDiagIndex] = true; 
                placeQueens(row + 1, n, cols, diagonals, antiDiagonals); 
                cols[col] = diagonals[diagIndex] = antiDiagonals[antiDiagIndex] = false; 
            }
        }
    
        public static void main(String[] args) {
            NQueens solution = new NQueens();
            int n = 4;
            System.out.println("Number of solutions for " + n + "-Queens: " + solution.totalNQueens(n)); 
        }
    }
    

