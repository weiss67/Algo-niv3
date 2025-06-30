package jalons;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import methods.myfunctions;

public class jalon_blanc_cda {
    public static void main(String[] args) {

    boolean alimentary = false;
    ChronoUnit unit = ChronoUnit.MONTHS; // Quel type de temps ?
    int duration = 4; // Nombre en unité temps

    String[] types = {"TV", "Electro-ménager", "Micro-Informatique", "Audio"};    
    //myfunctions.rwkLoopArrays(types);
    int index = 0;
    ArrayList<String> inventory = new ArrayList<>();
    inventory = myfunctions.rwkSwitchCase(inventory, index, types, alimentary, duration, unit);
    }
}