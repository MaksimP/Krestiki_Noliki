package org.hexlet.xo;

import org.hexlet.xo.player.Player;

public class GameController {
    private GameType gameType;

    /*
      @param instance of org.hexlet.xo.GameType
     */
    public void setGameType(GameType gameType) {
        this.gameType = gameType;

    }


    /*
    @return org.hexlet.xo.GameType
     */
    public GameType getGameType() {
        return gameType;
    }

    /*
       @param instance of class implemented Interface Player
     */
    private void startGame(Player playerone, Player playertwo, GameStateListener stateListener) {

    }

    public void gamePrepare(GameType type) {

    }

}
