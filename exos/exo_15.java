import java.util.Scanner;
import methods.myfunctions;
// voir pour plus tard encore plus optimiser comme le fait d'en inscrire nous même
public class exo_15 {
    public static void main(String[] args) {
        String getmoney = myfunctions.rwkTxtStringV2("Quel est votre monnaie ? (EUR, USD, GBP)", true, true);
        
        double getcash = myfunctions.rwkOperator("Quel est votre montant ?", "=", 0);

        String setmoney = myfunctions.rwkTxtStringV2("Vous voulez la convertir en quelle devise ? (EUR, USD, GBP)", true, true);

        myfunctions.rwkTxtStringV2("Résultat : "+ myfunctions.reconversion(getmoney, getcash, setmoney, 0), false, false);
    }
}