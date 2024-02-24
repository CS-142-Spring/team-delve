package Game;

import java.util.Random;
import Game.Scenes.GameScene;

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

    public void take() {

        int hpModifier = 0;
        int hungerModifier = 0;

        if (name == "Bread") {

            // Display use message.
            GameScene.setText(description);
            GameScene.addTextLine("You take the bread.");
            GameScene.addTextLine("You feel a little less hungry. (+5 Hunger)");

            hungerModifier = 5;

        } else if (name == "Health Potion") {

            // Display use message.
            GameScene.setText(description);
            GameScene.addTextLine("You take the health potion.");
            GameScene.addTextLine("You feel a bit better. (+10 HP)");

            hpModifier = 10;

        } else if (name == "Combo Potion") {

            // Display use message.
            GameScene.setText(description);
            GameScene.addTextLine("You take the potion.");
            GameScene.addTextLine("You feel a little less hungry. (+10 Hunger)");
            GameScene.addTextLine("You feel a bit better. (+10 HP)");
            
            hungerModifier = 10;
            hpModifier = 10;
        }

        // Apply effects.
        Player.setHealth(Math.min(Player.getHealth() + hpModifier, 100));
        Player.setHunger(Math.min(Player.getHunger() + hungerModifier, 100));
        GameScene.updateHPLabel();
        GameScene.updateHungerLabel();
    }

    // Generate a random item.
    public static Item random() {

        Random rand = new Random();
        int itemType = rand.nextInt(6) + 1;

        // Item is bread by default.
        Item item = new Item("Bread", "food", "A bit of old bread.");

        switch (itemType) {
            case 1:
                break;
            case 2:
                item = new Item("Health Potion", "food", "A blue glowing bottle."); 
                break;
            case 3:
                item = new Item("Health Potion", "food", "A blue glowing bottle."); 
                break;
            case 6: // More rare.
                item = new Item("Combo Potion", "food", "Restores HP and hunger."); 
                break;
        }
    
        return item;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Getter method for description
    public String getDescription() {
        return description;
    }

    public void use() {
        System.out.println("You cannot use this item.");
    }

}
