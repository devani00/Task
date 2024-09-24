package Builder;
// Product class
class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    public Computer(String CPU, String RAM, String storage, boolean isGraphicsCardEnabled, boolean isBluetoothEnabled) {
        this.CPU = CPU;
        this.RAM = RAM;
        this.storage = storage;
        this.isGraphicsCardEnabled = isGraphicsCardEnabled;
        this.isBluetoothEnabled = isBluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + 
               ", GraphicsCard=" + isGraphicsCardEnabled + ", Bluetooth=" + isBluetoothEnabled + "]";
    }
}

// Builder class
class ComputerBuilder {
    private String CPU;
    private String RAM;
    private String storage;
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    public ComputerBuilder setCPU(String CPU) {
        this.CPU = CPU;
        return this;
    }

    public ComputerBuilder setRAM(String RAM) {
        this.RAM = RAM;
        return this;
    }

    public ComputerBuilder setStorage(String storage) {
        this.storage = storage;
        return this;
    }

    public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
        this.isGraphicsCardEnabled = isGraphicsCardEnabled;
        return this;
    }

    public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
        this.isBluetoothEnabled = isBluetoothEnabled;
        return this;
    }

    public Computer build() {
        return new Computer(CPU, RAM, storage, isGraphicsCardEnabled, isBluetoothEnabled);
    }
}

// Client code
public class BuilderPattern {
    public static void main(String[] args) {
        Computer computer = new ComputerBuilder()
                                .setCPU("Intel i7")
                                .setRAM("16GB")
                                .setStorage("1TB SSD")
                                .setGraphicsCardEnabled(true)
                                .setBluetoothEnabled(true)
                                .build();

        System.out.println(computer);
    }
}
