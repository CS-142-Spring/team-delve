package Game.Scenes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.util.Random;

import Engine.Engine;
import Engine.Scene;
import Engine.UI.Button;
import Engine.UI.Label;
import Engine.UI.UI;
import Game.GameMap;
import Game.Item;
import Game.NPC;
import Game.Player;
import Game.Room;

enum State {
    IDLE,
    TOTEM,
    LOOT,
};

public class GameScene extends Scene {

    private static Label nameLabel;
    private static Label healthLabel;
    private static Label hungerLabel;
    private Label roomLabel;
    private Label invLabel;

    private static DefaultListModel<String> itemListModel;
    private static JList<String> roomList;

    private static JTextArea text;

    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel bottomPanel;
    private JPanel centerPanel;

    private static Button option1;
    private static Button option2;

    private boolean canExit;
    private static boolean hasTotem;

    State state;
    Item lootItem1;
    Item lootItem2;

    public GameScene() {

        super();

        hasTotem = false;
        canExit = false;
        state = State.IDLE;

        getPanel().setBackgroundImage("resources/image/main_menu.png");
        Border border = BorderFactory.createLineBorder(Color.WHITE);

        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBorder(border);
        topPanel.setBackground(Color.BLACK);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBorder(border);
        bottomPanel.setBackground(Color.BLACK);

        itemListModel = new DefaultListModel<>();
        roomList = new JList<>(itemListModel);
        roomList.setFont(UI.getFont("regular"));
        roomList.setBackground(Color.BLACK);
        roomList.setForeground(Color.WHITE);

        roomList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {

                    if (state != State.IDLE) return;
                    // Get the selected value from the JList
                    String selectedValue = roomList.getSelectedValue();

                    Room currentRoom = GameMap.getCurrentRoom();
                    NPC enemy = currentRoom.getNPC(selectedValue);
                    fight(enemy);
                }
            }
        });

        option1 = new Button("Option 1");
        option2 = new Button("Option 2");

        option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                roomList.clearSelection();

                if (state == State.IDLE && canExit) {

                    GameMap.enterNextRoom();
                    canExit = false;

                } else if (state == State.IDLE && !canExit) {

                    setText("There are enemies in the way!");

                } else if (state == State.TOTEM) {

                    takeTotem();
                    changeState(State.IDLE);

                } else if (state == State.LOOT) {

                    takeItem(lootItem1);
                    changeState(State.IDLE);
                }
            }
        }); 

        option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                roomList.clearSelection();

                if (state == State.IDLE && canExit) {

                    changeState(State.TOTEM);

                } else if (state == State.IDLE && !canExit) {

                    setText("There are enemies in the way!");

                } else if (state == State.TOTEM) {

                    setText("You decide to play it safe.");
                    changeState(State.IDLE);

                } else if (state == State.LOOT) {

                    takeItem(lootItem2);
                    changeState(State.IDLE);
                }
            }
        }); 

        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(border);
        leftPanel.setBackground(Color.BLACK);

        centerPanel = new JPanel();
        centerPanel.setBackground(Color.BLACK);

        nameLabel = new Label("");
        healthLabel = new Label("HP: 100");
        hungerLabel = new Label("Hunger: 100");
        roomLabel = new Label("Enemies");
        invLabel = new Label("Inventory");

        text = new JTextArea();
        text.setText("");
        text.setWrapStyleWord(true);
        text.setLineWrap(true);
        text.setOpaque(false);
        text.setEditable(false);
        text.setFocusable(false);
        text.setForeground(Color.WHITE);
        text.setFont(UI.getFont("regular"));

        topPanel.add(Box.createRigidArea(new Dimension(24, 0)));
        topPanel.add(nameLabel);
        topPanel.add(Box.createRigidArea(new Dimension(24, 0)));
        topPanel.add(healthLabel);
        topPanel.add(Box.createRigidArea(new Dimension(24, 0)));
        topPanel.add(hungerLabel);

        leftPanel.add(roomLabel);
        leftPanel.add(roomList);

        bottomPanel.add(option1);
        bottomPanel.add(option2);

        getPanel().add(topPanel, BorderLayout.NORTH);
        getPanel().add(leftPanel, BorderLayout.WEST);
        getPanel().add(bottomPanel, BorderLayout.SOUTH);
        getPanel().add(text, BorderLayout.CENTER);

    }

    private void changeState(State state) {
        
        this.state = state;

        if (this.state == State.IDLE) {

            if (hasTotem) {
                setOptions("Door", "Totem");
            } else {
                setOptions("Door");
            }

        } else if (this.state == State.TOTEM) {

            setText("The totem seems to have a magical air about it.");
            addTextLine("It's effects are unknown.");
            addTextLine("Would you still like to take it?");
            setOptions("Yes", "No");

        } else if (this.state == State.LOOT) {

            addTextLine("They dropped some loot!");
            addTextLine("Choose one to take.");
        }
    }

    private void fight(NPC enemy) {

        if (enemy != null) {

            setText("You fight the " + enemy.getType() + ".");

            while (enemy.getHealth() > 0) {

                int enemyAttack = enemy.attack();
                int playerAttack = Player.attack();

                addTextLine("The " + enemy.getType() + " deals " + enemyAttack + " damage.");
                Player.setHealth(Player.getHealth() - enemyAttack);
                updateHPLabel();

                if (Player.getHealth() <= 0) {
                    changeState(State.IDLE);         
                    Engine.switchScene("Lose Scene"); 
                }

                addTextLine("You deal " + playerAttack + " damage. (-5 Hunger)");
                Player.setHunger(Player.getHunger() - 5);
                updateHungerLabel();
                enemy.hit(playerAttack);

            }

            addTextLine("You have defeated the " + enemy.getType() + ".");
            removeNPC(enemy);
                
            lootItem1 = randomItem();
            lootItem2 = randomItem();
            // Make sure the second item is different.
            while (lootItem2.getName() == lootItem1.getName()) {
                lootItem2 = randomItem();
            }

            setOptions(lootItem1.getName(), lootItem2.getName());
            changeState(State.LOOT);

        }

    }

    private Item randomItem() {

        Random rand = new Random();
        int itemType = rand.nextInt(6) + 1;
        System.err.println(itemType);
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

    private void takeItem(Item item) {

        if (item.getName() == "Bread") {

            setText(item.getDescription());
            addTextLine("You take the bread.");
            addTextLine("You feel a little less hungry. (+5 Hunger)");
            Player.setHunger(Math.min(Player.getHunger() + 5, 100));
            updateHungerLabel();

        } else if (item.getName() == "Health Potion") {

            setText(item.getDescription());
            addTextLine("You take the health potion.");
            addTextLine("You feel a bit better. (+10 HP)");
            Player.setHealth(Math.min(Player.getHealth() + 10, 100));
            updateHPLabel();

        } else if (item.getName() == "Combo Potion") {

            setText(item.getDescription());
            addTextLine("You take the potion.");
            addTextLine("You feel a little less hungry. (+10 Hunger)");
            addTextLine("You feel a bit better. (+10 HP)");
            Player.setHealth(Math.min(Player.getHealth() + 10, 100));
            Player.setHunger(Math.min(Player.getHunger() + 10, 100));
            updateHPLabel();
            updateHungerLabel();
        }
    }

    private void takeTotem() {

        Random rand = new Random();
        int goodOrBad = rand.nextInt(10 - 0 + 1);

        if (goodOrBad >= 6) {
            setText("A sharp pain shoots through your body.");
            addTextLine("You feel weakened. (-10 HP)");
            Player.setHealth(Player.getHealth() - 10);
            updateHPLabel();

            if (Player.getHealth() <= 0) {
                changeState(State.IDLE);         
                Engine.switchScene("Lose Scene"); 
            }
        } else {
            setText("Your body tingles.");
            addTextLine("You feel revived! (+10 HP)");
            Player.setHealth(Math.min(Player.getHealth() + 10, 100));
            healthLabel.setText("HP: " + Player.getHealth());
            updateHPLabel();
        }

        hasTotem = false;
    }

    public static void addNPC(NPC npc) {
        // roomItems.add(item);
        itemListModel.addElement(npc.getType());
    }

    public void removeNPC(NPC npc) {
        itemListModel.removeElement(npc.getType());
        if (itemListModel.size() <= 0) {
            canExit = true;
        }
    }

    public static void setHasTotem(boolean has) {
        hasTotem = has;
    }

    public static void resetRoomItems() {
        itemListModel.clear();
    }

    public static void setPlayerName(String name) {
        nameLabel.setText(name); 
    }

    public static void setText(String str) {
        text.setText(str);
    }

    public static void addTextLine(String str) {
        text.setText(text.getText() + "\n" + str);
    }

    public static void updateHPLabel() {
        healthLabel.setText("HP: " + Player.getHealth());
    }

    public static void updateHungerLabel() {
        hungerLabel.setText("Hunger: " + Player.getHunger());
    }

    public static void setOptions(String opt) {
        
        option1.setVisible(true);
        option2.setVisible(false);

        option1.setText(opt);
    }
    
    public static void setOptions(String opt, String opt2) {
        
        option1.setVisible(true);
        option2.setVisible(true);

        option1.setText(opt);
        option2.setText(opt2);
    }
}
