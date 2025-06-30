package jalons;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import methods.myfunctions;

public class jalon_blanc_dwm {
    public static void main(String[] args) {

    boolean alimentary = true;
    ChronoUnit unit = ChronoUnit.DAYS; // Quel type de temps ?
    int duration = 3; // Nombre en unité temps

    String[] types = {"Viande", "Légume", "Féculant", "Fruit", "Laitage", "Poisson", "Dessert", "Pâtisserie", "Boulangerie"};    
    //myfunctions.rwkLoopArrays(types);
    int index = 0;
    ArrayList<String> inventory = new ArrayList<>();
    inventory = myfunctions.rwkSwitchCase(inventory, index, types, alimentary, duration, unit);
    }
}