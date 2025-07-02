package jalons;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import methods.myfunctions;

public class MainJalonGreenCda {

    // configuration des services, codes et prix (à voir aussi dans dealership)
    public static final List<myfunctions.Types> TYPES = Arrays.asList(
        new myfunctions.Types("Bilan de santé",        "BS", 120),
        new myfunctions.Types("Cardiologie",           "CD", 200),
        new myfunctions.Types("Vaccination",           "VC", 0),
        new myfunctions.Types("Certification médical", "CM", 120),
        new myfunctions.Types("Général",               "GN", 70),
        new myfunctions.Types("Suivi médical",         "SM", 60)
    );

    public static void main(String[] args) {

    String sector = "MEDICAL_OFFICE";
    ChronoUnit unit = ChronoUnit.DAYS; // Quel type de temps ?
    int duration = 3; // Nombre en unité temps
    int onsale = 25; //% en prise de charge pour mineur ou senior(60 ans)
    int reduce = 60; //% en prise de charge par défaut

    String[] types = {
        "Bilan de santé", 
        "Cardiologie", 
        "Vaccination", 
        "Certification médical",
        "Général",
        "Suivi médical",
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