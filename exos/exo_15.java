import java.util.Scanner;
import methods.functions;
// voir pour plus tard encore plus optimiser comme le fait d'en inscrire nous même
public class exo_15 {
    public static void main(String[] args) {
        String getmoney = functions.rwkTxtString("Quel est votre monnaie ? (EUR, USD, GBP)", true, true);

        double getcash = functions.rwkOperator("Quel est votre montant ?", "=", 0);

        String setmoney = functions.rwkTxtString("Vous voulez la convertir en quelle devise ? (EUR, USD, GBP)", true, true);

        System.out.println("Résultat : "+ functions.reconversion(getmoney, getcash, setmoney));
    }
}