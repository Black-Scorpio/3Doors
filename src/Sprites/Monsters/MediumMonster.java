package Sprites.Monsters;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MediumMonster extends Monsters{
    public MediumMonster(String name, int health) {
        super(name, health);
    }

    /**
     * Name must be one of "Angry Goat","Pirate","Monkey","Janguar","Ape","Goblin","Troll","Magician"
     * @param name - String
     */
    
    @Override
    public void setName(String name){
        List<String> mediumNames = Arrays.asList("Angry Goat","Pirate","Monkey","Janguar","Ape","Goblin","Troll","Magician");
        if(mediumNames.contains(name))
            this.name = name;
        else
            throw new IllegalArgumentException("The name " + name + "is not one of " + mediumNames);

    }

    /**
     * Amount of damage the Monster will hit
     * @return - int
     */

    @Override
    public int attack() {
        Random rand = new Random();
        return rand.nextInt(8,16);
    }
}
