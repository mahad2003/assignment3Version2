import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ColourTable class.
 * Tests various aspects of the ColourTable class using the JUnit testing framework.
 */
public class ColourTableTest {
    /**
     * Tests the add method of ColourTable for adding a single color.
     * Verifies that adding a color increments the number of colors in the ColourTable.
     */
    @Test
    public void testAddColor() {
        ColourTable colourTable = new ColourTable(4);
        colourTable.add(255, 0, 0); // Red
        assertEquals(1, colourTable.getNumberOfColors());
    }
    /**
     * Tests the add method of ColourTable for adding multiple colors.
     * Verifies that adding multiple colors increments the number of colors in the ColourTable accordingly.
     */
    @Test
    public void testAddMultipleColors() {
        ColourTable colourTable = new ColourTable(4);
        colourTable.add(255, 0, 0); // Red
        colourTable.add(0, 255, 0); // Green
        colourTable.add(0, 0, 255); // Blue
        assertEquals(3, colourTable.getNumberOfColors());
    }
    /**
     * Tests the add method of ColourTable for attempting to add a duplicate color.
     * Verifies that adding a duplicate color results in an IllegalStateException.
     */
    @Test
    public void testAddDuplicateColor() {
        ColourTable colourTable = new ColourTable(4);
        colourTable.add(255, 0, 0); // Red
        assertThrows(IllegalStateException.class, () -> colourTable.add(255, 0, 0));
    }
    /**
     * Tests the constructor of ColourTable with valid palette sizes.
     * Ensures that creating a ColourTable with valid palette sizes does not throw an exception.
     */
    @Test
    public void testValidPaletteSize() {
        assertDoesNotThrow(() -> new ColourTable(2));
        assertDoesNotThrow(() -> new ColourTable(4));
        assertDoesNotThrow(() -> new ColourTable(8));
        assertDoesNotThrow(() -> new ColourTable(1024));
    }
    /**
     * Tests the constructor of ColourTable with invalid palette sizes.
     * Ensures that creating a ColourTable with invalid palette sizes throws an IllegalArgumentException.
     */
    @Test
    public void testInvalidPaletteSize() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(3));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1025));
    }
    /**
     * Tests the add method of ColourTable for exceeding its capacity.
     * Verifies that attempting to add more colors than the capacity of the ColourTable results in an IllegalStateException.
     */
    @Test
    public void testExceedCapacity() {
        ColourTable colourTable = new ColourTable(2);
        colourTable.add(255, 0, 0); // Red
        colourTable.add(0, 255, 0); // Green
        assertThrows(IllegalStateException.class, () -> colourTable.add(0, 0, 255)); // Blue
    }
    /**
     * Tests the add method of ColourTable for invalid RGB values.
     * Verifies that attempting to add a color with invalid RGB values results in an IllegalArgumentException.
     */
    @Test
    public void testInvalidRGB() {
        ColourTable colourTable = new ColourTable(4);
        assertThrows(IllegalArgumentException.class, () -> colourTable.add(300, 0, 0)); // Invalid red value
        assertThrows(IllegalArgumentException.class, () -> colourTable.add(0, -1, 0)); // Invalid green value
        assertThrows(IllegalArgumentException.class, () -> colourTable.add(0, 0, 256)); // Invalid blue value
    }
    /**
     * Tests the removal of an existing color from the ColourTable.
     * It adds three colors (Red, Green, and Blue) and then removes the Red color.
     * The test checks if the number of colors is reduced to 2 after removal.
     */
    @Test
    public void testRemoveColor() {
        ColourTable colourTable = new ColourTable(4);
        colourTable.add(255, 0, 0); // Red
        colourTable.add(0, 255, 0); // Green
        colourTable.add(0, 0, 255); // Blue

        colourTable.remove(255, 0, 0);
        assertEquals(2, colourTable.getNumberOfColors());
    }
    /**
     * Tests the removal attempt of a non-existent color from the ColourTable.
     * It adds three colors (Red, Green, and Blue) and attempts to remove a color that doesn't exist.
     * The test checks if the number of colors remains unchanged after the removal attempt.
     */
    @Test
    public void testRemoveNonExistentColor() {
        ColourTable colourTable = new ColourTable(4);
        colourTable.add(255, 0, 0); // Red
        colourTable.add(0, 255, 0); // Green
        colourTable.add(0, 0, 255); // Blue

        colourTable.remove(128, 128, 128); // Non-existent color
        assertEquals(3, colourTable.getNumberOfColors());
    }
    /**
     * Tests the clearing of all colors from the ColourTable.
     * It adds three colors (Red, Green, and Blue) and then clears the ColourTable.
     * The test checks if the number of colors is reduced to 0 after clearing.
     */
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

