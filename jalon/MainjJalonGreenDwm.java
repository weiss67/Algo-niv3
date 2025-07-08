package jalon;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class MainjJalonGreenDwm {

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

    String[][] categorys_vehicles = {
        // mark, model, price
        {"VOLKSWAGEN",      "Golf",         "29000"},
        {"VOLKSWAGEN",      "Tiguan",       "36000"},
        {"VOLKSWAGEN",      "Polo",         "23000"},

        {"AUDI",            "A3",           "34000"},
        {"AUDI",            "Q5",           "54000"},
        {"AUDI",            "A4",           "43000"},

        {"PORSCHE",         "Macan",        "70000"},
        {"PORSCHE",         "911 Carrera",  "120000"},

        {"LAMBORGHINI",     "Aventador",    "520000"},
        {"LAMBORGHINI",     "Huracan",      "260000"}
    };

    String[][] categorys_colors ={
        {"Metal",      "Blanc",      "500"},
        {"Metal",      "Noir",       "0"},
        {"Metal",      "Rouge",      "2000"},
        {"Metal",      "Bleu",       "1000"}
    };    

    String[][][] all_categorys = {categorys_vehicles, categorys_colors};

    String[] details_txt = {
        "Bienvenue dans l'inventaire de votre concession :\n(A) Ajouter une voiture\n(B) Supprimer une voiture\n(Y) Rechercher une voiture\n(W) Afficher la liste de voitures\n(X) Quitter", 
        "", 
    };
    
    int index = 0;
    ArrayList<String> inventory = new ArrayList<>();
    //inventory = myfunctions.rwkSwitchCase(inventory, index, types, sector, duration, unit, onsale, reduce, vehicles_autos, details_txt);
    inventory = myfunctions.rwkSwitchCase(inventory, index, types, sector, duration, unit, onsale, reduce, all_categorys, details_txt);
    }
}