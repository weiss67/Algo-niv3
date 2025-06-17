/* EXO5 : A l'aide de Scanner et Print, créer une équation  A multiplier par B diviser C (tous types entiers) , récupérer le résultat et vérifier si elle inférieur ou supérieur à 10
 * 
 * 
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * equation = (EQUATION)
 * 
 * equation = 15
 * 
 * 
 * equation est superieur
 * 
*/
import java.util.Scanner;


public class exo_05 {
    public static String equation(int a, int b, int c){

        int result1 = a * b;
        System.out.println(a +" multiplisé par "+ b +" donne " + result1);

        int result2 = result1 / c;
        System.out.println(result1 +" divisé par "+ c +" est " + result2);

        String txt = "L'équation ("+ result2 +") est ";
            if (result2 > 10) {
                txt += "supérieur";
            } else { 
                txt += "inférieur";
            }
        return txt;
    }
    public static void main(String[] args) {
        try{
        
        Scanner sc = new Scanner(System.in);
 
        System.out.println("Entrez la valeur A");
        int v0 = sc.nextInt();
        System.out.println("Entrez la valeur B");
        int v2 = sc.nextInt();
        System.out.println("Entrez la valeur C");
        int v3 = sc.nextInt();

        System.out.println(equation(v0, v2, v3));
        
        sc.close();
        }catch (Exception e){
            System.out.println("ERROR FATAL 404");
        }
    }
}