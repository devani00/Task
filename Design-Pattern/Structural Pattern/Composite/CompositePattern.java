import java.util.ArrayList;
import java.util.List;

// Component interface
interface Employee {
    void showDetails();
}

// Leaf class representing a Developer
class Developer implements Employee {
    private String name;
    private String position;

    public Developer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showDetails() {
        System.out.println("Developer: " + name + ", Position: " + position);
    }
}

// Leaf class representing a Designer
class Designer implements Employee {
    private String name;
    private String position;

    public Designer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showDetails() {
        System.out.println("Designer: " + name + ", Position: " + position);
    }
}

// Composite class representing a Manager (can have subordinates)
class Manager implements Employee {
    private String name;
    private String department;
    private List<Employee> subordinates = new ArrayList<>();

    public Manager(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    public void removeSubordinate(Employee employee) {
        subordinates.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Manager: " + name + ", Department: " + department);
        System.out.println("Subordinates:");
        for (Employee subordinate : subordinates) {
            subordinate.showDetails();
        }
    }
}

// Client code
public class CompositePattern {
    public static void main(String[] args) {
        // Creating developers
        Employee dev1 = new Developer("Alice", "Frontend Developer");
        Employee dev2 = new Developer("Bob", "Backend Developer");

        // Creating designers
        Employee designer1 = new Designer("Charlie", "UX Designer");

        // Creating manager and adding subordinates
        Manager manager = new Manager("David", "Development Manager");
        manager.addSubordinate(dev1);
        manager.addSubordinate(dev2);
        manager.addSubordinate(designer1);

        // Display manager and subordinates' details
        manager.showDetails();
    }
}
