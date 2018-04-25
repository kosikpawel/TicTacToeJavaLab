package tictactoe;

import java.awt.Point;
import java.util.ArrayList;


public class Commentator implements Printable{
    private String playerOneName;
    private String playerTwoName;

    public Commentator(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }
    
    @Override
    public void print(ArrayList<Move> moves) {
        Move move;
        if (moves != null && !moves.isEmpty())
            move = moves.get(moves.size() - 1);
        else
            move = new Move(true, new Point(0, 0)); 
        
        if(move.isIsThisXPlayerMove())
            System.out.println("Gracz " + playerOneName + " postawil znak X na polu " + move.getCoordinate()); 
        else
            System.out.println("Gracz " + playerTwoName + " postawil znak O na polu " + move.getCoordinate()); 
    }
    
}
