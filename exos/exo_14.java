/* EXO14 : Avec PRINT & SCANNER : Tester l'expression algèbrique booléenne A OU B ET NON C
 * 
 * A , B ou C sont des booléens et ne peuvent être qu'égale à TRUE ou FALSE.
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * Donner une valeur A OU B ET NON C
 * 
 * FALSE
 * TRUE
 * FALSE
 * 
 * Résultat : TRUE
 * 
*/

import java.util.Scanner;

public class exo_14 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("A (true/false) ?");

        if (sc.hasNextBoolean()) {
            //System.out.println("A (true/false) ?");
            boolean answer_a = sc.nextBoolean();
            System.out.println("A vaut "+ answer_a +"");

            System.out.println("B (true/false) ?");
            boolean answer_b = sc.nextBoolean();
            System.out.println("B vaut "+ answer_b +"");

            System.out.println("C (true/false) ?");
            boolean answer_c = sc.nextBoolean();
            System.out.println("C vaut "+ answer_c +"");

            boolean result = (answer_a || answer_b) && answer_c;

            //System.out.println("(A = "+ answer_a +" or B = "+ answer_b +") and C = "+ answer_c +" donne cela : "+ (answer_a || answer_b) && answer_c+ "");
            System.out.println("(A = "+ answer_a +" or B = "+ answer_b +") and C = "+ answer_c +" donne cela : "+ result);

        } else {
            System.out.println("Incorrect");
            sc.next();
        }

        //public void test(String text, boolean bool) {
            //System.out.println(text);
            //boolean bool = sc.nextBoolean();


        sc.close();
    }
}