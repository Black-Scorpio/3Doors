package Storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {
    private List<String> weaponsInStore;
    private int hpPotionsStore = 10; // the store will hold 10 hpPotions


    public Store(int hpPotionsStore) {
        weaponsInStore = Arrays.asList("Spork","Wooden Stick","Tennis Racket", "Baseball Bat", "Dagger", "Sword", "Spiked Ball",
                "Legendary Hammer", "Golden Spoon"); // list of weapons to buy
        setHpPotionsStore(hpPotionsStore);
    }

    public int getHpPotionsStore() {
        return hpPotionsStore;
    }

    public void setHpPotionsStore(int hpPotionsStore) {
        if(hpPotionsStore >= 0)
            this.hpPotionsStore = hpPotionsStore;
        else
            throw new IllegalArgumentException("The hpPotionsStore must be 0 or more");
    }

    public void displayInventory(){
        int spork = 3;
        int woodenStick = 3;
        int tennisRacket = 6;
        int baseballBat = 6;
        int dagger = 10;
        int sword = 10;
        int spikedBall = 13;
        int legendaryHammer = 20;
        int goldenSpoon = 30;
        System.out.printf("Weapons:\n%s\nCost:\n[%d,\t %d, \t%d, \t%d, \t%d, \t%d, \t%d, \t%d, \t%d\nHp Potions: %d]\nCost: 5 Gold",weaponsInStore,spork,woodenStick,tennisRacket,baseballBat
                ,dagger,sword,spikedBall,legendaryHammer,goldenSpoon,hpPotionsStore);
    }

}
