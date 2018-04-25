package tictactoe;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public Player player1;
    public Player player2;
    public ArrayList<Move> moves = new ArrayList<>();
    
    private Scanner scanner = new Scanner(System.in);
    
    private int cordX, cordY;
            
    public void loadCords(boolean isThisPlayerOne)
    {
        int calculatedPosition;
        boolean cordsNotCorrect = true;
        Point point = new Point();
        while(cordsNotCorrect)
        {
            if(isThisPlayerOne)
            {
                System.out.println(player1.getName() + " Podaj wspolrzedna X: ");
                cordX = scanner.nextInt();
                System.out.println(player1.getName() + " Podaj wspolrzedna Y: ");
                cordY = scanner.nextInt();
            }
            else
            {
                System.out.println(player2.getName() + " Podaj wspolrzedna X: ");
                cordX = scanner.nextInt();
                System.out.println(player2.getName() + " Podaj wspolrzedna Y: ");
                cordY = scanner.nextInt();
            }
            calculatedPosition = cordX * 3 + cordY;
            cordsNotCorrect = checkPoint(calculatedPosition);
            if(cordsNotCorrect)
                System.out.println("To pole jest juz zaznaczone!");
            else
                moves.add(new Move(true, new Point(cordX, cordY)));
        }
    }
    private boolean checkPoint(int calculatedPosition)
    {
        Point xYCordinates;
        int indexOfMove;
        for(Move move : moves)
        {
           xYCordinates = move.getCoordinate();
           indexOfMove = xYCordinates.x * 3 + xYCordinates.y;
           if(indexOfMove == calculatedPosition)
               return true;
        }
        return false;
    }
    private char [] playerMoves(ArrayList<Move> moves)
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
    public void lookForWinner()
    {
        Move move;
        if (moves != null && !moves.isEmpty())
            move = moves.get(moves.size() - 1);
        else
            move = new Move(true, new Point(0, 0)); 
        if (move.isIsThisXPlayerMove())
            System.out.println("Gracz " + player1.getName() + " wygral!"); 
        else
            System.out.println("Gracz " + player2.getName() + " wygral!"); 
    }
}