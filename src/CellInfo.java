

public class CellInfo {
    public final int X;
    public final int Y;
    private CellState figure;

    public CellInfo(int x, int y, CellState cellState) {
        if (x < 0 && y < 0) {
            throw new IllegalArgumentException("Wrong input parameter: ");
        }
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
