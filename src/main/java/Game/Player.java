package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

    private static String name;
    private static int health;
    private static int hunger;
    private static int strength;
    private List<Item> inventory;

    public Player(String characterName) {

        name = characterName;
        health = 100;
        hunger = 100;
        strength = 10;
        this.inventory = new ArrayList<>();
    }

    public static int attack() {

        Random rand = new Random();

        int max = 5 + strength;
        int min = 5;
        int attack = rand.nextInt(max - min) + min;

        return attack;
    }

    	//Setting health, hunger, and strength
    public static int getHealth() {
        return health;
    }

    public static void setHealth(int hp) {
        health = hp;
    }

    public static int getHunger() {
        return hunger;
    }

    public static void setHunger(int amount) {
        hunger = amount;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public static String getName() {
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
}
