package main.java;

public class CellInfo {
    public final int X;
    public final int Y;
    private CellState figure;

    public CellInfo(int x, int y, CellState cellState) {
        X = x;
        Y = y;
        figure = cellState;
    }

    public CellState getFigure() {
        return figure;
    }

    public void setFigure(CellState figure) {
        this.figure = figure;
    }
}
