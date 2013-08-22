public class Field {
    public final int SIZE;
    private CellState[][] field;
    private int availableCells = 0;
    public Field(int fieldSize) {
        SIZE = fieldSize;
        field = new CellState[SIZE][SIZE];
        clear();
    }
    public void setCell(CellInfo cell) {
        if(cell.getFigure() == CellState.EMPTY) {
            availableCells++;
        } else {
            availableCells--;
        }
        field[cell.X][cell.X] = cell.getFigure();
    }
    public CellInfo getCell(CellInfo cell) {
        return new CellInfo(cell.X, cell.Y, field[cell.X][cell.Y]);
    }
    public void clear() {
        availableCells = 0;
        for(int x = 0; x < SIZE; x++) {
            for(int y = 0; y < SIZE; y++) {
                setCell(new CellInfo(x,y,CellState.EMPTY));
            }
        }
    }
    public boolean isAvailible(CellInfo cell) {
        if(field[cell.X][cell.Y] == CellState.EMPTY)
            return true;
        return false;
    }
}
