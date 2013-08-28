package org.hexlet.xo.player;

import org.hexlet.xo.CellState;

import static org.hexlet.xo.Constants.DEFAULT_PLAYER;

public class RemotePlayer extends Player {

    public RemotePlayer(CellState figure) {
        super(DEFAULT_PLAYER, figure);
    }

    private int getID() {
        int id = 0;
        for (int i = 0; i < 10; i++) {
            id += Math.random() * 2000 ;
        }
        return id;
    }

}
