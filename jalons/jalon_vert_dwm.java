package jalons;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import methods.myfunctions;

public class jalon_vert_dwm {
    public static void main(String[] args) {

    String sector = "DEALERSHIP";
    ChronoUnit unit = ChronoUnit.DAYS; // Quel type de temps ?
    int duration = 3; // Nombre en unité temps
    int onsale = 25; //% en reduction dès 100 000 KM
    int reduce = 50; //% en reduction dès 200 000 KM

    String[] types = {"Blanc", "Noir", "Rouge", "Bleu"};

    String[][] vehicles_autos = {
        {"VOLKSWAGEN",      "Golf", "Tiguan", "Polo"},
        {"AUDI",            "A3", "Q5", "A4"},
        {"PORSCHE",         "Macan", "911 Carrera"},
        {"LAMBORGHINI",     "Aventador", "Huracan"}
    };
    
    int index = 0;
    ArrayList<String> inventory = new ArrayList<>();
    inventory = myfunctions.rwkSwitchCase(inventory, index, types, sector, duration, unit, onsale, reduce, vehicles_autos);
    }
}