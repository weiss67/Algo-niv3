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



import methods.myfunctions;

public class exo_16 {
    public static void main(String[] args) {
        
        int age = myfunctions.rwkTxtInt("Quel est l'âge de votre passager ?");
        boolean business = myfunctions.rwkTxtBoolean("Le passager veut-il une classe business (oui/non) ?", true);
        double price = myfunctions.rwkOperator("Le prix du vol : ", "=", 0);
        int seats = myfunctions.rwkTxtInt("Nombre de places disponibles : ");
        myfunctions.rwkTxtString("CHECKING "+ seats, false, false);

        //Réduction de 20% si le passager est mineur
        if (age < 18) {
            price = myfunctions.rwkOperatorV2("", false, 20, "-%", "Réduction de 20% appliquée pour âge mineur : "+ String.format("%.2f", price), 0);
        }
        //Réduction de 40% si le passager est senior de plus 60 ans
        if (age > 60) {
            price = myfunctions.rwkOperatorV2("", false, 40, "-%", "Réduction de 40% appliquée pour âge senior : "+ String.format("%.2f", price), 0);
        }
        //Augmentation de 20% si le passager a choisit la classe business ?
        if (business) {
            price = myfunctions.rwkOperatorV2("", false, 20, "+%", "Augmentation de 20% appliquée pour classe business : "+ String.format("%.2f", price), 0);

        }
        //Réduction de 20% si il y a plus de 60 places disponibles
        if (seats > 60) {
            price = myfunctions.rwkOperatorV2("", false, 20, "+%", "Réduction de 20% appliquée car il y a plus de 60 places disponibles : "+ String.format("%.2f", price), 0);

        }
        //Augmentation de 20% si il y a moins de 20 places disponibles
        if (seats < 20) {
            price = myfunctions.rwkOperatorV2("", false, 20, "-%", "Augmentation de 20% appliquée car il y a moins de 20 places disponibles : "+ String.format("%.2f", price), 0);
        }

        System.out.println("Le prix du vol est de " + String.format("%.2f", price) + " euros");
    }
}