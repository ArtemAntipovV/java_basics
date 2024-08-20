public class Ram {

    private final int ramVolume; // объем
    private final double ramWeight; // вес памяти

    public final RamType type;

    public Ram(int ramVolume, double ramWeight, RamType type) {
        this.ramVolume = ramVolume;
        this.ramWeight = ramWeight;
        this.type = type;
    }


    public RamType getType() {
        return type;
    }

    public int getRamVolume() {
        return ramVolume;
    }

    public double getRamWeight() {
        return ramWeight;
    }
}
