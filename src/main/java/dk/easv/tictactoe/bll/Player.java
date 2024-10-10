package dk.easv.tictactoe.bll;

public class Player {
    public int playerNumber;
    public int playerDisplayNumber;
    private String symbol;



    public Player(int playerNumber, int playerDisplayNumber, String symbol) {
        this.playerDisplayNumber = playerDisplayNumber;
        this.playerNumber = playerNumber;
        this.symbol = symbol;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
    public String getSymbol() {
        return symbol;
    }
    public int getPlayerDisplayNumber() {
        return playerDisplayNumber;
    }
}