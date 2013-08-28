package org.hexlet.xo.player;

import org.hexlet.xo.CellState;

import static org.hexlet.xo.Constants.DEFAULT_PLAYER;

public class LivePlayer extends Player {

    public LivePlayer(String name, CellState figure) {
        super(name, figure);
    }

    public LivePlayer(CellState figure) {
        this(DEFAULT_PLAYER, figure);
    }

}