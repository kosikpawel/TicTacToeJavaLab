package tictactoe;

import java.awt.Point;

public class Move {
    private boolean isThisXPlayerMove;
    private Point coordinate;

    public Move(boolean isThisXPlayerMove, Point coordinate) {
        this.isThisXPlayerMove = isThisXPlayerMove;
        this.coordinate = coordinate;
    }

    public boolean isIsThisXPlayerMove() {
        return isThisXPlayerMove;
    }

    public Point getCoordinate() {
        return coordinate;
    }
    
    
}
