package Sprites.Monsters;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HardMonster extends Monsters{
    public HardMonster(String name, int health) {
        super(name, health);
    }

    /**
     * Name must be one of "Angry Goat","Pirate","Monkey","Janguar","Ape","Goblin","Troll","Magician"
     * @param name - String
     */

    @Override
    public void setName(String name){
        List<String> hardNames = Arrays.asList("Angry Goat","Pirate","Monkey","Janguar","Ape","Goblin","Troll","Magician");
        if(hardNames.contains(name))
            this.name = name;
        else
            throw new IllegalArgumentException("The name " + name + "is not one of " + hardNames);

    }

    /**
     * Amount of damage the Monster will hit
     * @return - int
     */

    @Override
    public int attack() {
        Random rand = new Random();
        return rand.nextInt(10,25);
    }

    public int magicAttack(){
        Random rand = new Random();
        return rand.nextInt(13,34);
    }
}
