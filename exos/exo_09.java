/* EXO8 : A l'aide de Scanner et Print, créer un formulaire d'inscription, où on vous demande de renseignez, votre prénom, votre nom, adresse email,
 *  mot de passe et confirmer votre mot de passe (ils doivent être identiques). Si les mots de passes ne sont pas identiques, ceci affiche "inscription annulée"
 * Sinon vous affichez le message suivant ci-dessous :
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * Votre prénom ?
 * 
 * Eudes
 * 
 * Votre nom ?
 * 
 * Konda
 * 
 * Votre adresse ?
 * 
 * ekonda@arfp.asso.fr
 * 
 * votre mot de passe ?
 * 
 * ekonda123&!
 * 
 * confirmer votre mot de passe ?
 * 
 * ekonda123&!
 * 
 * Merci Eudes KONDA , votre inscription a bien été effectuée, vous recevrez un mail de confirmation à l'adresse : ekonda@arfp.asso.fr
 * 
*/

import java.util.Scanner;

public class exo_09 {

    public static String rwkTxt(boolean keyboard, String a)
    { //maj_0.0.1.b voir au prochain pour mettre boolean derrière
        Scanner sc = new Scanner(System.in);
        System.out.print(a+"\n");
        if(keyboard){
            return sc.next();
        }else{
            return a;
        }
    }

    public static String[] rwkSignUp(){
        String firstname = rwkTxt(true, "Votre prénom ?");
        String lastname = rwkTxt(true, "Votre nom ?");
        String mail = rwkTxt(true, "Votre adresse mail ?");
        String createmdp = rwkTxt(true, "Votre mot de passe ?");
        String checkmdp = rwkTxt(true, "Confirmer votre mot de passe ?");
        return new String[]{firstname, lastname, mail, createmdp, checkmdp};
    }

    public static String rwkChecking(String checkmdp, String createmdp, String succes_txt, String refused_txt){
        String txt = "";
        if (checkmdp.equals(createmdp)) {
        txt = succes_txt;
        } else { 
            txt = refused_txt;
        }
        return txt;
    }

    public static String rwkSignIn(String checkmdp, String mail, String conexion_txt, String psw_txt, String connexion_succes, String connexion_refused){
        String txt = "";

        String checkmail = rwkTxt(true, conexion_txt);
        String checkmdp2 = rwkTxt(true, psw_txt);

        if (checkmdp2.equals(checkmdp) && checkmail.equals(mail)) {
            rwkTxt(false, connexion_succes);
        } else { 
            rwkTxt(false, connexion_refused);
        }
        return txt;
    }
    //rwkSignIn(conexion_txt, psw_txt, connexion_succes, connexion_refused)

    public static void main(String[] args) {
        rwkTxt(false, "");

        Scanner sc = new Scanner(System.in);

        String[] userData = rwkSignUp();

        // Extraction des valeurs
        String firstname = userData[0];
        String lastname = userData[1];
        String mail = userData[2];
        String createmdp = userData[3];
        String checkmdp = userData[4];

        rwkTxt(false, rwkChecking(checkmdp, createmdp, "Merci "+ firstname +" "+ lastname +" , votre inscription a bien été effectuée, vous recevrez un mail de confirmation à l'adresse : "+ mail, "Inscription annulée"));

        rwkSignIn(checkmdp, mail, "Pour vous connecter, renseignez votre email ?", "Renseignez votre mot de passe ?", "Connexion réussie", "Connexion refusée");

        sc.close();
    }
}