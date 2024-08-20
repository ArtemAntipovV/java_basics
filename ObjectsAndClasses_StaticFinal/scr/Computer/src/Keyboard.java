public class Keyboard {

    private final boolean highlights;
    private final double keyboardWeight;

    public final KeyboardType type;


    public Keyboard(boolean highlights, double keyboardWeight, KeyboardType type) {
        this.highlights = highlights;
        this.keyboardWeight = keyboardWeight;
        this.type = type;
    }

    public KeyboardType getType() {
        return type;
    }

    public double getKeyboardWeight() {
        return keyboardWeight;
    }

    public boolean isHighlights() {
        return highlights;
    }
}
