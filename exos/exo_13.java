
import methods.myfunctions;

public class exo_13 {
    public static void main(String[] args) {
        myfunctions.rwkTxtStringV2("Voici le résultat "+myfunctions.rwkOperator("Donner une taille en centimètre ?", "/", 100.0)+" en mètre.", false, false);
    }
}