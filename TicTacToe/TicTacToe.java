import Model.*;
import java.util.*;
import javafx.util.Pair;

public class TicTacToe {
    Board gameBoard;
    Deque<Player>players;
    public void initialize(){
        players=new LinkedList<>();
        PlayingPieceO naughtsPiece=new PlayingPieceO();
        Player player1=new Player("Player1",naughtsPiece);
        players.add(player1);
        PlayingPieceX crossPiece=new PlayingPieceX();
        Player player2=new Player("Player2",crossPiece);
        players.add(player2);
        gameBoard=new Board(3);
    }
    public String startGame(){
        boolean noWinner=true;
        while(noWinner){
            Player playerTurn = players.removeFirst();
            gameBoard.printBoard();
            List<Pair<Integer,Integer>> freeSpaces=gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner=false;
                continue;
            }
            System.out.print("Hey! "+playerTurn.getName()+" Enter row,column (0 based indexing) ");
            Scanner inputScanner = new Scanner(System.in);
            String[] values=inputScanner.nextLine().split(",");
            int row=Integer.valueOf(values[0]);
            int column=Integer.valueOf(values[1]);
            if(row>=0&&row<=2&&column>=0&&column<=2){
                if(!gameBoard.addPiece(row,column, playerTurn.getPlayingPiece())){
                    System.out.println("This position is already filled");
                    players.addFirst(playerTurn);
                    continue;
                }
                players.add(playerTurn);
                boolean winner=isThereWinner(row,column,playerTurn.getPlayingPiece().pieceType);
                if(winner){
                    return playerTurn.getName();
                }
            }
            else {
                System.out.println("Please enter valid positions");
                players.addFirst(playerTurn);
            }
        }
        return "tie";
    }
    public boolean isThereWinner(int row, int column,PieceType pieceType){
        boolean rowWise=true;
        boolean columnWise=true;
        boolean diagonalWise=true;
        boolean antiDiagonalWise=true;

        for(int i=0;i<gameBoard.size; i++){
            if(gameBoard.board[row][i]==null||gameBoard.board[row][i].pieceType != pieceType){
                rowWise=false;
            }
        }

        for(int i=0;i<gameBoard.size; i++){
            if(gameBoard.board[i][column]==null||gameBoard.board[i][column].pieceType != pieceType){
                columnWise=false;
            }
        }

        for(int i=0;i<gameBoard.size; i++){
            if(gameBoard.board[i][i]==null||gameBoard.board[i][i].pieceType != pieceType){
                diagonalWise=false;
            }
        }

        for(int i=0,j=gameBoard.size-1;i<gameBoard.size; i++,j--){
            if(gameBoard.board[i][j]==null||gameBoard.board[i][j].pieceType != pieceType){
                antiDiagonalWise=false;
            }
        }

        return rowWise||columnWise||diagonalWise||antiDiagonalWise;
    }
}
