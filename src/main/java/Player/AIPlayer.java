package com.Player;

import com.*;

public class AIPlayer extends Player {

    private Settings settings;

    private final CellState cellState;

    public AIPlayer(CellState figure) {
        settings = new Settings("bot");
        cellState = figure;
    }

    @Override
    public void doMove(int x, int y) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}
