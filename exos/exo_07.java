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

    public static String rwkTxt(boolean keyboard, String a)
    { //maj_0.0.1.a
        Scanner sc = new Scanner(System.in);
        System.out.print(a);
        if(keyboard){
            return sc.next(); //TEST (De base c'était : return sc.nextLine();)
        }else{
            return a;
        }
    }

    public static String query(String a, String y, String n, String true_answer, String false_answer, String error_answer){
        String txt = "";
        if (a.equalsIgnoreCase(y)) { // Plus optimisé que "equals" et cela prends en compte si majuscule ou minuscule
            txt = true_answer;
        } else if (a.equalsIgnoreCase(n)) {
        txt = false_answer;
        } else { 
            txt = error_answer;}
        return txt;
    }

    public static void main(String[] args) {
        try{
            rwkTxt(false, "\n");//un saut à la ligne pour mieux voir
            String answer = rwkTxt(true, "Do you speak english (Y/N)?\n");
            System.out.println(query(answer, "y", "n", "Nice to meet you", "So learn english !", "Imput Y or N !"));
            //sc.close();
        }catch (Exception e){
            System.out.println("ERROR FATAL 404");
        }
    }
}