package org.hexlet.xo.player;

import org.hexlet.xo.CellInfo;
import org.hexlet.xo.CellState;

public interface Player {

    void onMove (int x, int y);
    CellInfo getMove();
    CellState getFigure();

}
