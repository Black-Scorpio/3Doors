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

    @Override
    public void setName(String name){

        List<String> smallNames = Arrays.asList("Snake","Rat","Chicken","Raccoon");
    }

    @Override
    int attack() {
        Random rand = new Random();
        return rand.nextInt(3,12);
    }


}
