
package dk.easv.tictactoe.bll;


import java.util.Arrays;

import java.util.List;

/**
 * @author Thor J, Alex D, Nadja B, Morten B,
 */
public class GameBoard implements IGameBoard {
    List<Player> players = Arrays.asList(new Player(0,1, "X"), new Player(1,2, "O"));
    Player currentPlayer = players.get(0);
    Player previousPlayer = players.get(1);
    public int turn = 0;
    public int boardWidth = 3;
    public int boardHeight = 3;
    private final String[][] board = new String[boardWidth][boardHeight];

    public void switchPlayer() {
        if (turn % 2 == 0) {
            currentPlayer = players.get(0);
            previousPlayer = players.get(1);//player 1
            System.out.println("Switched to player 1:");
        } else {
            currentPlayer = players.get(1);
            previousPlayer = players.get(0);// player 2
            System.out.println("Switched to player 2:");
        }
    }

    public boolean isDraw(String[][] board) {
        for(int i = 0; i < boardWidth; i++) {
            for(int j = 0; j < boardHeight; j++) {
                if (board[i][j] == "") {
                    return false;
                }
            }
        }
        if(turn >=9 )
            return true;

        return false;
    }

    @Override
    public int getNextPlayer() {
        return currentPlayer.getPlayerNumber();
    }

    @Override
    public int getPlayerDisplay() {
        return currentPlayer.getPlayerDisplayNumber();
    }

    public boolean play(int col, int row) {
        if (col < 0 || col >= boardWidth || row < 0 || row >= boardHeight) {
            return false;
        }
        if (board[row][col] == null) {
            board[row][col] = currentPlayer.getSymbol();
            System.out.println("Placing Symbol: " + currentPlayer.getSymbol() + " at (" + row + ", " + col + ")");
            turn++;
            switchPlayer();

            return true;
        } else {
            return false;
        }
    }

    public boolean isGameOver() {
        if(turn >=9 )
            return true;
        if(isDraw(board)) {
            return getWinner() == -1;
        }
        return getWinner() != -1;
    }
    @Override
    public int getWinner() {

        for (int row = 0; row < boardHeight; row++) {
            if (board[row][0] != null && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                return previousPlayer.getPlayerNumber();
            }
        }
        for (int col = 0; col < boardWidth; col++) {
            if (board[0][col] != null && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return previousPlayer.getPlayerNumber();
            }
        }
        if (board[0][0] != null && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return previousPlayer.getPlayerNumber();
        }
        if(board[2][0] != null && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
            return previousPlayer.getPlayerNumber();
        }

        for (int row = 0; row < boardHeight; row++) {
            for (int col = 0; col < boardWidth; col++) {
                if (board[row][col] == null) {
                    return -1;
                }
            }
        }
        return -1;
    }

    public void newGame() {

        //private char[][] board = new char[3][3];
        //loop, der nulstiller spilbrættet til nyt spil - A
        for (int row = 0; row < boardHeight; row++) {
            for (int col = 0; col < boardWidth; col++) {
                board[row][col] = null;
            }
        }
        currentPlayer = players.get(0);
        previousPlayer = players.get(1);
        turn = 0;
    }

    @Override
    public String[][] getBoard() {
        return board;
    }
}
//hej