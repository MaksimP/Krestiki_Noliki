package org.hexlet.xo;

import org.hexlet.xo.player.Player;

public class GameController {

    private static final int DEFAULT_FIELD_SIZE = 3;

    private Field field;

    private Player playerOne;

    private Player playerTwo;

    private Player currentPlayer;

    private FieldController fieldController;

    private GameController gameController;

    private GameController(Player playerOne, Player playerTwo, int size) {
        this.field = new Field(size);
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        fieldController = new FieldController();
    }

    private GameController(Player playerOne, Player playerTwo) {
        this(playerOne, playerTwo, DEFAULT_FIELD_SIZE);
    }

    private boolean isAvailable(CellInfo cellInfo) {
        field.isAvailable(cellInfo);
    }

    private boolean figureChecking(Player playerOne, Player playerTwo) {
        CellState figureEmpty = CellState.EMPTY;
        CellState playerOneFigure = playerOne.getFigure();
        CellState playerTwoFigure = playerTwo.getFigure();
        if ((playerOneFigure != playerTwoFigure) && (playerOneFigure != figureEmpty && playerTwoFigure != figureEmpty)) {
            return true;
        }
        return false;
    }

    public int getSize() {
        return field.SIZE;
    }

    public CellState[][] getField() {
        return field.getField();
    }

    public Player currentPlayer() {
        if (this.currentPlayer == this.playerOne) {
            this.currentPlayer = this.playerTwo;
        } else {
            this.currentPlayer = this.playerOne;
        }
        return this.currentPlayer;
    }

    public void nextTurn(CellInfo cellInfo) {
        isAvailable(cellInfo);
        field.setCell(cellInfo);
        fieldController.checkWin(cellInfo.getFigure());
        currentPlayer();
    }

    public void abortGame() {
        this.gameController = null;
    }

    public void startGame(Player playerOne, Player playerTwo, GameStateListener listener) {
        if (figureChecking(playerOne, playerTwo)) {
            this.gameController = new GameController(playerOne, playerTwo);
        }
    }

    public void startGame(Player playerOne, Player playerTwo, int size, GameStateListener listener) {
        if (figureChecking(playerOne, playerTwo)) {
            this.gameController = new GameController(playerOne, playerTwo, size);
        }
    }

}