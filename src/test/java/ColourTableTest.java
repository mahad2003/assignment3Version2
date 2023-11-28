import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ColourTableTest {

    @Test
    public void testAddColor() {
        ColourTable colourTable = new ColourTable(4);
        colourTable.add(255, 0, 0); // Red
        assertEquals(1, colourTable.getNumberOfColors());
    }

    @Test
    public void testAddMultipleColors() {
        ColourTable colourTable = new ColourTable(4);
        colourTable.add(255, 0, 0); // Red
        colourTable.add(0, 255, 0); // Green
        colourTable.add(0, 0, 255); // Blue
        assertEquals(3, colourTable.getNumberOfColors());
    }

    @Test
    public void testAddDuplicateColor() {
        ColourTable colourTable = new ColourTable(4);
        colourTable.add(255, 0, 0); // Red
        assertThrows(IllegalStateException.class, () -> colourTable.add(255, 0, 0));
    }

}
