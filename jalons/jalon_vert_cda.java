package jalons;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import methods.myfunctions;

public class jalon_vert_cda {
    public static void main(String[] args) {

    String sector = "MEDICAL_OFFICE";
    ChronoUnit unit = ChronoUnit.DAYS; // Quel type de temps ?
    int duration = 3; // Nombre en unité temps
    int onsale = 25; //% en prise de charge pour mineur ou senior(60 ans)
    int reduce = 60; //% en prise de charge par défaut

    String[] types = {
        "Bilan de santé (Code BS, prix : 120 euros)", 
        "Cardiologie (Code CD, prix : 200 euros)", 
        "Vaccination (Code VC, gratuit)", 
        "Certification médical (Code CM, prix : 120 euros)",
        "Général (Code GN, prix : 70 euros)",
        "Suivi médical (Code SM, prix : 60 euros)",
    };

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