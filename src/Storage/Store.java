package Storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {
    private List<String> weaponsInStore;
    private int hpPotionsStore = 10;

    /** FIX CLASS **/
    public Store(int hpPotionsStore) {
        weaponsInStore = Arrays.asList("Spork","Wooden Stick","Tennis Racket", "Baseball Bat", "Dagger", "Sword", "Spiked Ball",
                "Legendary Hammer", "Golden Spoon");
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



}
