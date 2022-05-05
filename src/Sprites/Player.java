package Sprites;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Player extends Sprite{
    private int hpPotion;
    private String weapon;


    public Player(String name, int health, int hpPotion, String weapon) {
        super(name, health);
        setHpPotion(hpPotion);
        setWeapon(weapon);
    }

    public int getHpPotion() {
        return hpPotion;
    }

    public void setHpPotion(int hpPotion) {
        this.hpPotion = hpPotion;
    }

    public String getWeapon() {
        return weapon;
    }

    /**
     * Validation for weapon needs to be in the ArrayList of ["Spork","Wooden Stick", "Baseball Bat", "Golden Spoon", "Sword", "Spiked Ball",
     * "Tennis Racket", "Legendary Hammer"]
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
