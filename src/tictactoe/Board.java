package tictactoe;

import java.awt.Point;
import java.util.ArrayList;

public class Board implements Printable{

    @Override
    public void print(ArrayList<Move> moves) {
        char[] playersMovesForPrint = playersMovesToArray(moves);

        for(int i=0; i<9; i++)
        {
            if(i%3 == 0 && i != 0)
            {
                System.out.println("");
                System.out.println("-----");
            }
            if(i == 2 || i == 5 || i == 8)     
                System.out.print(playersMovesForPrint[i]);
            else
                System.out.print(playersMovesForPrint[i] + "|");
        }
        System.out.println("");
    }  
    public boolean checkForWinner(ArrayList<Move> moves)
    {
        if(moves.size() > 4)
        {
            char[] playersMovesToCheck = playersMovesToArray(moves);
            
            // Horizontal
            if(playersMovesToCheck[0] == playersMovesToCheck[1]
                    && playersMovesToCheck[1] == playersMovesToCheck[2] && playersMovesToCheck[0] != '\u0000')
                return true;
            else if(playersMovesToCheck[3] == playersMovesToCheck[4]
                    && playersMovesToCheck[4] == playersMovesToCheck[5] && playersMovesToCheck[3] != '\u0000')
                return true;
            else if(playersMovesToCheck[6] == playersMovesToCheck[7]
                    && playersMovesToCheck[7] == playersMovesToCheck[8] && playersMovesToCheck[6] != '\u0000')
                return true;
            // Vertical
            else if(playersMovesToCheck[0] == playersMovesToCheck[3]
                    && playersMovesToCheck[3] == playersMovesToCheck[6] && playersMovesToCheck[0] != '\u0000')
                return true;
            else if(playersMovesToCheck[1] == playersMovesToCheck[4]
                    && playersMovesToCheck[4] == playersMovesToCheck[7] && playersMovesToCheck[1] != '\u0000')
                return true;
            else if(playersMovesToCheck[2] == playersMovesToCheck[5]
                    && playersMovesToCheck[5] == playersMovesToCheck[8] && playersMovesToCheck[2] != '\u0000')
                return true;
            // Across
            else if(playersMovesToCheck[0] == playersMovesToCheck[4]
                    && playersMovesToCheck[4] == playersMovesToCheck[8] && playersMovesToCheck[0] != '\u0000')
                return true;
            else if(playersMovesToCheck[2] == playersMovesToCheck[4]
                    && playersMovesToCheck[4] == playersMovesToCheck[6] && playersMovesToCheck[2] != '\u0000')
                return true;
        }
        return  false;
    }
    private char [] playersMovesToArray(ArrayList<Move> moves)
    {
        char[] playersMovesArray = new char[9];
        Point xYCordinates;
        int indexOfMove;
        
        for(Move move : moves)
        {
            xYCordinates = move.getCoordinate();
            indexOfMove = xYCordinates.x * 3 + xYCordinates.y;
            
            if(move.isIsThisXPlayerMove())
                playersMovesArray[indexOfMove] = 'X';
            else
                playersMovesArray[indexOfMove] = 'O';
        }
        return playersMovesArray;
    }
            
}
