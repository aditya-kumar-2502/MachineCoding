public class Board {
    private char[][] board;
    int size;

    public Board(){
        size = 3;
        board = new char[size][size];
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                board[i][j] = '-';
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == '-';
    }

    public void placeMove(int row, int col, char symbol) {
        if (isCellEmpty(row, col)) {
            board[row][col] = symbol;
        } else {
            System.out.println("Cell is already occupied. Try again.");
        }
    }

    public boolean hasWon(char symbol) {
        // Check rows
        for (int i = 0; i < size; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < size; i++) {
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        return false;
    }

    boolean isFull(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

}
