package jalons;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import methods.myfunctions;

public class MainJalonGreenDwm {

    public static void main(String[] args) {

    String sector = "DEALERSHIP";

    ChronoUnit unit = ChronoUnit.DAYS; // Quel type de temps ?
    int duration = 3; // Nombre en unité temps

    int onsale = 25; //% en reduction dès 100 000 KM
    int reduce = 50; //% en reduction dès 200 000 KM

    String[] types = {""}; // à nettoyer et retirer

    String vkw = "VOLKSWAGEN"; String abt = "AUDI"; String prc = "PORSCHE"; String lbg = "LAMBORGHINI"; String € = "euros";
    String[][] categorys_vehicles = {
        // mark, model, price, money, ref
        {vkw,     "Golf",         "29000",    €},
        {vkw,     "Tiguan",       "36000",    €},
        {vkw,     "Polo",         "23000",    €},

        {abt,     "A3",           "34000",    €},
        {abt,     "Q5",           "54000",    €},
        {abt,     "A4",           "43000",    €},

        {prc,     "Macan",        "70000",    €},
        {prc,     "911 Carrera",  "120000",   €},

        {lbg,     "Aventador",    "520000",   €},
        {lbg,     "Huracan",      "260000",   €}
    };

    String cm = "couleur métalisée";
    String[][] categorys_colors ={
        {cm,      "Blanc",      "500",      ""},
        {cm,      "Noir",       "0",        ""},
        {cm,      "Rouge",      "2000",     ""},
        {cm,      "Bleu",       "1000",     ""}
    };    

    String[][][] all_categorys = {categorys_vehicles, categorys_colors};

    myfunctions.rwkTxtStringV2("Bienvenue dans l'inventaire de votre concession :\n", false, false);
    String[] details_txt = {
        "(A) Ajouter une voiture\n(B) Supprimer une voiture\n(Y) Rechercher une voiture\n(W) Afficher la liste de voitures\n(X) Quitter", 
        "", 
    };
    
    int index = 0;
    ArrayList<String> inventory = new ArrayList<>();
    inventory = myfunctions.rwkSwitchCase(inventory, index, types, sector, duration, unit, onsale, reduce, all_categorys, details_txt);
    }
}