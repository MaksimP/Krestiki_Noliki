package org.hexlet.xo.player;

import org.hexlet.xo.CellInfo;
import org.hexlet.xo.CellState;

public interface Player {

    CellInfo onMove (int x, int y);
    CellState getFigure();

}
