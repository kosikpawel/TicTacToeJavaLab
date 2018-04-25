package tictactoe;

public class Player {
   private String name;
   
   // Only 2 options "X" and "O"
   private char playerSign;

    public Player(String name, char playerSign) {
        this.name = name;
        this.playerSign = playerSign;
    }

    public String getName() {
        return name;
    }

    public char getPlayerSign() {
        return playerSign;
    }
    
}
