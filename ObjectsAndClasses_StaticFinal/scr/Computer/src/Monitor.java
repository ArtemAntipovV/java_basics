public class Monitor {

    private final  double diagonal; // диагональ

    private final double monitorWeight; // вес

    public final MonitorType type;

    public Monitor(double diagonal, double monitorWeight, MonitorType type) {
        this.diagonal = diagonal;
        this.monitorWeight = monitorWeight;
        this.type = type;
    }

    public MonitorType getType() {
        return type;
    }


    public double getDiagonal() {
        return diagonal;
    }

    public double getMonitorWeight() {
        return monitorWeight;
    }
}
