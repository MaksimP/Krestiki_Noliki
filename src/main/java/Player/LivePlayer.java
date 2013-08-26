package com.Player;

import com.*;

public class LivePlayer extends Player {

    private Settings settings;

    private CellInfo cellInfo;

    private final CellState cellState;

    private Field field = new Field();

    public LivePlayer(String name, CellState figure) {
        settings = new Settings(name);
        cellState = figure;
    }

    public LivePlayer(CellState figure) {
        this("default", figure);
    }

    public CellState getCellState() {
        return cellState;
    }

    @Override
    public void doMove(int x, int y) {
        cellInfo = new CellInfo(x, y, cellState);
        if (checkValue(x, y) && this.field.isAvailible(cellInfo)) {
            field.setCell(cellInfo);
        }
    }

}