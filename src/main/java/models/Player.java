package models;

import enums.GameSymbol;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public abstract class Player {
    private GameSymbol gameSymbol;

    protected Player(GameSymbol gameSymbol) {
        this.gameSymbol = gameSymbol;
    }
    public abstract Move play(Board board);
}
