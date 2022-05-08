package Sprites.Monsters;

import Sprites.Sprite;

import java.util.Random;

public abstract class Monsters extends Sprite {

    public Monsters(String name, int health) {
        super(name, health);
    }

    /**
     * Every instance of Monster will need to have an attack method
     * @return
     */
    abstract int attack();

}
