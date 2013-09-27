//import com.sun.corba.se.impl.orb.ParserTable;
import org.hexlet.xo.Field;
import org.hexlet.xo.CellState;
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
        org.junit.Assert.assertArrayEquals(expect, result);
    }
}
