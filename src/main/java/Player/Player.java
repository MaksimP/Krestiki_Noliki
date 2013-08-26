package main.java.Player;

import main.java.*;

public abstract class Player {

    public static final int MAX_SIZE_FIELD = 4;

    public static final int ZERO = 0;

    private String name;

    private Settings settings;

    private CellInfo cellInfo;

    private CellState cellState;

    private Field field;

    protected Player(String name, CellState figure) {
        this.name = name;
        settings = new Settings(name);
        cellState = figure;
    }

    protected boolean checkValue(int x, int y) {
        if ((x > ZERO && y > ZERO) && (x < MAX_SIZE_FIELD && y < MAX_SIZE_FIELD)) {
            return true;
        }
        return false;
    }

    private void doMove(int x, int y) {
        cellInfo = new CellInfo(x, y, cellState);
        if (checkValue(x, y) && this.field.isAvailible(cellInfo)) {
            field.setCell(cellInfo);
        }
    }

}

