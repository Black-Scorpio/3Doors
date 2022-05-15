package Storage;

public class Inventory {
    private int hpPotion;
    private int gold;

    public Inventory(int hpPotion, int gold) {
        setHpPotion(hpPotion);
        setGold(gold);
    }

    public int getHpPotion() {
        return hpPotion;
    }

    /**
     * Validation for hpPotion must be equal to or greater than 0
     * @param hpPotion
     */
    public void setHpPotion(int hpPotion) {
        if(hpPotion >=0)
            this.hpPotion = hpPotion;
        else
            throw new IllegalArgumentException("The hpPotion must be greater than or equal to 0");
    }

    public int getGold() {
        return gold;
    }

    /**
     * Validation for gold must be equal to or greater than 0
     * @param gold
     */
    public void setGold(int gold) {
        if(gold >= 0)
            this.gold = gold;
        else
            throw new IllegalArgumentException("Gold must be equal to 0 or higher");
    }

    /**
     * Display hpPotions and gold amount
     */

    public void checkInventory(){
        System.out.printf("You have %d hp potion(s)\nYou have %d gold", getHpPotion(),getGold());
    }
}
