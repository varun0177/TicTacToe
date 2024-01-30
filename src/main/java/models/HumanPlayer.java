package models;

import enums.GameSymbol;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class HumanPlayer extends Player{
    private String name;
    private String mail;
    private String photo;



    @Override
    public Move play(Board board) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the row number in board :");
        int row=sc.nextInt();
        System.out.println("Enter the col number in board :");
        int col=sc.nextInt();
        Move move=new Move();
        move.setCol(col);
        move.setRow(row);
        return move;
    }
}
