import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] p1Input = sc.nextLine().split(" ");
        String[] p2Input = sc.nextLine().split(" ");

        Player player1 = new Player(p1Input[1], p1Input[0].charAt(0));
        Player player2 = new Player(p2Input[1], p2Input[0].charAt(0));

        Player currentPlayer = player1;

        Board board = new Board();
        board.printBoard();

        boolean gameOver = false;

        while(sc.hasNextLine()){
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("exit")) break;
            if (gameOver) continue;
            String[] tokens = line.split(" ");
            if (tokens.length != 2) {
                System.out.println("Invalid Move");
                continue;
            }

            int row, col;
            try {
                row = Integer.parseInt(tokens[0]) - 1;
                col = Integer.parseInt(tokens[1]) - 1;
            } catch (Exception e) {
                System.out.println("Invalid Move");
                continue;
            }
            if (row < 0 || row >= 3 || col < 0 || col >= 3 || !board.isCellEmpty(row, col)) {
                System.out.println("Invalid Move");
                continue;
            }

            board.placeMove(row, col, currentPlayer.symbol);
            board.printBoard();

            if (board.hasWon(currentPlayer.symbol)) {
                System.out.println(currentPlayer.name + " wins!");
                gameOver = true;
            } else if (board.isFull()) {
                System.out.println("Game is a draw!");
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }

        }

    }
}