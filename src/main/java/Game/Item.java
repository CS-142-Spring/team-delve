package Game;

public class Item {
    private String name;
    private String description;
    private int weight;
    private boolean isPickable;

    // Constructor to initialize the Item object
    public Item(String name, String description, int weight, boolean isPickable) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.isPickable = isPickable;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Getter method for description
    public String getDescription() {
        return description;
    }

    // Getter method for weight
    public int getWeight() {
        return weight;
    }

    // Getter method to check if the item can be picked up
    public boolean isPickable() {
        return isPickable;
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
