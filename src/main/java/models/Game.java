package models;

import enums.GameStatus;
import enums.GameSymbol;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class Game {
    private Board board;
    List<Player> players=new ArrayList<>();
    private int nextPlayerIndex=0;
    private boolean draw=false;
    private GameStatus gameStatus=GameStatus.Inprogress;
    public void makeMove(){
        Player player=getNextPlayer();
        Move move=player.play(board);
        if(board.isFilled(move.getRow(), move.getCol())){
            throw new RuntimeException("already filled");
        }
        board.getCells().get(move.getRow()).get(move.getCol()).setGameSymbol(player.getGameSymbol());
        if(isWon(board,player.getGameSymbol())){
            return;
        }
        if(draw==true){
            return;
        }
        nextPlayerIndex=(nextPlayerIndex+1)%getPlayers().size();
    }
    public boolean isWon(Board board, GameSymbol symbol){
        boolean isdraw=true;
        for(int i=0;i<board.getCells().get(0).size();i++){
            boolean changed=false;
            for(int j=0;j<board.getCells().size();j++){
                if(board.getCells().get(i).get(j).getGameSymbol()!=symbol){
                    changed=true;
                }
                if(board.getCells().get(i).get(j).getGameSymbol()==null){
                    isdraw=false;
                }
            }
            if(changed==false)
                return true;
        }
        if(isdraw==true){
            draw=true;
        }
        return false;
    }

    public Player getNextPlayer() {
      return players.get(nextPlayerIndex);
    }

    public static Builder getBuilder(){
        return new Builder();
    }
















    public static class Builder{
        private Game game;
        private Builder(){
            game=new Game();
        }
        public Builder boardSize(int row,int col){
            Board board1=new Board(row,col);
            game.setBoard(board1);
            return this;
        }
        public Builder addPlayers(Player player){
            game.getPlayers().add(player);
            return this;
        }
        public Game Build() throws Exception {
            if(!validate()){
                try {
                    throw  new Exception("extra players");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            return game;
        }
        public boolean validate(){
            if(game.getPlayers().size()>2) {
                return false;
            }
            return true;
        }
    }
}
