package Game;

import java.util.ArrayList;
import java.util.Random;
public class NPC {
    public static int main(String [] args) {
        ArrayList<String> NPC = new ArrayList<>();//adding the multiple NPCs to the list
        {
            NPC.add("skeleton");
            NPC.add("slime");
            NPC.add("zombie");
            NPC.add("undead mage");
        }
        int min=3; //min and max number in order for damage roll
        int max=8;

        int attack(min, max) {
            Random random = new Random();
            return random.ints(min, max)
                    .findFirst()
                    .getAsInt();
        }
    }
}
