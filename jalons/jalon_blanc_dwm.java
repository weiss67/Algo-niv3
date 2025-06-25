package jalons;

import java.util.ArrayList;
import methods.myfunctions;

public class jalon_blanc_dwm {
    public static void main(String[] args) {

    String[] TypeAliment = {"Viande", "Légume", "Féculant", "Fruit", "Laitage", "Poisson", "Dessert", "Pâtisserie", "Boulangerie"};    
    myfunctions.rwkLoopArrays(TypeAliment);

    int index = 0;
    ArrayList<String> inventory = new ArrayList<>();
    inventory = myfunctions.rwkSwitchCase(inventory, index);

    //myfunctions.rwkTxtString("TEST "+myfunctions.rwkDateTime("Veuillez afficher ", "1", ""), false, false);

    // myfunctions.rwkTxtString("Voulez-vous ? (A) Ajouter un nouvel article | (B) Supprimer un article | (Y) Chercher un article | (X) Quitter", false, false);
    // String result = "";
    // Scanner sc = new Scanner(System.in);
    // String clavier = sc.nextLine().toUpperCase();
    // switch(clavier){// voir pour faire des nouvelles myfunctions assez indépendants pour utiliser en tout
    //     case "A": inventory = myfunctions.rwkAddItem(inventory, index); break;
    //     case "B": myfunctions.rwkTxtString("function rwkRmvItem", false, true);break;
    //     case "Y": myfunctions.rwkTxtString("function rwkearchitem", false, true); break;
    //     case "X": myfunctions.rwkTxtString("Game over", false, true); break;
    //     default: myfunctions.rwkTxtString("Veuillez répondre par (A), (B), (Y) ou (X)", false, true); 
    // }

    myfunctions.ListeDesNoms(inventory);

    // stagiaires.add("Benjamin");
    // stagiaires.add("Léa"); 
    // stagiaires.add("Jérémie"); 
    // stagiaires.add("Mamadou"); 
    // stagiaires.add("Iliyana");

    // myfunctions.ListeDesNoms(stagiaires);
    // System.err.println(myfunctions.TrouverUnNoms(stagiaires,"Léa"));

    // System.err.println(myfunctions.rwkDeleteName(stagiaires,"Léa"));
    // myfunctions.ListeDesNoms(stagiaires);
    }
}