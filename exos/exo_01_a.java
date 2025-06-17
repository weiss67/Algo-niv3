import java.util.Scanner;

/* A l'aide de boucle, tableau, exception et fonction. Me faire un tableau contenant 5 noms de ville (Vous pouvez choisir vos propres villes), créer une méthode pour afficher les villes du tableau numéroté par ligne et autre une méthode pour choisir une ville selon 

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

public class exo_01_a {
    public static boolean decision(String response){
        if(response.toUpperCase().equals("N")){
            return false;
        }else if(response.toUpperCase().equals("O")){
            return true;
        }else{
            System.err.print("Veuillez renseigner une valeur O(Oui) ou N(Non)");
                    return false;
        }
    }

    public static String ListeTableau(String[]tab){
        String result="";
        if(tab.length!=0){
        for(int i=0;i<tab.length;i++){
            result+= i+"-"+tab[i]+"\n";}
        }else{result="\nLa liste de villes est vide\n";}
        return result;
    }

    public static void main(String[] args) {
        boolean stop = false;
        Scanner clavier = new Scanner(System.in);
        int choice=0;
        String response;

        String [] villes = {"Paris","Londres","Madrid","Lisbonne","Berlin"};
        String [] messages = {"Bienvenu à Paris","Welcome in London","Bienvenido a Madrid","Bem-vindo a Lisboa","Willkommen in Berlin"};

        System.out.println("Bonjour, quelle ville voulez-vous visiter ?:");

        while(!stop){
            System.out.println(ListeTableau(villes));
            choose(choice,messages,clavier);
            System.out.print("Voulez-vous visiter une autre ville (O/N):");
            clavier.nextLine();
            response = clavier.nextLine();
            stop = continueTravel(response,clavier);
        }
        System.out.print("Votre voyage est terminé :) !");
        clavier.close();
    }

    public static void choose(int choice,String[]tab,Scanner clavier){
        boolean repeat=true;
        int count=0;
        while(repeat){
            try {
            System.out.print("numéro de la ville :");
            if(count>=1){
            clavier.nextLine();
            }
            choice = clavier.nextInt();
            repeat=false;
            count++;  
            } catch (Exception e) {
             System.out.println("Veuillez entrer un nombre");
             count++;
            }
        }
        System.out.println(ValeurTableau(tab, choice));
    }
    
    public static boolean continueTravel(String response,Scanner clavier) {
        boolean decision=false;
        boolean repeat=false;
        while(!repeat){
           if (response.equalsIgnoreCase("N")) {
                decision=true;
                repeat=true;
            } else if (response.equalsIgnoreCase("O")) {

                decision=false;
                repeat=true;
            }else{
                System.out.print("Veuillez tapez soit O(Oui) ou N(Non):");
                response = clavier.nextLine();
                decision=false;
                repeat=false;
            }
        }
        return decision;
    }

    public static String ValeurTableau(String[]tab, int i){
        if(i<tab.length){
            return tab[i];
        }else{
            return "Cette ville n'est pas sur la liste";
        }
    }
}


    