package Sprites;

import java.util.Arrays;
import java.util.List;

public class Player extends Sprite{
    private int hpPotion; // stores the amount of hpPotions available
    private String weapon;


    public Player(String name, int health, int hpPotion, String weapon) {
        super(name, health);
        setHpPotion(hpPotion);
        setWeapon(weapon);
    }

    public int getHpPotion() {
        return hpPotion;
    }

    /**
     * Validation for hpPotion must be equal to or greater than 0
     * @param hpPotion
     */
    public void setHpPotion(int hpPotion) {
        if(hpPotion >=0)
            this.hpPotion = hpPotion;
        else
            throw new IllegalArgumentException("The hpPotion must be greater than or equal to 0");
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
        List<String> weaponNames = Arrays.asList("Spork","Wooden Stick", "Baseball Bat", "Golden Spoon", "Sword", "Spiked Ball",
                 "Tennis Racket", "Legendary Hammer");
        if(weaponNames.contains(weapon))
            this.weapon = weapon;
        else
            throw new IllegalArgumentException(String.format("The weapon must be one of %s",weaponNames));
    }
}
