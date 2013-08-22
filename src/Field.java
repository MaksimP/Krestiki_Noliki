public class Field {
    private static final int DEFAULT_FIELD_SIZE = 3;
    public final int SIZE;
    private CellState[][] field;
    private int availableCells = 0;
    public Field(int fieldSize) {
        SIZE = fieldSize;
        field = new CellState[SIZE][SIZE];
        clear();
    }
    public Field() {
        this(DEFAULT_FIELD_SIZE);
    }
    public void setCell(CellInfo cell) {
        if(cell.getFigure() == CellState.EMPTY) {
            availableCells++;
        } else {
            availableCells--;
        }
        field[cell.Y][cell.X] = cell.getFigure();
    }
    public CellInfo getCell(CellInfo cell) {
        return new CellInfo(cell.X, cell.Y, field[cell.X][cell.Y]);
    }
    public void clear() {
        availableCells = 0;
        for(int y = 0; y < SIZE; y++) {
            for(int x = 0; x < SIZE; x++) {
                setCell(new CellInfo(x,y,CellState.EMPTY));
            }
        }
    }
    public boolean isAvailible(CellInfo cell) {
        if(field[cell.Y][cell.X] == CellState.EMPTY)
            return true;
        return false;
    }
    public CellState[][] getField() {
        return field;
    }
}
