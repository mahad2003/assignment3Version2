import java.util.HashSet;
import java.util.Set;


public class ColourTable {

    private final int paletteSize;

    private final Set<RGBColor> colors = new HashSet<>();
    public ColourTable(int paletteSize) {
        if (!isValidPaletteSize(paletteSize)) {
            throw new IllegalArgumentException("Invalid palette size. Must be a power of two, greater than 1, and less than 1025");
        }
        this.paletteSize = paletteSize;
    }

    private boolean isValidPaletteSize(int size) {
        return size > 1 && (size & (size - 1)) == 0 && size < 1025;
    }

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
}

