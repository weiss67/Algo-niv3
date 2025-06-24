/* EXO16: Avec PRINT & SCANNER : 
 * 
 * Me faire un algo qui change le prix d'un vol selon les paramètres suivants :
 * 
 * Réduction de 20% si le passager est mineur
 * 
 * Réduction de 40% si le passager est senior de plus 60 ans
 * 
 * Réduction de 20% si il y a plus de 60 places disponibles
 * 
 * Augmentation de 20% si il y a moins de 20 places disponibles
 * 
 * Augmentation de 20% si le passager a choisit la classe business 
 * 
 * -----Vous définisserez vous même le prix initial du vol, le nombre de place disponible, l'âge du voyageur
 * 
 * Si le voyageur a choisi une classe business
 * 
 *  * **********************AFFICHAGE ATTENDU ****************:
 * 
 * Quel est l'âge de votre passager ?
 * 15
 * 
 * Le passager veut-il une classe business (oui/non) ?
 * oui
 * 
 * Le prix du vol :
 * 1200
 * 
 * Nombre de places disponibles :
 * 50
 * 
 * Le prix du vol est de 1200 euros
 * 
*/

import java.util.Scanner;

public class exo16 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int age = sc.nextInt();

        System.out.println("Le passager veut-il une classe business (oui/non) ?");
        boolean business = sc.nextBoolean();
        
        sc.nextLine(); 

        System.out.println("Le prix du vol :");
        double price = sc.nextDouble();

        System.out.println("Nombre de places disponibles :");
        int seats = sc.nextInt();

        System.out.println("Quel est l'âge de votre passager ?");
        age = sc.nextInt();

        //Réduction de 20% si le passager est mineur
        if (age < 18) {
            price = price - (price * 0.2);
            System.out.println("Réduction de 20% appliquée pour âge mineur : "+ String.format("%.2f", price));
        }
        //Réduction de 40% si le passager est senior de plus 60 ans
        if (age > 60) {
            price = price - (price * 0.4);
            System.out.println("Réduction de 40% appliquée pour âge senior : "+ String.format("%.2f", price));
        }
        //Augmentation de 20% si le passager a choisit la classe business ?
        if (business) {
            price = price + (price * 0.2);
            System.out.println("Augmentation de 20% appliquée pour classe business : "+ String.format("%.2f", price));
        }
        //Réduction de 20% si il y a plus de 60 places disponibles
        if (seats > 60) {
            price = price - (price * 0.2);
            System.out.println("Réduction de 20% appliquée car il y a plus de 60 places disponibles : "+ String.format("%.2f", price));
        }
        //Augmentation de 20% si il y a moins de 20 places disponibles
        if (seats < 20) {
            price = price + (price * 0.2);
            System.out.println("Augmentation de 20% appliquée car il y a moins de 20 places disponibles : "+ String.format("%.2f", price));
        }

        System.out.println("Le prix du vol est de " + String.format("%.2f", price) + " euros");

        sc.close();
    }
}