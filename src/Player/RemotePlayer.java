package com.Player;

import com.*;

public class RemotePlayer extends Player {

    private CellInfo cellInfo;

    private CellState cellState;

    private Field field = new Field();

    Settings settings;

    public RemotePlayer(String name, String password) {
        settings = new Settings(name, password, getID());
    }

    private int getID() {
        int id = 0;
        for (int i = 0; i < 10; i++) {
            id += Math.random() * 2000 ;
        }
        return id;
    }

    @Override
    public void doMove(int x, int y) {
        cellInfo = new CellInfo(x, y, cellState);
        if (checkValue(x, y) && this.field.isAvailible(cellInfo)) {
            field.setCell(cellInfo);
        }
    }
}
