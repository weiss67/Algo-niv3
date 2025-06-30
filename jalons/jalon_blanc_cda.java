package jalons;

import java.util.ArrayList;
import methods.myfunctions;

public class jalon_blanc_cda {
    public static void main(String[] args) {

    String[] types = {"TV", "Electro-ménager", "Micro-Informatique", "Audio", "Laitage", "Poisson", "Dessert", "Pâtisserie", "Boulangerie"};    
    //myfunctions.rwkLoopArrays(types);
    int index = 0;
    ArrayList<String> inventory = new ArrayList<>();
    inventory = myfunctions.rwkSwitchCase(inventory, index, types);
    }
}