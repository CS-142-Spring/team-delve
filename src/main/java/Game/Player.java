package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

    private static String name;
    private static int health;
    private static int hunger;

    public Player(String characterName) {

        // Initialize properties.
        name = characterName;
        health = 100;
        hunger = 100;
    }

    public static int attack() {

        Random rand = new Random();

        // Generate random attack value.
        int max = 10;
        int min = 5;
        int attack = rand.nextInt(max - min) + min;

        return attack;
    }

    public static void hit(int damage) {
        health -= damage;
    }

    public static void useHunger(int amount) {
        hunger -= amount;
    }

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

    public static void setName(String str) {
        name = str;
    }

}
