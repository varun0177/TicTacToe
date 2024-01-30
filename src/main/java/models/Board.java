package models;

import enums.GameSymbol;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Getter
@Setter
public class Board {
    private int size;
    List<List<Cell>> cells=new ArrayList<>();

    public Board(int row, int col) {
        List<Cell> columnCells= Collections.nCopies(col,new Cell());
        List<List<Cell>> rowCells=Collections.nCopies(row,columnCells);
        this.cells=rowCells;
    }
    public void printBoard(Board board){
        for(int i=0;i<cells.size();i++){
            for(int j=0;j<cells.size();j++){
                GameSymbol symbol=cells.get(i).get(j).getGameSymbol();
                if(symbol==null){
                    System.out.print(" | - | ");
                }
                else{
                    System.out.print("|" + cells.get(i).get(j).getGameSymbol()+ "|");
                }
            }
            System.out.println();
        }

    }

    public boolean isFilled(int row, int col) {
        if(cells.get(row).get(col).getGameSymbol()==null){
            return false;
        }
        return true;
    }

    public void update(int row, int col, GameSymbol gameSymbol) {
        cells.get(row).get(col).setGameSymbol(gameSymbol);
    }

    public List<Cell> getEmptyCells() {
        return cells.stream()
                .flatMap(List :: stream)
                .filter(cell -> cell.getGameSymbol()==null)
                .toList();
    }
}
