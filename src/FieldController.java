public class FieldController {

    private final static int NEED_CHARACTERS_TO_WIN = 3;

    public boolean checkWin(Field gameField, int x, int y) {

        int currentSequenceLength = 1;
        CellState field[][] = gameField.getField();
        CellState cell = field[x][y];

        // Horizontal check
        for (int i = 1; i < field.length; i++) {
            if(field[x][i]==field[x][i-1] && field[x][i]==cell) {
                currentSequenceLength++;
                if(currentSequenceLength==NEED_CHARACTERS_TO_WIN) {
                    return true;
                }
            } else {
                currentSequenceLength = 1;
            }
        }

        // Vertical check
        currentSequenceLength = 1;
        for (int i = 1; i < field.length; i++) {
            if(field[i][y]==field[i-1][y] && field[i][y]==cell) {
                currentSequenceLength++;
                if(currentSequenceLength==NEED_CHARACTERS_TO_WIN) {
                    return true;
                }
            } else {
                currentSequenceLength = 1;
            }
        }

        // First diagonal check
        currentSequenceLength = 1;
        int i = x;
        int j = y;
        while (i>0 && j>0) {
            i--;
            j--;
        }
        int k, l;
        for(k = i+1, l = j+1; k<field.length && l<field.length; k++, l++) {
            if(field[k][l]==field[k-1][l-1] && field[k][l]==cell) {
                currentSequenceLength++;
                if(currentSequenceLength==NEED_CHARACTERS_TO_WIN) {
                    return true;
                }
            }
            else {
                currentSequenceLength = 1;
            }
        }

        // Second diagonal check
        currentSequenceLength = 1;
        i = x;
        j = y;
        while (i>0 && j<field.length-1) {
            i--;
            j++;
        }
        for(k = i+1, l = j-1; k<field.length && l>=0; k++, l--) {
            if(field[k][l]==field[k-1][l+1] && field[k][l]==cell) {
                currentSequenceLength++;
                if(currentSequenceLength==NEED_CHARACTERS_TO_WIN) {
                    return true;
                }
            }
            else {
                currentSequenceLength = 1;
            }
        }

        return false;
    }

}
