import org.hexlet.xo.Field;
import org.hexlet.xo.CellState;
import org.hexlet.xo.CellInfo;
import org.hexlet.xo.exception.InvalidCellCoordinatesException;
import org.junit.rules.ExpectedException;
import org.junit.Test;
import org.junit.Rule;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;

/**
 * Tests for {@link Field}.
 *
 * @author marcondream@gmail.com (Evgeniy Dolgikh)
 */

@RunWith(Theories.class)
public class FieldTest {
    private final Field field = new Field();

    @Test
    public void defaultConstructor() {
        CellState[][] expect = {
                {CellState.EMPTY,CellState.EMPTY,CellState.EMPTY,},
                {CellState.EMPTY,CellState.EMPTY,CellState.EMPTY,},
                {CellState.EMPTY,CellState.EMPTY,CellState.EMPTY,},
                };
        CellState[][] result = field.getField();
        org.junit.Assert.assertArrayEquals("Failure - default contructor creates invalid array",expect, result);
    }

    @Test
    public void setCell() {
        field.setCell(new CellInfo(0,0, CellState.X));
        field.setCell(new CellInfo(2,1, CellState.O));
        field.setCell(new CellInfo(1,1, CellState.X));
        field.setCell(new CellInfo(1,2, CellState.O));
        CellState[][] expect = {
                {CellState.X,CellState.EMPTY,CellState.EMPTY,},
                {CellState.EMPTY,CellState.X,CellState.O,},
                {CellState.EMPTY,CellState.O,CellState.EMPTY,},
        };
        CellState[][] result = field.getField();
        org.junit.Assert.assertArrayEquals("Failure - invalid array after setCell usage", expect, result);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @DataPoints
    public static int[][] testData = {
            {3, 0},
            {0, 3},
            {-1, 0},
            {0, -1},
            };

    @Theory
    public void getCellException(int[] data) {
        try {
            field.getCell(data[0], data[1]);
            org.junit.Assert.fail("Expected exception was not thrown");
        } catch (InvalidCellCoordinatesException e) {

        }

    }


    @Test
    public void emptyCellsCount() {
        org.junit.Assert.assertEquals("Failure - invalid empty cells count", 9, field.getEmptyCellsCount());
        field.setCell(new CellInfo(0,0, CellState.X));
        org.junit.Assert.assertEquals("Failure - invalid empty cells count", 8, field.getEmptyCellsCount());
    }
}
