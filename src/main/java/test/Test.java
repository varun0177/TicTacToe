package test;

import enums.Difficulty;
import enums.GameStatus;
import enums.GameSymbol;
import models.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Game game;
        try {
            game = createGame();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Game Started");
        while(game.getGameStatus()== GameStatus.Inprogress){
            Player nextPlayer=game.getNextPlayer();
            System.out.println("Next move is of player" + nextPlayer.getGameSymbol());
            game.makeMove();
            game.getBoard().printBoard(game.getBoard());
            if(game.getGameStatus().equals(GameStatus.Draw)){
                System.out.println("Game DRAW. No Winner.");
            }
            if(game.getGameStatus().equals(GameStatus.Finished))
                System.out.println("Game has ended. Winner."+nextPlayer.getGameSymbol());
        }

    }
    private static Game createGame () throws Exception {
        HumanPlayer humanPlayer = HumanPlayer.builder()
                .name("Varun")
                .photo("hey")
                .mail("afafafa")
                .gameSymbol(GameSymbol.X)
                .build();
        BotPlayer botPlayer = BotPlayer.builder()
                .gameStrategy(new EasyGameStrategy())
                .difficultyLevel(Difficulty.Easy)
                .gameSymbol(GameSymbol.O)
                .build();
        Game game = Game.getBuilder()
                .boardSize(3, 3)
                .addPlayers(humanPlayer)
                .addPlayers(botPlayer)
                .Build();
        return game;
    }
}
