import java.util.Scanner; /* Importation de la bibliothèque Java Scanner */
import methods.myfunctions;

public class exo_12 {
    public static void main(String[] args) {
        myfunctions.rwkTxtStringV2("Votre prix après réduction : "+myfunctions.rwkCalculator("Votre réduction (en pourcentage %) ?", myfunctions.rwkTxtInt("Votre prix ?"), false, true)+" euros", false, false);   
    }
}