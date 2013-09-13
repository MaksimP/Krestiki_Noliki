package org.hexlet.xo;

import org.hexlet.xo.exception.CellNotAvailableException;
import org.hexlet.xo.exception.InvalidCellCoordinatesException;
import org.hexlet.xo.player.Player;

public class GameController {

    private Player playerOne;

    private Player playerTwo;

    private Player currentPlayer;

    private FieldController fieldController;

    private GameController() {
        fieldController = new FieldController();
    }

    private boolean isAvailable(CellInfo cellInfo) throws InvalidCellCoordinatesException {
        return fieldController.isAvailable(cellInfo);
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
        return fieldController.getFieldSize();
    }

    public CellState[][] getField() {
        return fieldController.getField();
    }

    public Player currentPlayer() {

        return this.currentPlayer;
    }

    public void nextTurn(CellInfo cellInfo) throws InvalidCellCoordinatesException, CellNotAvailableException {
        isAvailable(cellInfo);
        fieldController.setCell(cellInfo);
        fieldController.checkWin(cellInfo.getFigure());
        currentPlayer();
    }

   /* public void abortGame() {
        fieldController.
    }*/

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

    private void switchPlayers() {
        if (currentPlayer == playerOne) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
    }

}