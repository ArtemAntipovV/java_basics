public class Processor {

        public final int frequency;  // частота
        public final int core; // количество ядер
        public final double cpuWeight; // вес процессора

        public final CpuManufactured type;

        public Processor(int frequency, int core, double cpuWeight, CpuManufactured type) {
                this.frequency = frequency;
                this.core = core;
                this.cpuWeight = cpuWeight;
                this.type = type;
        }

        public CpuManufactured getType() {
                return type;
        }

        public int getCore() {
                return core;
        }

        public int getFrequency() {
                return frequency;
        }

        public double getCpuWeight() {
                return cpuWeight;
        }
}
