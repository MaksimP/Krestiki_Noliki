package org.hexlet.xo;

import org.hexlet.xo.exception.InvalidCellCoordinatesException;

public class CellInfo {
    public final int X;
    public final int Y;
    public final CellState figure;

    public CellInfo(int x, int y, CellState cellState) throws InvalidCellCoordinatesException {
        if (x < 0 || y < 0) {
            throw new InvalidCellCoordinatesException("Cell coordinates can't be lower than zero");
        }
        X = x;
        Y = y;
        figure = cellState;
    }
}
