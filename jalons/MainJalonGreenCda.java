package jalons;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import methods.myfunctions;

public class MainJalonGreenCda {

    // configuration des services, codes et prix (à voir aussi dans dealership)
    public static final List<myfunctions.TypeSelection > TYPES = Arrays.asList(
        new myfunctions.TypeSelection("","Bilan de santé",        "BS", 120),
        new myfunctions.TypeSelection("","Cardiologie",           "CD", 200),
        new myfunctions.TypeSelection("","Vaccination",           "VC", 0),
        new myfunctions.TypeSelection("","Certification médical", "CM", 120),
        new myfunctions.TypeSelection("","Général",               "GN", 70),
        new myfunctions.TypeSelection("","Suivi médical",         "SM", 60)
    );

    public static void main(String[] args) {

    String sector = "MEDICAL_OFFICE";
    ChronoUnit unit = ChronoUnit.DAYS; // Quel type de temps ?
    int duration = 3; // Nombre en unité temps
    int onsale = 25; //% en prise de charge pour mineur ou senior(60 ans)
    int reduce = 60; //% en prise de charge par défaut

    String[] types = {}; // à nettoyer car plus besoin mais MAJ à faire dans les autres mains
    
    // %s : String | %d : entier | %f : float/double
    // %.2f : nombre avec 2 décimales | %n : saut de ligne
    String[] txt = {
        "Exemple", 
        "textuel", 
    };

    String[][] vehicles_autos = {
        //{"VOLKSWAGEN",      "Golf", "Tiguan", "Polo"},
        //{"AUDI",            "A3", "Q5", "A4"},
        //{"PORSCHE",         "Macan", "911 Carrera"},
        //{"LAMBORGHINI",     "Aventador", "Huracan"}
    };

    String[] details_txt = {
        "Bienvenue dans listing de rendez-vous : \nVoulez-vous ? (A) Ajouter un RDV | (B) Supprimer un RDV | (Y) Rechercher un RDV | (W) Afficher la liste des RDV | (X) Quitter", 
        "", 
    };

    int index = 0;
    ArrayList<String> inventory = new ArrayList<>();
    inventory = myfunctions.rwkSwitchCase(inventory, index, types, sector, duration, unit, onsale, reduce, vehicles_autos, details_txt);
    }
}