package Sprites;

public abstract class Sprite {
    protected String name;
    protected int health;

    public Sprite(String name, int health) {
        setName(name);
        setHealth(health);
    }

    public String getName() {
        return name;
    }

    /**
     * Validation for creating a name must be between 2-20 characters in length
     * @param name - String
     */
    public void setName(String name) {
        name = name.trim();
        if (name.length()>=2 && name.length()<=20)
            this.name = name;
        else
            throw new IllegalArgumentException("Name must be between 2-20 characters in length");
    }

    public int getHealth() {
        return health;
    }

    /**
     * Validation for health must be between 0-200
     * @param health - int
     */
    public void setHealth(int health) {
        if(health >= 0 && health <= 200)
            this.health = health;
        else
            throw new IllegalArgumentException("The health points must be between 0-200 inclusive");
    }
}
