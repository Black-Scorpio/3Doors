package Sprites;

import java.util.Arrays;
import java.util.List;

public class Player extends Sprite{
    private String weapon;


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
        List<String> weaponNames = Arrays.asList("Spork","Wooden Stick", "Baseball Bat", "Golden Spoon", "Sword", "Spiked Ball",
                 "Tennis Racket", "Legendary Hammer");
        if(weaponNames.contains(weapon))
            this.weapon = weapon;
        else
            throw new IllegalArgumentException(String.format("The weapon must be one of %s",weaponNames));
    }
}
