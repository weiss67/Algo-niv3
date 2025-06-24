package methods;

import java.util.ArrayList;
import java.util.Scanner;

public class functions {
    public static void AfficherTouteValeurTableau(int[] tableau) {

        for (int i = 0; i < tableau.length; i++) {
            System.out.println("Valeur à l'index " + i + " : " + tableau[i]); // Affiche chaque valeur du tableau
        }
    }

    public static void ListeDesNoms(ArrayList<String> stagiaires){

        for(String nom:stagiaires){

            System.out.println(nom);
        }
    }

    public static String TrouverUnNoms(ArrayList<String> stagiaires,String rechercheNom){
        if(stagiaires.contains(rechercheNom)){
            return rechercheNom+" Existe dans la liste, à la position "+stagiaires.indexOf(rechercheNom);
        }else{
            return "Nom introuvable";
        }
    }
    // à regarder plus tard
    public static Object rwkTxt(String prompt, boolean keyboard, boolean keybool){ 
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt+"\n");
        if(keyboard){
            if(keybool){
                return sc.nextBoolean();
            } else  {
                return sc.next();
            }
        } else {
            if (keybool) {
                return Boolean.parseBoolean(prompt);
            } else {
                return prompt;
            }
        }
    }
    public static String rwkTxtError(boolean boolean_error, boolean int_error){
        String boolean_err_txt;
        if (boolean_error){
            boolean_err_txt = "Entrée invalide. Veuillez taper 'true' ou 'false'.";
        }else{
            boolean_err_txt = "(boolean_error)";
        }
        if (int_error){
            boolean_err_txt = "Entrée invalide. Veuillez mettre que des chiffres.";
        }else{
            boolean_err_txt = "(int_error)";
        }
        return boolean_err_txt;
    }
    public static String rwkTxtString(String prompt, boolean keyboard, boolean touppercase){ 
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt+"\n");
        if(keyboard){
            if(touppercase){
                return sc.nextLine().toUpperCase(); //transform all maj
            }else{
                return sc.next();
            }
        } else {
            return prompt; //return exclusive text
        }
    }
    public static boolean rwkTxtBoolean(String prompt){ 
        try{
            Scanner sc = new Scanner(System.in); 
            rwkTxtString(prompt, false, false);
            return sc.nextBoolean();
        }catch (Exception e){
            rwkTxtString(rwkTxtError(true, false), false, false);
            return rwkTxtBoolean(prompt);
        }
    }
    public static int rwkTxtInt(String prompt){ 
        try{
            Scanner sc = new Scanner(System.in); 
            rwkTxtString(prompt, false, false);
            return sc.nextInt();
        }catch (Exception e){
            rwkTxtString(rwkTxtError(false, true), false, false);
            return rwkTxtInt(prompt);
        }
    }
    public static double rwkCalculator(String prompt, double result, boolean add, boolean pct){ 
        try{
            Scanner sc = new Scanner(System.in);
            rwkTxtString(prompt, false, false);
            double clavier = sc.nextInt();
            if(add){
                result += clavier;
            }
            if(pct){
                result = result * (1-clavier/100.0);
            }
            return result;
        }catch (Exception e){
            rwkTxtString(rwkTxtError(false, true), false, false);
            return rwkCalculator(prompt, result, add, pct);
        }
    }
    public static double rwkOperator(String prompt, String operator, double result){ 
        try{
            Scanner sc = new Scanner(System.in);
            rwkTxtString(prompt, false, false);
            double clavier = sc.nextInt();
            switch(operator){
                case "+":   result += clavier; break;
                case "-":   result -= clavier; break;
                case "*":   result = clavier * result; break;
                case "/":   result = clavier / result; break;
                case "+%":  result = result * (1+clavier/100.0);break;
                case "-%":  result = result * (1-clavier/100.0);break;
                case "=":  result = clavier; break; //laisse comme tel afin d'éviter de créer une function juste pour cela
                default: System.out.println("(op_error)"); break;
            }
            //rwkTxtString("CHECK RESULT RWKOPERATOR "+result, false, false);
            return result;
        }catch (Exception e){
            rwkTxtString("Veuillez mettre que des chiffres, virgule autorisé !", false, false);
            return rwkOperator(prompt, operator, result);
        }
    }

    public static double reconversion(String getmoney, double getcash, String setmoney){
        double eur = 1.0;
        double usd = 1.1410;
        double gbp = 0.8576;
        
        double result;
        switch(getmoney){
            case "EUR": result = getcash / eur; break;
            case "USD": result = getcash / usd; break;
            case "GBP": result = getcash / gbp; break;
            default: System.out.println("Monnaie source inconnue."); return 0.0;
        }

        switch(setmoney){
            case "EUR": return result * eur;
            case "USD": return result * usd;
            case "GBP": return result * gbp;
            default: System.out.println("Monnaie cible inconnue."); return 0.0;
        }
    }  

    public static String rwkDeleteName(ArrayList<String> stagiaires, String rechercheNom){
        if(stagiaires.contains(rechercheNom)){
            stagiaires.remove(stagiaires.indexOf(rechercheNom));
            return rechercheNom+" a été delete ";
        }else{
            return "Nom introuvable";
        }
    }
    public static String rwkQuizer(String query, boolean bool, String correct, String incorrect){
        try{
        String result = "";
        Boolean answer    = rwkTxtBoolean(query + " (true/false)");
            if (answer == bool) {
                result = correct;
            } else {
                result = incorrect;
            }
        return result;
        }catch (Exception e){
            rwkTxtString(rwkTxtError(true, false), false, false);
            return rwkQuizer(query, bool, correct, incorrect);
        }
    }
    public static Boolean rwkQuizerNv2(String query, boolean bool, String correct, String incorrect){
        Boolean result;
        Boolean answer = rwkTxtBoolean(query+" (true/false)");
            if (answer == bool) {
                rwkTxtString(correct, false, false);
                result = true;
            } else {
                rwkTxtString(incorrect, false, false);
                result = false;
            }
        return result;
    }
    public static int rwkScore(boolean bool, int win, int los){ // voir plus tard pour ajouter d'autres paramètres
        if (bool) {
            return win;
        } else {
            return los;
        }
    }
    public static int rwkSolde(boolean bool, int solde){ // voir plus tard pour ajouter d'autres paramètres
        int credit; int debit;
        if (bool) {
            credit = rwkTxtInt("Combien voulez-vous mettre ?");
            solde += credit;
        } else {
            debit = rwkTxtInt("Combien voulez-vous retirer ?");
            if (solde >= debit) {
                solde -= debit;
                rwkTxtString("Votre nouveau solde est à "+ solde, false, false);
            } else {
                rwkTxtString("Opération refusée, fond insuffissant !", false, false);
                rwkSolde(bool, solde);
            }
        }
        return solde;
    }


    /*
    public static class QuizResult {
        private final String message;
        private final int score;

        public QuizResult(String message, int score) {
            this.message = message;
            this.score = score;
        }
    }

    public static QuizResult rwkQuizer(String query, boolean correctAnswer) {
        boolean userAnswer = rwkTxtBoolean(query + " (true/false)");
        String message = (userAnswer == correctAnswer) ? "Bonne réponse !" : "Mauvaise réponse !";
        int score = (userAnswer == correctAnswer) ? 1 : 0;
        return new QuizResult(message, score);
    }
    */
}