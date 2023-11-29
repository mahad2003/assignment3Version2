import java.util.Objects;

/**
 * Represents an RGB color with red, green, and blue components.
 */
public class RGBColor {
    private final int red;
    private final int green;
    private final int blue;

    /**
     * Constructs an RGBColor with specified red, green, and blue components.
     *
     * @param red   The red component of the RGB color (0-255).
     * @param green The green component of the RGB color (0-255).
     * @param blue  The blue component of the RGB color (0-255).
     */
    public RGBColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * Gets the red component of the RGB color.
     *
     * @return The red component (0-255).
     */
    public int getRed() {
        return red;
    }

    /**
     * Gets the green component of the RGB color.
     *
     * @return The green component (0-255).
     */
    public int getGreen() {
        return green;
    }

    /**
     * Gets the blue component of the RGB color.
     *
     * @return The blue component (0-255).
     */
    public int getBlue() {
        return blue;
    }

    /**
     * Checks if this RGBColor is equal to another object.
     *
     * @param o The object to compare.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RGBColor rgbColor = (RGBColor) o;
        return red == rgbColor.red && green == rgbColor.green && blue == rgbColor.blue;
    }

    /**
     * Computes the hash code of this RGBColor.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }
}