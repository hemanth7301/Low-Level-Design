import java.util.Deque;
import java.util.LinkedList;

public class Game {

    Deque<Player> players = new LinkedList<>();
    Dice dice;
    Board board;
    Player winner;

    public Game() {
        this.board = new Board(10, 5, 5);
        this.dice = new Dice(1);
        addPlayers();
        winner = null;
    }

    public void addPlayers() {
        Player player1 = new Player("P1", 0);
        Player player2 = new Player("P2", 0);
        players.add(player1);
        players.add(player2);
    }

    public void startGame() {
        while (winner == null) {
            Player playerTurn = findPlayerTurn();
            System.out.println("Player : " + playerTurn.id + " Current Position : " + playerTurn.playerPosition);
            int newPosition = playerTurn.playerPosition += dice.rollDice();
            playerTurn.playerPosition = jumpCheck(newPosition);
            System.out.println("Player : " + playerTurn.id + " New Position : " + playerTurn.playerPosition);

            if (playerTurn.playerPosition >= board.cells.length * board.cells.length - 1) {
                winner = playerTurn;
            }
        }
        System.out.println("Winner is :" + winner.id);
    }

    public Player findPlayerTurn() {
        Player playerTurn = players.removeFirst();
        players.addLast(playerTurn);
        return playerTurn;
    }

    public int jumpCheck(int playerPosition) {
        if (playerPosition >= board.cells.length * board.cells.length - 1) {
            return playerPosition;
        }
        Cell cell = board.getCells(playerPosition);
        if (cell.jump != null && cell.jump.start == playerPosition) {
            String jumpBy = (cell.jump.end > playerPosition) ? "Ladder" : "Snake";
            System.out.println("Jump done by " + jumpBy);
            return cell.jump.end;
        }
        return playerPosition;
    }
}
