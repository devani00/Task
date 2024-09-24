
class ConfigurationManager {
    private static ConfigurationManager instance;
    private String config;

    private ConfigurationManager() {
        config = "Default Configuration";
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}

// Client code
public class SingletonPattern {
    public static void main(String[] args) {
        ConfigurationManager configManager = ConfigurationManager.getInstance();
        System.out.println("Config: " + configManager.getConfig());

        configManager.setConfig("Custom Configuration");
        System.out.println("Config: " + configManager.getConfig());

        // Second reference gets the same instance
        ConfigurationManager anotherManager = ConfigurationManager.getInstance();
        System.out.println("Config from another manager: " + anotherManager.getConfig());
    }
}
