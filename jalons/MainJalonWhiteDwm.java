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

    // à delete
    String[] types = {"Viande", "Légume", "Féculant", "Fruit", "Laitage", "Poisson", "Dessert", "Pâtisserie", "Boulangerie"};    

    String t = "type";
    String[][] categorys_alimentary = {
        // mark, model, price, ref
        {t,     "Viande",        "",     ""},
        {t,     "Légume",        "",     ""},
        {t,     "Féculant",      "",     ""},
        {t,     "Fruit",         "",     ""},
        {t,     "Laitage",       "",     ""},
        {t,     "Poisson",       "",     ""},
        {t,     "Dessert",       "",     ""},
        {t,     "Pâtisserie",    "",     ""},
        {t,     "Boulangerie",   "",     ""}
    };  

    String[][][] all_categorys = {categorys_alimentary};



    myfunctions.rwkTxtStringV2("Bienvenue dans l'inventaire de votre supérette :\n", false, false);
    String[] details_txt = {
        "Voulez-vous ? (A) Ajouter un article | (B) Supprimer un article | (Y) Rechercher un article | (W) Afficher la liste d'articles | (X) Quitter", 
        "", 
    };

    int index = 0;
    ArrayList<String> inventory = new ArrayList<>();
    inventory = myfunctions.rwkSwitchCase(inventory, index, types, sector, duration, unit, onsale, reduce, all_categorys, details_txt);
    }
}