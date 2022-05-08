package Sprites;


import Storage.Inventory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Player extends Sprite{
    private Inventory inventory;
    private String weapon;
    Random rand = new Random();

    public Player(String name, int health, String weapon) {
        super(name, health);
        setWeapon(weapon);
    }


    public String getWeapon() {
        return weapon;
    }

    /**
     * Validation for weapon needs to be in the ArrayList of ["Spork","Wooden Stick",
     * "Baseball Bat", "Tennis Racket",
     * "Sword", "Spiked Ball",
     * "Golden Spoon", "Legendary Hammer"]
     * @param weapon
     */
    public void setWeapon(String weapon) {
        weapon = weapon.trim();
        List<String> weaponNames = Arrays.asList("Spork","Wooden Stick","Tennis Racket", "Baseball Bat", "Dagger", "Sword", "Spiked Ball",
                  "Legendary Hammer", "Golden Spoon");
        if(weaponNames.contains(weapon))
            this.weapon = weapon;
        else
            throw new IllegalArgumentException(String.format("The weapon must be one of %s",weaponNames));
    }

    /**
     * Returns a random int in a set range based on which weapon the Player is holding
     * @return
     */
    public int attack(){

        return switch (getWeapon()) {
            case "Spork", "Wooden Stick" -> rand.nextInt(6, 15);
            case "Tennis Racket", "Baseball Bat" -> rand.nextInt(8, 17);
            case "Dagger", "Sword" -> rand.nextInt(10, 19);
            case "Spiked Ball" -> rand.nextInt(7, 24);
            case "Legendary Hammer" -> rand.nextInt(15, 30);
            case "Golden Spoon" -> rand.nextInt(1, 60);
            default -> 0;
        };
    }

    /**
     * If there are hpPotion's in the inventory
     * Player's health will go up by a random number between 20-50,
     * hpPotion amount in the inventory will go down by 1
     * Message will display to the console
     */
    public void heal(){
        int currentPotions = inventory.getHpPotion();
        int healAmount = rand.nextInt(20,51);
        if(inventory.getHpPotion() > 0) {
            currentPotions -= 1;
            inventory.setHpPotion(currentPotions);
            health += healAmount;
            if(health > 100)
                health = 100;
            //Show how much health the player healed
            System.out.printf("%s healed for %d hp!\nYou now have %d hp.", getName(), healAmount, getHealth());

        }


    }
}
