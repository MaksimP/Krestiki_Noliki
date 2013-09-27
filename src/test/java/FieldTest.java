import org.hexlet.xo.Field;
import org.hexlet.xo.CellState;
import org.hexlet.xo.CellInfo;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link Field}.
 *
 * @author marcondream@gmail.com (Evgeniy Dolgikh)
 */

@RunWith(JUnit4.class)
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
    public void emptyCellsCount() {
        org.junit.Assert.assertEquals("Failure - invalid empty cells count", 9, field.getEmptyCellsCount());
        field.setCell(new CellInfo(0,0, CellState.X));
        org.junit.Assert.assertEquals("Failure - invalid empty cells count", 8, field.getEmptyCellsCount());
    }
}
