package Game;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static String name;
    private int health;
    private int hunger;
    private int strength;
    private List<Item> inventory;

    public Player(String characterName) {

        name = characterName;
        this.health = 100;
        this.hunger = 100;
        this.strength = 10;
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

    public static String GetName() {
        return name;
    }

    // Method to add an item to the inventory
    public void addToInventory(Item string) {
        inventory.add(string);
        System.out.println("Added " + string + " to the inventory.");
    }

    // Method to display player information
    public void displayPlayerInfo() {
        System.out.println("Player Information:");
        System.out.println("Health: " + health);
        System.out.println("Hunger: " + hunger);
        System.out.println("Strength: " + strength);
        System.out.println("Inventory: " + inventory);
        
    
    }

    private int xCoordinate;
    private int yCoordinate;

    public Player(int initialX, int initialY) {
        this.xCoordinate = initialX;
        this.yCoordinate = initialY;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void movePlayer(int newX, int newY) {
        this.xCoordinate = newX;
        this.yCoordinate = newY;
    }
}
