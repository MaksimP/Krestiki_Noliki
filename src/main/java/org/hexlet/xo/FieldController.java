package org.hexlet.xo;

import org.hexlet.xo.exception.CellNotAvailableException;
import org.hexlet.xo.exception.InvalidCellCoordinatesException;

public class FieldController {

    private final static int NEED_CHARACTERS_TO_WIN = 3;
    private Field field;

    public boolean checkWin(CellState figure) {

        CellState field[][] = this.field.getField();
        CellState cell = figure;

        int horizontalSequenceLength = 0;
        int verticalSequenceLength = 0;

        if (cell == CellState.EMPTY)
            return false;

        // Horizontal check & Vertical check
        for (int i = 0; i < this.field.SIZE; i++) {
            for (int j = 0; j < this.field.SIZE; j++) {
                 if (field[i][j] == cell) {
                     horizontalSequenceLength++;
                 }
                 if (field[j][i] == cell) {
                     verticalSequenceLength++;
                 }
            }

            if (horizontalSequenceLength == NEED_CHARACTERS_TO_WIN ||
                    verticalSequenceLength == NEED_CHARACTERS_TO_WIN) {
                return true;
            }
            else {
                horizontalSequenceLength = 0;
                verticalSequenceLength = 0;
            }

        }

        int diagonalSequenceLength1 = 0;
        int diagonalSequenceLength2 = 0;

        // Diagonal check
        for (int i = 0, j = 2; i < this.field.SIZE; i++, j--) {
            if (field[i][i] == cell) {
                diagonalSequenceLength1++;
            }
            if (field[i][j] == cell) {
                diagonalSequenceLength2++;
            }
        }

        if (diagonalSequenceLength1 == NEED_CHARACTERS_TO_WIN ||
                diagonalSequenceLength2 == NEED_CHARACTERS_TO_WIN) {
            return true;
        }

        return false;
    }

    public void createField(int size) {
        if (field != null && field.SIZE == size) {
            field.clear();
        } else {
            field = new Field(size);
        }
    }

    public boolean isAvailable(CellInfo cell) throws InvalidCellCoordinatesException {
        return field.getCell(cell.X,cell.Y).getFigure() == CellState.EMPTY;
    }

    public void setCell(CellInfo cell) throws CellNotAvailableException, InvalidCellCoordinatesException {
        if (!isAvailable(cell))
            throw new CellNotAvailableException("Cell "+cell.X+":"+cell.Y+" already in use");
        field.setCell(cell);
    }
    public int getFieldSize() {
        return field.SIZE;
    }
    public CellState[][] getField() {
        return field.getField();
    }

}
