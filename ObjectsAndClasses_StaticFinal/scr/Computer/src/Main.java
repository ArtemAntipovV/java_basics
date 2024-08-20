//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("Супер сборка", "Intel",
                new Processor(3200, 8, 3, CpuManufactured.AMD),
                new Ram(32, 3, RamType.DDR5),
                new DataStorageDevice(3200, 3, DataType.HDD),
                new Monitor(34, 32, MonitorType.TN),
                new Keyboard(true,3, KeyboardType.MECHANICAL));

        System.out.println(computer.toString());

        Computer computer1 = new Computer("Супер сборка", "Intel",
                new Processor(2800, 8, 3.5, CpuManufactured.INTEL),
                new Ram(32, 3, RamType.DDR3),
                new DataStorageDevice(3200, 3.7, DataType.HDD),
                new Monitor(34, 23, MonitorType.TN),
                new Keyboard(true,5.9, KeyboardType.MEMBRANE));

        System.out.println(computer1.toString());


    }
}