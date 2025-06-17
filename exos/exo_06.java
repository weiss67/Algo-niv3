/* EXO6 : A l'aide de Scanner et Print, donnez moi votre prénom et votre âge, pour l'affichage sous la forme d'une phrase dynamique
 * 
 * 
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * prenom = "Eudes"
 * 
 * age = 32
 * 
 * Je m'appelle Eudes , j'ai 32 ans
 * 
 * 
 * 
*/

import java.util.Scanner;

public class exo_06 {
    public static void main(String[] args) {
        try{

        Scanner sc = new Scanner(System.in);
 
        System.out.println("Entrez votre prénom");
        String a = sc.nextLine();
        System.out.println("Entrez votre âge");
        int b = sc.nextInt();

        System.out.println("Je m'appelle "+ a +" j'ai "+ b +" ans.");

        sc.close();
        }catch(Exception e){
            System.out.println("ERROR FATAL 404");
        }
    }
}