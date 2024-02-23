package Game;

public class Item {

    private String name;
    private String type;
    private String description;

    // Constructor to initialize the Item object
    public Item(String name, String type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Getter method for description
    public String getDescription() {
        return description;
    }

    // Method to describe the item
    public void describe() {
        System.out.println(name + ": " + description);
    }

    public void use() {
        System.out.println("You cannot use this item.");
    }

    // Method to drop the item
    public void drop() {
        System.out.println("You dropped " + name);
    }
}
