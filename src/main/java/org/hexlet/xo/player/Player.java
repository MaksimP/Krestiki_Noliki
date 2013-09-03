package org.hexlet.xo.player;

import org.hexlet.xo.CellInfo;
import org.hexlet.xo.CellState;
import org.hexlet.xo.Field;
import org.hexlet.xo.Settings;

public abstract class Player implements IPlayer{

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
        boolean moreThanZero = x > ZERO && y > ZERO;
        boolean lessThenMaxSize = x < MAX_SIZE_FIELD && y < MAX_SIZE_FIELD;
        return moreThanZero && lessThenMaxSize;
    }

    @Override
    public void doMove(int x, int y) {
        cellInfo = new CellInfo(x, y, cellState);
        if (checkValue(x, y) && this.field.isAvailable(cellInfo)) {
            field.setCell(cellInfo);
        }
    }

}

