package methods;

import java.util.ArrayList;

public class functions {

    public static void AfficherTouteValeurTableau(int[] tableau) {

        for (int i = 0; i < tableau.length; i++) {
            System.out.println("Valeur à l'index " + i + " : " + tableau[i]); // Affiche chaque valeur du tableau
        }
    }

    public static void ListeDesNoms(ArrayList<String> stagiaires){

        for(String nom:stagiaires){

            System.out.println(nom);
        }
    }

    public static String TrouverUnNoms(ArrayList<String> stagiaires,String rechercheNom){

        String result;
        
        if(stagiaires.contains(rechercheNom)){
            return rechercheNom+" Existe dans la liste, à la position "+stagiaires.indexOf(rechercheNom);
        }else{
            return "Nom introuvable";
        }
    }
}