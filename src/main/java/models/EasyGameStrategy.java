package models;

import java.util.List;

public class EasyGameStrategy implements GameStrategy {
    @Override
    public Move play(Board board){
        List<Cell> cells=board.getEmptyCells();
        int randomIndex= (int)(Math.random()*cells.size());
        Move move=new Move();
        move.setRow(cells.get(randomIndex).getRow());
        move.setCol(cells.get(randomIndex).getCol());
        return move;
    }
}
