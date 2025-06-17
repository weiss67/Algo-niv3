/* EXO7 : A l'aide de Scanner et Print, créer un questionnaire, "Do you speak english ?", répondre yes ou no, puis retourner le messages suivants 
 * 
 * si FALSE "So learn english !"
 * 
 * Si TRUE "Nice to meet you"
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * Do you speak english (Y/N)?
 * 
 * Y (Tapez Y)
 * 
 * "Nice to meet you"
 * 
 * 
 * 
*/

import java.util.Scanner;

public class exo_07 {

    public static String query(String a){
        String txt = "";
        //if (a.equals("y") || a.equals("y")) { //fonctionnel
        if (a.equalsIgnoreCase("y")) { // Plus optimisé et cela prends en compte si majuscule ou minuscule
            txt = "Nice to meet you";
        } else if (a.equals("n")) {
        txt = "So learn english !";
        } else { 
            txt = "Imput Y or N !";
        }
        return txt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you speak english (Y/N)?");
        String answer = sc.nextLine();

        System.out.println(query(answer));

        sc.close();
    }
}