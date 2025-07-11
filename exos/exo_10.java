import java.util.Scanner;
import methods.myfunctions;

public class exo_10 {
    public static void main(String[] args) {
        int result = 0;  // Le score global
        boolean bool;
        String correct = "Bonne réponse !"; String incorrect = "Mauvaise réponse !";
        myfunctions.rwkTxtStringV2("", false, false);

        bool = myfunctions.rwkQuizerNv2("Est-ce que le soleil se lève à l'est ?", true, correct, incorrect);
        result += myfunctions.rwkScore(bool, 1, 0);

        bool = myfunctions.rwkQuizerNv2("Est-ce que 2 + 2 = 5 ?", false, correct, incorrect);
        result += myfunctions.rwkScore(bool, 1, 0);

        bool = myfunctions.rwkQuizerNv2("Est-ce que l’eau bout à 100 degrés ?", true, correct, incorrect);
        result += myfunctions.rwkScore(bool, 1, 0);

        myfunctions.rwkTxtStringV2("Votre score est de "+ result, false, false);
    }
}