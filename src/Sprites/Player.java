package Sprites;


import Sprites.Monsters.Monsters;
import Storage.Inventory;
import Storage.Store;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Player extends Sprite{
    private final Inventory inventory;
    private Store store;
    private String weapon;
    Random rand = new Random();
    Scanner in = new Scanner(System.in);
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
        if(inventory.getHpPotion() > 0 && getHealth() < 100) {
            currentPotions -= 1;
            inventory.setHpPotion(currentPotions);
            health += healAmount;
            if(health > 100)
                health = 100;
            //Show how much health the player healed
            System.out.printf("\n%s healed for %d hp!\nYou now have %d HP.", getName(), healAmount, getHealth());

        }
        else if(getHealth() == 100){
            System.out.println("You already have full HP!");
        }
        else if(inventory.getHpPotion() == 0){
            System.out.println("\nYou have no more health potions left...uh oh.");
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

    /**
     * Entering combat with a monster until either it's health goes to 0 or Player's health goes to 0
     * @param monster
     */
    public void fightMonster(Monsters monster){
        System.out.printf("You've ran into a %s, time to fight!\n", monster.getName());

        int userSelection;
        while(getHealth() > 0 && monster.getHealth() > 0){
            System.out.println("\nMake a choice, enter a number: \n1.Attack\n2.Use health potion\n3.Check inventory\n");
            userSelection = in.nextInt();
            //Fight
            if(userSelection == 1){
                int playerDamage = attack();
                int monsterDamage = monster.attack();
                //Player attack monster
                monster.setHealth(monster.getHealth() - playerDamage);
                if(monster.getHealth() > 0){
                    System.out.printf(">>You attack the %s for %d damage! The %s now has %d HP!\n\n", monster.getName(), playerDamage,monster.getName() ,monster.getHealth());
                    setHealth(getHealth() - monsterDamage);
                    //Monster attacks player
                    System.out.printf(">>The %s attacks you for %d damage! You now have %d HP!", monster.getName(),monsterDamage, getHealth());
                    //Check if player is alive or dead
                    if(getHealth() == 0){
                        System.out.println(">>You suffered a fatal blow! You now have 0 HP! You have died...GAME OVER");
                        System.exit(0);
                    }
                }
                else {
                    System.out.printf(">>You attack the %s for %d damage! The %s now has %d HP!\nYou have slain the %s!",
                            monster.getName(), playerDamage,monster.getName() ,monster.getHealth(), monster.getName());
                    goldFound();
                }
            }
            else if(userSelection == 2){
                heal();
            }
            else if(userSelection == 3){
                inventory.checkInventory();
            }

        }
    }


}//end of class
