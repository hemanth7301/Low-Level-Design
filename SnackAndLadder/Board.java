import java.util.Random;

public class Board {

    Cell [][] cells;
    

    public Board(int boardSize, int noOfSnakes,int noOfLadders) {
        intializeCells(boardSize);
        addSnakesAndLadders(cells,noOfSnakes,noOfLadders);
    }

    public void intializeCells(int boardSize){
        cells = new Cell[boardSize][boardSize];
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                Cell cellObj= new Cell();
                cells[i][j]=cellObj;
            }
        }
    }

    public void addSnakesAndLadders(Cell[][] cells,int noOfSnakes,int noOfLadders){
        while(noOfSnakes>0){
            int snakeHead= 1+new Random().nextInt(cells.length*cells.length-1);
            int snakedTail=1+new Random().nextInt(cells.length*cells.length-1);;
            if(snakeHead<=snakedTail)continue;
            Jump snakeObj=new Jump();
            snakeObj.start=snakeHead;
            snakeObj.end=snakedTail;
            Cell cell=getCells(snakeHead);
            cell.jump=snakeObj;
            noOfSnakes--;
        }
        while(noOfLadders>0){
            int ladderHead= 1+new Random().nextInt(cells.length*cells.length-1);
            int ladderTail=1+new Random().nextInt(cells.length*cells.length-1);;
            if(ladderHead>=ladderTail)continue;
            Jump snakeObj=new Jump();
            snakeObj.start=ladderHead;
            snakeObj.end=ladderTail;
            Cell cell=getCells(ladderHead);
            cell.jump=snakeObj;
            noOfLadders--;
        }
    }

    public Cell getCells(int playersPosition){
        int row=playersPosition/cells.length;
        int column=playersPosition%cells.length;
        return cells[row][column];
    }

}
