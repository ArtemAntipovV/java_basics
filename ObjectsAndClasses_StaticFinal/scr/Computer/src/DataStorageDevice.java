public class DataStorageDevice {


    private final int dataVolume; // объем памяти
    private final double dataWeight; // вес
    public final DataType type;

    public DataStorageDevice(int dataVolume, double dataWeight, DataType type) {
        this.dataVolume = dataVolume;
        this.dataWeight = dataWeight;
        this.type = type;
    }

    public int getDataVolume() {
        return dataVolume;
    }

    public DataType getType() {
        return type;
    }

    public double getDataWeight() {
        return dataWeight;
    }
}
