import java.util.Scanner; /* Importation de la bibliothèque Java Scanner */
import methods.functions;

public class exo_12 {
    public static void main(String[] args) {
        functions.rwkTxtString("Votre prix après réduction : "+functions.rwkCalculator("Votre réduction (en pourcentage %) ?", functions.rwkTxtInt("Votre prix ?"), false, true)+" euros", false, false);   
    }
}