package Sprites.Monsters;

import Sprites.Sprite;

import java.util.Random;

public abstract class Monsters extends Sprite {

    public Monsters(String name, int health) {
        super(name, health);
    }

    /**
     * Amount of damage the Monster will hit
     * @return - int
     */
    abstract public int attack();

}
