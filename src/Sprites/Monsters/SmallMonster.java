package Sprites.Monsters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SmallMonster extends Monsters{
    public SmallMonster(String name, int health) {
        super(name, health);
        setName(name);
    }

    /**
     * Name must be one of "Snake","Rat","Chicken","Raccoon"
     * @param name - String
     */
    @Override
    public void setName(String name){

        List<String> smallNames = Arrays.asList("Snake","Rat","Chicken","Raccoon");
        if(smallNames.contains(name))
            this.name = name;
        else
            throw new IllegalArgumentException("The name " + name + "is not one of " + smallNames);
    }

    /**
     * Amount of damage the Monster will hit
     * @return - int
     */

    @Override
    public int attack() {
        Random rand = new Random();
        return rand.nextInt(3,10);
    }


}
