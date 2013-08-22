import Player.Player;

public class GameController
{
    private GameType gameType;

    /*
      @param instance of GameType
     */
    public void setGameType(GameType gameType)
    {
        this.gameType = gameType;

    }


     /*
     @return GameType
      */
    public GameType getGameType()
    {
        return gameType;
    }

    /*
       @param instance of class implemented Interface Player
     */
    private void startGame(Player playerone,Player playertwo)
    {

    }

}
