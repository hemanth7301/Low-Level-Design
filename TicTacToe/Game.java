public class Game{
    public static void  main( String args[]){
        System.out.println("This is a 3*3 Tic Tac Toe Game");
        TicTacToe game=new TicTacToe();
        game.initialize();
        String winner=game.startGame();
        if(winner=="tie"){
            System.out.println("Its a Tie Game");
        }
        else System.out.println("And the winner is "+ winner);
    }
}