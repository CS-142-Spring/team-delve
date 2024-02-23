package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

    private static String name;
    private static int health;
    private static int hunger;
    private List<Item> inventory;

    public Player(String characterName) {

        name = characterName;
        health = 100;
        hunger = 100;
        this.inventory = new ArrayList<>();
    }

    public static int attack() {

        Random rand = new Random();

        int max = 10;
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

    public static String getName() {
        return name;
    }

    // Method to add an item to the inventory
    public void addToInventory(Item string) {
        inventory.add(string);
        System.out.println("Added " + string + " to the inventory.");
    }

}
