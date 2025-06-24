import java.util.Scanner;
import methods.functions;

public class exo_13 {
    public static void main(String[] args) {
        functions.rwkTxtString("Voici le résultat "+functions.rwkOperator("Donner une taille en centimètre ?", "/", 100.0)+" en mètre.", false, false);
    }
}