package Sprites.Monsters;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Boss extends Monsters{
    public Boss(String name, int health) {
        super(name, health);
    }
    /**
     * Name must be one of "Green Dragon", "Fiery Toby the Hound", "Frozen Yogurt King"
     * @param name - String
     */
    @Override
    public void setName(String name){

        List<String> smallNames = Arrays.asList("Green Dragon", "Fiery Toby the Hound", "Frozen Yogurt King");
        if(smallNames.contains(name))
            this.name = name;
        else
            throw new IllegalArgumentException("The name " + name + "is not one of " + smallNames);
    }

    @Override
    public void setHealth(int health) {
        if(health >= 0 && health <= 200)
            this.health = health;
        else if(health < 0)
            this.health = 0;
        else
            throw new IllegalArgumentException("The health points must be between 0-200 inclusive");
    }

    /**
     * Amount of damage the Monster will hit
     * @return - int
     */

    @Override
    public int attack() {
        Random rand = new Random();
        return switch (getName()) {
            case "Green Dragon" -> rand.nextInt(10, 15);
            case "Fiery Toby the Hound" -> rand.nextInt(10, 25);
            case "Frozen Yogurt King" -> rand.nextInt(5, 20);
            default -> rand.nextInt(1, 7);
        };
    }

    /**
     * Amount of magic damage the Monster will hit
     * @return - int
     */
    public int magicAttack(){
        Random rand = new Random();
        return switch (getName()) {
            case "Green Dragon" -> rand.nextInt(15, 25);
            case "Fiery Toby the Hound" -> rand.nextInt(5, 15);
            case "Frozen Yogurt King" -> rand.nextInt(10, 30);
            default -> rand.nextInt(1, 7);
        };
    }

}//end class
