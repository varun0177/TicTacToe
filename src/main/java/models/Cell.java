package models;

import enums.GameSymbol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cell {
    private int row;
    private int col;
    private GameSymbol gameSymbol;

}
