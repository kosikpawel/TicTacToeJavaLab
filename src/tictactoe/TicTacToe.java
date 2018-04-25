package tictactoe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        Board board = new Board();
        Commentator commentator;
        
        String name1, name2;
        boolean gameContinues = true;
        boolean winner = false;
        
        System.out.println("Witaj w grze kolko i krzyzyk\nPodaj imie pierwszego gracza: ");
        name1 = scanner.next();
        System.out.println("Podaj imie drugiego gracza: ");
        name2 = scanner.next();        
        game.player1 = new Player(name1, 'X');
        game.player2 = new Player(name2, 'O');
        
        commentator = new  Commentator(game.player1.getName(), game.player2.getName());
        
        while(gameContinues)
        {
            game.loadCords(true);
            board.print(game.moves);
            commentator.print(game.moves);
            winner = board.checkForWinner(game.moves);
            if(winner)
            {
                game.lookForWinner();
                return;
            }
            game.loadCords(false);
            board.print(game.moves);
            commentator.print(game.moves);
            winner = board.checkForWinner(game.moves);
            if(winner)
            {
                game.lookForWinner();
                return;
            }
            if(game.moves.size() > 8)
            {
                System.out.println("Remis");
                return;
            }
        }
    }
}
