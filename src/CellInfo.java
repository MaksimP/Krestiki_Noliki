

public class CellInfo {
    private int x;
    private int y;
    private CellState figure;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Wrong parameter: x");
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y < 0) {
            throw new IllegalArgumentException("Wrong parameter: y");
        }
        this.y = y;
    }

    public CellState getFigure() {
        return figure;
    }

    public void setFigure(CellState figure) {
        this.figure = figure;
    }
}
