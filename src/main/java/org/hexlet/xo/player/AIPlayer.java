package org.hexlet.xo.player;

import org.hexlet.xo.CellState;

import static org.hexlet.xo.Constants.BOT_PLAYER;

public class AIPlayer extends Player {

    public AIPlayer(CellState figure) {
        super(BOT_PLAYER, figure);
    }

}
