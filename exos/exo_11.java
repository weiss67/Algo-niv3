/* EXO11 : Avec PRINT & Scanner , vous allez simuler un distributeur de banque :
 * 
 * Vous avez 3000€ sur votre compte, créer un algo qui retire un montant sur votre compte banquaire
 * votre solde ne peut pas être négatif
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * Bonjour, combien voulez-vous retirer ?
 * 
 * 3500
 * 
 * Opération refusée, fond insuffissant !
 * 
 * 
*/


import methods.myfunctions;

public class exo_11 {
    public static void main(String[] args) {
        int solde = 3000;
        myfunctions.rwkTxtStringV2("\nBonjour, votre solde est à "+ solde+" euros.", false, false);
        solde = myfunctions.rwkSolde(false, solde);
    }
}