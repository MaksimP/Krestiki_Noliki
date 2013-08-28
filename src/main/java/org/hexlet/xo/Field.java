package org.hexlet.xo;

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

    private void calculateAvailableCells() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (field[i][j] == CellState.EMPTY)
                    availableCells++;

    }

    public void setCell(CellInfo cell) {
        field[cell.Y][cell.X] = cell.getFigure();
    }

    public CellInfo getCell(CellInfo cell) {
        return new CellInfo(cell.X, cell.Y, field[cell.X][cell.Y]);
    }

    public void clear() {
        availableCells = 0;
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                setCell(new CellInfo(x, y, CellState.EMPTY));
            }
        }
    }

    public boolean isAvailable(CellInfo cell) {
        return field[cell.Y][cell.X] == CellState.EMPTY;
    }

    public CellState[][] getField() {
        return field;
    }

    public void setField(CellState[][] newField) {
        //new array must have match sizes with existing
        if (newField.length != SIZE || newField[0].length != SIZE)
            throw new ArrayIndexOutOfBoundsException();
        field = newField;
    }
}
