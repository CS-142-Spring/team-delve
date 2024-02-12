package Game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int health;
    private int hunger;
    private int strength;
    private List<String> inventory;


    public Player(int initialHealth, int initialHunger, int initialStrength) {
        this.health = initialHealth;
        this.hunger = initialHunger;
        this.strength = initialStrength;
        this.inventory = new ArrayList<>();
    }
    	//Setting health, hunger, and strength
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    // Method to add an item to the inventory
    public void addToInventory(String item) {
        inventory.add(item);
        System.out.println("Added " + item + " to the inventory.");
    }

    // Method to display player information
    public void displayPlayerInfo() {
        System.out.println("Player Information:");
        System.out.println("Health: " + health);
        System.out.println("Hunger: " + hunger);
        System.out.println("Strength: " + strength);
        System.out.println("Inventory: " + inventory);
    }

    // Example main method for testing
    public static void main(String[] args) {
        // Create a new player
        Player player = new Player(100, 50, 10);

        // Display initial player information
        player.displayPlayerInfo();

        // Add items to the inventory
        player.addToInventory("Sword");
        player.addToInventory("Shield");

        // Update player information and display again
        player.setHealth(80);
        player.setHunger(40);
        player.setStrength(15);

        player.displayPlayerInfo();
    }
}
