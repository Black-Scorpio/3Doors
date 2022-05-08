package Storage;

import java.util.ArrayList;

public class Store {
    private ArrayList<String> weaponsStore;
    private int hpPotionsStore;
    /** FIX CLASS **/
    public Store(int hpPotionsStore) {
        weaponsStore = new ArrayList<>();
        setHpPotionsStore(hpPotionsStore);
    }

    public int getHpPotionsStore() {
        return hpPotionsStore;
    }

    public void setHpPotionsStore(int hpPotionsStore) {
        this.hpPotionsStore = hpPotionsStore;
    }
}
