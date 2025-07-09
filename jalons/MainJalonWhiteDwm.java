package jalons;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import methods.myfunctions;

public class MainJalonWhiteDwm {
    public static void main(String[] args) {

    String sector = "ALIMENTARY";
    ChronoUnit unit = ChronoUnit.DAYS; // Quel type de temps ?
    int duration = 3; // Nombre en unité temps
    int onsale = 0; //% en solde
    int reduce = 20; //% en reduction

    String[] types = {"Viande", "Légume", "Féculant", "Fruit", "Laitage", "Poisson", "Dessert", "Pâtisserie", "Boulangerie"};    

    String[] details_txt = {
        "Bienvenue dans l'inventaire de votre concession : \nVoulez-vous ? (A) Ajouter une voiture | (B) Supprimer une voiture | (Y) Rechercher une voiture | (W) Afficher la liste de voitures | (X) Quitter", 
        "", 
    };

    int index = 0;
    ArrayList<String> inventory = new ArrayList<>();
    inventory = myfunctions.rwkSwitchCase(inventory, index, types, sector, duration, unit, onsale, reduce, null, details_txt);
    }
}