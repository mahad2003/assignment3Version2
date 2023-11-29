import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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

    @Test
    public void testValidPaletteSize() {
        assertDoesNotThrow(() -> new ColourTable(2));
        assertDoesNotThrow(() -> new ColourTable(4));
        assertDoesNotThrow(() -> new ColourTable(8));
        assertDoesNotThrow(() -> new ColourTable(1024));
    }

    @Test
    public void testInvalidPaletteSize() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(3));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1025));
    }
    @Test
    public void testExceedCapacity() {
        ColourTable colourTable = new ColourTable(2);
        colourTable.add(255, 0, 0); // Red
        colourTable.add(0, 255, 0); // Green
        assertThrows(IllegalStateException.class, () -> colourTable.add(0, 0, 255)); // Blue
    }
    @Test
    public void testInvalidRGB() {
        ColourTable colourTable = new ColourTable(4);
        assertThrows(IllegalArgumentException.class, () -> colourTable.add(300, 0, 0)); // Invalid red value
        assertThrows(IllegalArgumentException.class, () -> colourTable.add(0, -1, 0)); // Invalid green value
        assertThrows(IllegalArgumentException.class, () -> colourTable.add(0, 0, 256)); // Invalid blue value
    }

    @Test
    public void testRemoveColor() {
        ColourTable colourTable = new ColourTable(4);
        colourTable.add(255, 0, 0); // Red
        colourTable.add(0, 255, 0); // Green
        colourTable.add(0, 0, 255); // Blue

        colourTable.remove(255, 0, 0);
        assertEquals(2, colourTable.getNumberOfColors());
    }
    @Test
    public void testRemoveNonExistentColor() {
        ColourTable colourTable = new ColourTable(4);
        colourTable.add(255, 0, 0); // Red
        colourTable.add(0, 255, 0); // Green
        colourTable.add(0, 0, 255); // Blue

        colourTable.remove(128, 128, 128); // Non-existent color
        assertEquals(3, colourTable.getNumberOfColors());
    }
    @Test
    public void testClearAllColors() {
        ColourTable colourTable = new ColourTable(4);
        colourTable.add(255, 0, 0); // Red
        colourTable.add(0, 255, 0); // Green
        colourTable.add(0, 0, 255); // Blue

        colourTable.clear();
        assertEquals(0, colourTable.getNumberOfColors());
    }

}

