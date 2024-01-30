package models;

import enums.Difficulty;
import enums.GameSymbol;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@Setter
public class BotPlayer extends Player{
    private Difficulty difficultyLevel;
    private GameStrategy gameStrategy;

    public BotPlayer(GameSymbol gameSymbol) {
        super(gameSymbol);
    }

    @Override
    public Move play(Board board) {
        return gameStrategy.play(board);
    }
}
