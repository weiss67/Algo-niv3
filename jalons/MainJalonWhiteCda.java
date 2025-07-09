package jalons;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import methods.myfunctions;

public class MainJalonWhiteCda {
    public static void main(String[] args) {

    String sector = "ECOMMERCE";
    ChronoUnit unit = ChronoUnit.MONTHS; // Quel type de temps ?
    int duration = 4; // Nombre en unité temps
    
    //Non cumul 
    int onsale = 40; //% en solde
    int reduce = 10; //% en reduction

    String[] types = {"TV", "Electro-ménager", "Micro-Informatique", "Audio"};    

    myfunctions.rwkTxtStringV2("Bienvenue dans l'inventaire du site ecommerce ElectroDepot :\n", false, false);
    String[] details_txt = {
        "Voulez-vous ? (A) Ajouter un article | (B) Supprimer un article | (Y) Rechercher un article | (W) Afficher la liste d'articles | (X) Quitter", 
        "", 
    };

    int index = 0;
    ArrayList<String> inventory = new ArrayList<>();
    inventory = myfunctions.rwkSwitchCase(inventory, index, types, sector, duration, unit, onsale, reduce, null, details_txt);
    }
}

// voir aussi pour le mdp et id