public class Computer {


    public Processor processor;
    public DataStorageDevice dataStorageDevice;
    public Keyboard keyboard;
    public Monitor monitor;
    public Ram ram;

    public  double totalWeightComputer;

    public String vendor;
    public String name;

    public Computer(String name, String vendor, Processor processor, Ram ram, DataStorageDevice dataStorageDevice, Monitor monitor, Keyboard keyboard) {
        this.name = name;
        this.vendor = vendor;
        this.ram = ram;
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.dataStorageDevice = dataStorageDevice;
        this.processor = processor;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Computer(int totalWeightComputer) {
        this.totalWeightComputer = totalWeightComputer;
    }

    public double  getTotalWeightComputer() {
        totalWeightComputer = (int) (processor.getCpuWeight() + ram.getRamWeight() +
                        dataStorageDevice.getDataWeight() + monitor.getMonitorWeight() + keyboard.getKeyboardWeight());
        return totalWeightComputer;
    }

    public void setTotalWeightComputer(int totalWeightComputer) {
        this.totalWeightComputer = totalWeightComputer;
    }

    public DataStorageDevice getDataStorageDevice() {
        return dataStorageDevice;
    }

    public void setDataStorageDevice(DataStorageDevice dataStorageDevice) {
        this.dataStorageDevice = dataStorageDevice;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String toString() {
        return "n" + "Общая ифномарция" + "\n" + "\n" + "Произвордитель: " + vendor + "\n" + "Наименование сборки: " + name
                + "\n"

                + "\n" + "Процессор: " + "\n" + "Частота: " + processor.getFrequency() + " Гц" + "\n" +
                "Количество ядер: " + processor.getCore() + "\n" + "Производитель: " + processor.getType() +
                "Вес: " + processor.getCpuWeight() + " гр" + "\n"

                + "\n" + "Оперативная память: " + "\n" + "Тип: " + ram.getType() + "\n" +
                "Объем: " + ram.getRamVolume() + "\n" + "Вес: " + ram.getRamWeight() + " гр" + "\n" +

                "\n" + "Накопитель информации: " + "\n" +  "Тип: " + dataStorageDevice.getType()
                + "\n" + "Объем памяти: " + dataStorageDevice.getDataVolume() + " гб" + "\n" + "Вес: " +
                dataStorageDevice.getDataWeight() + " гр" + "\n" +

                "\n" + "Монитор: " + "\n" + "Диагональ: " + monitor.getDiagonal() + "\n" +
                "Тип матрицы: " + monitor.getType() + "\n" + "Вес: " + monitor.getMonitorWeight() +  " гр" + "\n"

                + "\n" + "Клавиатура: " + "\n" + "тип: " + keyboard.getType() + "\n" + "Наличие подстветки"
                + keyboard.isHighlights() + "\n" + "Вес: " + keyboard.getKeyboardWeight() + " гр" + "\n"

                + "\n" + "Общий вес сборки: " + getTotalWeightComputer() + " гр";




    }

}
