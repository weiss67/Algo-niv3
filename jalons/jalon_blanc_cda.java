package jalons;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import methods.myfunctions;

public class jalon_blanc_cda {
    public static void main(String[] args) {

    String sector = "ECOMMERCE";
    ChronoUnit unit = ChronoUnit.MONTHS; // Quel type de temps ?
    int duration = 4; // Nombre en unité temps
    
    //Non cumul 
    int onsale = 40; //% en solde
    int reduce = 10; //% en reduction

    String[] types = {"TV", "Electro-ménager", "Micro-Informatique", "Audio"};    
    //myfunctions.rwkLoopArrays(types);
    int index = 0;
    ArrayList<String> inventory = new ArrayList<>();
    inventory = myfunctions.rwkSwitchCase(inventory, index, types, sector, duration, unit, onsale, reduce, null);
    }
}

// voir aussi pour le mdp et id