package Sprites;


import Storage.Inventory;
import Storage.Store;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Player extends Sprite{
    private final Inventory inventory;
    private Store store;
    private String weapon;
    Random rand = new Random();

    public Player(String name, int health, String weapon) {
        super(name, health);
        setWeapon(weapon);
        inventory = new Inventory(2,0); // Start with 2 hpPotions and 0 gold
        store = new Store(10); // Store contains 10 potions to purchase
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
        List<String> weaponNames = Arrays.asList("Spork","Wooden Stick","Tennis Racket", "Baseball Bat", "Dagger", "Sword", "Spiked Ball",
                  "Legendary Hammer", "Golden Spoon");
        if(weaponNames.contains(weapon))
            this.weapon = weapon;
        else
            throw new IllegalArgumentException(String.format("The weapon must be one of %s",weaponNames));
    }

    /**
     * Returns a random int in a set range based on which weapon the Player is holding
     * @return
     */
    public int attack(){

        return switch (getWeapon()) {
            case "Spork", "Wooden Stick" -> rand.nextInt(6, 15);
            case "Tennis Racket", "Baseball Bat" -> rand.nextInt(8, 17);
            case "Dagger", "Sword" -> rand.nextInt(10, 19);
            case "Spiked Ball" -> rand.nextInt(7, 24);
            case "Legendary Hammer" -> rand.nextInt(15, 30);
            case "Golden Spoon" -> rand.nextInt(1, 60);
            default -> 0;
        };
    }

    /**
     * If there are hpPotion's in the inventory
     * Player's health will go up by a random number between 20-50,
     * hpPotion amount in the inventory will go down by 1
     * Message will display to the console
     */
    public void heal(){
        int currentPotions = inventory.getHpPotion();
        int healAmount = rand.nextInt(20,51);
        if(inventory.getHpPotion() > 0) {
            currentPotions -= 1;
            inventory.setHpPotion(currentPotions);
            health += healAmount;
            if(health > 100)
                health = 100;
            //Show how much health the player healed
            System.out.printf("\n%s healed for %d hp!\nYou now have %d hp.", getName(), healAmount, getHealth());

        }


    }

    /**
     * Purchase a weapon from the Store if the Player Inventory has enough gold
     * @param weapon - String weapon to purchase from switch statement
     *
     */
    public void buyWeapon(String weapon){
        switch(weapon){
            case "Spork", "Wooden Stick":
                if(inventory.getGold() >= 3){
                    inventory.setGold(inventory.getGold() - 3);
                    System.out.printf("You've successfully purchased a %s, you now have %d gold",weapon, inventory.getGold());
                    setWeapon(weapon);
                }
                else
                    System.out.printf("You cannot afford a %s, you have %d gold.", weapon, inventory.getGold());
                break;
            case "Tennis Racket", "Baseball Bat":
                if(inventory.getGold() >= 6){
                    inventory.setGold(inventory.getGold() - 6);
                    System.out.printf("You've successfully purchased a %s, you now have %d gold",weapon, inventory.getGold());
                    setWeapon(weapon);
                }
                else
                    System.out.printf("You cannot afford a %s, you have %d gold.", weapon, inventory.getGold());
                break;
            case "Dagger", "Sword":
                if(inventory.getGold() >= 10){
                    inventory.setGold(inventory.getGold() - 10);
                    System.out.printf("You've successfully purchased a %s, you now have %d gold",weapon, inventory.getGold());
                    setWeapon(weapon);
                }
                else
                    System.out.printf("You cannot afford a %s, you have %d gold.", weapon, inventory.getGold());
                break;
            case "Spiked Ball":
                if(inventory.getGold() >= 13){
                    inventory.setGold(inventory.getGold() - 13);
                    System.out.printf("You've successfully purchased a %s, you now have %d gold",weapon, inventory.getGold());
                    setWeapon(weapon);
                }
                else
                    System.out.printf("You cannot afford a %s, you have %d gold.", weapon, inventory.getGold());
                break;

            case "Legendary Hammer":
                if(inventory.getGold() >= 20){
                    inventory.setGold(inventory.getGold() - 20);
                    System.out.printf("You've successfully purchased a %s, you now have %d gold",weapon, inventory.getGold());
                    setWeapon(weapon);
                }
                else
                    System.out.printf("You cannot afford a %s, you have %d gold.", weapon, inventory.getGold());
                break;

            case "Golden Spoon":
                if(inventory.getGold() >= 30){
                    inventory.setGold(inventory.getGold() - 30);
                    System.out.printf("You've successfully purchased a %s, you now have %d gold",weapon, inventory.getGold());
                    setWeapon(weapon);
                }
                else
                    System.out.printf("You cannot afford a %s, you have %d gold.", weapon, inventory.getGold());
                break;
            default:
                break;
        }

        }//end of buyWeapon method

    /**
     * Has a chance to
     * randomly add an amount to the Player's Inventory
     */
    public void goldFound(){
        int diceRoll = rand.nextInt(1,7);
        int foundGold;

        if(diceRoll <= 3) {
            foundGold = rand.nextInt(1,5);
            inventory.setGold(inventory.getGold() + foundGold);
            System.out.printf("\nYou've found %d gold!", foundGold);
        }
        else if(diceRoll == 6){
            foundGold = rand.nextInt(7,15);
            inventory.setGold(inventory.getGold() + foundGold);
            System.out.printf("\nIt's your lucky day you've found %d gold!", foundGold);
        }
    }//end of goldFound class

}//end of class
