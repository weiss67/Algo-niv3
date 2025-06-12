
/*A l'aide de boucle, tableau, exception et fonction. 
Me faire un tableau contenant 5 noms de ville (Vous pouvez choisir vos propres villes), 
créer une méthode pour afficher les villes du tableau numéroté par ligne 
et autre une méthode pour choisir une ville selon 

la position de sa cellule du tableau et puis affichera un message de bienvenue dans la langue de la ville choisie.:

Bonjour, quelle ville voulez-vous visiter ?

0 - Paris 
1 - Londres
2 - Madrid
3 - Lisbonne
4 - Berlin

0
Bienvenue à Paris !

Voulez-vous visiter une autre ville ? (O/N)
O

1
Welcome to London !

Voulez-vous visiter une autre ville ? (O/N)
O

2
Bienvenido a Madrid !
Voulez-vous visiter une autre ville ? (O/N)
O


3
Bem-vindo a Lisboa !
Voulez-vous visiter une autre ville ? (O/N)
O

4
Willkommen in Berlin !
Voulez-vous visiter une autre ville ? (O/N)
O


5
Désolé, cette ville n'est pas sur la liste !
Voulez-vous visiter une autre ville ? (O/N)
O

Votre voyage est terminé :) !

*/
import java.util.Scanner;
public class exo_01 {

    public static int lastCity(int[] listCity) {
        return listCity[listCity.length - 1]; // Retourne la dernière valeur du tableau
    }
    //function citySelectionned(prends en compte le tableau)
    public static void citiesAll(String[] table_cities) {
        for (int i = 0; i < table_cities.length; i++) {
            System.out.println(i + " - " + table_cities[i]); // Affiche chaque valeur du tableau
        }
    }
    //function citySelectionned(index à selectionner, prends en compte le tableau)
    public static void citySelectionned(int selectionned, String[] table_welcomes) {
        if(selectionned < 4){
            System.out.println(table_welcomes[selectionned]);
        }else{System.out.println("Désolé, cette ville n'est pas sur la liste !");}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Déclaration du scanner Instance de l'Objet Scanner 
        String v0 = "Paris", v1 = "Londres", v2 = "Madrid", v3 = "Lisbonne", v4 = "Berlin"; boolean relaunch = true;
        String[] table_cities = {v0, v1, v2, v3, v4};
        String[] table_welcomes = {"Bienvenue à Paris !", "Welcome to London !", "Bienvenido a Madrid !", "Bem-vindo a Lisboa !", "Willkommen in Berlin !"};
        System.out.println("Bonjour, quelle ville voulez-vous visiter ?");
        citiesAll(table_cities);
        while(relaunch){
            int selectionned = sc.nextInt();
            citySelectionned(selectionned, table_welcomes);
            System.out.println("Voulez-vous visiter une autre ville ? (false/true)");
            relaunch = sc.nextBoolean();
        }
        System.out.println("Votre voyage est terminé :) !");
        sc.close();
    }
}