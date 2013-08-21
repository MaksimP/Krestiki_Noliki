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
        if(cell.figure == CellState.EMPTY) {
            availableCells++;
        } else {
            availableCells--;
        }
        field[cell.x][cell.y] = cell.figure;
    }
    public CellInfo getCell(CellInfo cell) {
        return new CellInfo(cell.x, cell.y, field[cell.x][cell.y]);
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
        if(field[cell.x][cell.y] == CellState.EMPTY)
            return true;
        return false;
    }
}
