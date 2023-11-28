import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColourTableTest {
    public void testAddColor() {
        ColourTable colourTable = new ColourTable(4);
        colourTable.add(255, 0, 0); // Red
        assertEquals(1, colourTable.getNumberOfColors());
    }
}
