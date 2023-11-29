import java.util.HashSet;
import java.util.Set;

/**
 * Represents a ColourTable that stores a palette of RGB colors.
 * An image encoded using a colour palette stores colour information in a colour lookup table, usually implemented as an array of RGB values.
 * Each element in the array represents a unique colour, and its index is used to represent that colour in the image.
 */
public class ColourTable {

    private final int paletteSize;
    private final Set<RGBColor> colors = new HashSet<>();

    /**
     * Constructs a ColourTable with a specified palette size.
     *
     * @param paletteSize The number of colors allowed in the palette.
     * @throws IllegalArgumentException If the palette size is not a power of two, less than 2, or greater than 1024.
     */
    public ColourTable(int paletteSize) {
        if (!isValidPaletteSize(paletteSize)) {
            throw new IllegalArgumentException("Invalid palette size. Must be a power of two, greater than 1, and less than 1025");
        }
        this.paletteSize = paletteSize;
    }

    /**
     * Checks whether the provided size is a valid palette size.
     * A valid palette size must be a power of two, greater than 1, and less than 1025.
     *
     * @param size The size to be validated as a palette size.
     * @return true if the size is a valid palette size, false otherwise.
     */
    private boolean isValidPaletteSize(int size) {
        return size > 1 && (size & (size - 1)) == 0 && size < 1025;
    }

    /**
     * Adds a 24-bit RGB color to the ColourTable.
     *
     * @param red   The red component of the RGB color (0-255).
     * @param green The green component of the RGB color (0-255).
     * @param blue  The blue component of the RGB color (0-255).
     * @throws IllegalArgumentException If the RGB values are not within the valid range.
     * @throws IllegalStateException    If the color already exists in the ColourTable.
     * @throws IllegalStateException    If the ColourTable capacity is exceeded.
     */
    public void add(int red, int green, int blue) {
        RGBColor rgbColor = new RGBColor(red, green, blue);
        if (!isValidRGB(rgbColor)) {
            throw new IllegalArgumentException("Invalid RGB color");
        }

        if (colors.size() < paletteSize) {
            if (!colors.contains(rgbColor)) {
                colors.add(rgbColor);
            } else {
                throw new IllegalStateException("Color already exists in the ColourTable");
            }
        } else {
            throw new IllegalStateException("Exceeded the capacity of the ColourTable");
        }
    }

    /**
     * Checks whether the provided RGBColor object represents a valid RGB color.
     *
     * @param rgbColor The RGBColor object to be validated.
     * @return true if the RGBColor is valid, false otherwise.
     */
    private boolean isValidRGB(RGBColor rgbColor) {
        return rgbColor.getRed() >= 0 && rgbColor.getRed() <= 255 &&
                rgbColor.getGreen() >= 0 && rgbColor.getGreen() <= 255 &&
                rgbColor.getBlue() >= 0 && rgbColor.getBlue() <= 255;
    }

    /**
     * Gets the number of unique colors currently stored in the ColourTable.
     *
     * @return The number of unique colors.
     */
    public int getNumberOfColors() {
        return colors.size();
    }

    /**
     * Removes the specified RGB color from the ColourTable, if present.
     *
     * @param red   The red component of the RGB color.
     * @param green The green component of the RGB color.
     * @param blue  The blue component of the RGB color.
     */
    public void remove(int red, int green, int blue) {
        RGBColor rgbColorToRemove = new RGBColor(red, green, blue);
        colors.remove(rgbColorToRemove);
    }

    /**
     * Clears all colors from the ColourTable, making it empty.
     */
    public void clear() {
        colors.clear();
    }
}

