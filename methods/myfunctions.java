package methods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class myfunctions {
    //Lister une arrays de A à Z grâce à length pour arrêter, peut être utile pour ajouter à tout moment
    public static String rwkLoopArrays(String[] arrays){
        String result = "";
        for (int i = 0; i < arrays.length; i++){
            result += rwkTxtString("N°"+i+" | "+arrays[i]+"", false, false);
        }
        return result;
    }

    public static String rwkCheckdate(String date_a, int duration){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate local_date = LocalDate.parse(date_a, formatter);

        LocalDate now = LocalDate.now();
        long difference = ChronoUnit.DAYS.between(now, local_date);
        String result = "";

        if(duration <= difference){
            rwkTxtString("TEST 1 Différence de "+ difference, false, false);
            result = "Consommable (Périme bientôt !!!)";
        }else if(duration > difference){
            rwkTxtString("TEST 2 Différence de "+ difference, false, false);
            result = "Périmée";
        }else{
            rwkTxtString("TEST 3 Différence de "+ difference, false, false);
            result = "Consommable";
        }
        return result;
    }

    public static ArrayList<String> rwkAddItem(ArrayList<String> tableau, int index){
        String name = rwkTxtString("Veuillez mettre le nom de l'article", true, false);
        String date_manufacturing = rwkDateTime("Veuillez mettre la date de fabrication ", "1", "");
        String date_expiration = rwkDateTime("Veuillez mettre la date de péremption ", "1", "");
        double price = rwkOperator("Prix de base : ", "=", 0);
        String consumable = rwkCheckdate(date_expiration, 3);
        tableau.add(index, "Nom : "+name+" | "+index+" | "+date_manufacturing+" | "+date_expiration+" | "+price+" | "+consumable);
        return tableau;
    }
    
    // voir pour en faire une V2 ou V3 qui permet d'ajouter des options nous même
    public static ArrayList<String> rwkSwitchCase(ArrayList<String> tableau, int index){
        rwkTxtString("Voulez-vous ? (A) Ajouter un nouvel article | (B) Supprimer un article | (Y) Chercher un article | (X) Quitter", false, false);
        Scanner sc = new Scanner(System.in);
        String option = sc.nextLine().toUpperCase();
        switch(option){// voir pour faire des nouvelles functions assez indépendants pour utiliser en tout
            case "A": tableau = rwkAddItem(tableau, index); break;
            case "B": rwkTxtString("function rwkRmvItem",                       false, true); break;
            case "Y": rwkTxtString("function rwkearchitem",                     false, true); break;
            case "X": rwkTxtString("Game over",                                 false, true); break;
            default: rwkTxtString("Veuillez répondre par (A), (B), (Y) ou (X)", false, true); 
            return rwkSwitchCase(tableau, index); //relancement de sécurité
        }
        return tableau;
    }

    public static String rwkDateTimeFormatter(String prompt){
        Scanner sc = new Scanner(System.in);
        //variable formatter qui permet de convertir la date en europe
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        //question pour avoir la date
        String date_string = rwkTxtString(prompt +" (format JJ/MM/AAAA HH:MM)", true, false);

        //Transform le string en variable date mais en US pour travailler à la suite
        LocalDateTime date_time = LocalDateTime.parse(date_string, formatter);

        String formattedDate = date_time.format(formatter);
        System.out.println("Date d'aujourd'hui format Francophone: " + formattedDate);
        return formattedDate;
    }

    public static String rwkDateTime(String prompt, String operator, String result){ 
        try{
            String time_txt = "HH:mm"; String date_txt = "dd/MM/yyyy";
            DateTimeFormatter formatter;
            Scanner sc = new Scanner(System.in);
            switch(operator){
                case "1": //add date and not time
                formatter = DateTimeFormatter.ofPattern(date_txt);
                String date_string = rwkTxtString(prompt +" (format JJ/MM/AAAA)", true, false);
                //checking format date
                LocalDate local_date = LocalDate.parse(date_string, formatter);
                result = date_string; break;

                case "2":  //add time and not date
                formatter = DateTimeFormatter.ofPattern(time_txt);
                String time_string = rwkTxtString(prompt +" (format HH:MM)", true, false);
                result = time_string; break;

                case "3":  //collate date and time
                rwkTxtString("à voir plus tard", false, false); break;

                case "4":  //releases date in EU
                formatter = DateTimeFormatter.ofPattern(time_txt+" "+date_txt);
                LocalDateTime date_time = LocalDateTime.parse(result, formatter);
                String formattedDate = date_time.format(formatter);
                System.out.println("Date d'aujourd'hui format Francophone: " + formattedDate);
                result = formattedDate; break;

                default: System.out.println("(op_error)"); break;
            }
            //rwkTxtString("CHECK RESULT RWKOPERATOR "+result, false, false);
            return result;
        }catch (Exception e){
            rwkTxtString("Veuillez mettre comme demandé JJ/MM/AAAA ou/et HH:MM", false, false);
            return rwkDateTime(prompt, operator, result);
        }
    }

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

    public static String TrouverUnNoms(ArrayList<String> stagiaires, String rechercheNom){
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
    public static boolean rwkTxtBoolean(String prompt, boolean convert){ 
        try{
            Scanner sc = new Scanner(System.in); 
            rwkTxtString(prompt, false, true);
            boolean result;
            
            if(convert){
                String bool = sc.nextLine().toUpperCase();
                switch(bool){
                    case "YES": case "OUI": return true;
                    case "NO":  case "NON": return false;
                    default: rwkTxtString("Veuillez répondre par YES/NO ou OUI/NON", false, true); 
                    return rwkTxtBoolean(prompt, convert);
                }
            }else if(!convert){
                return sc.nextBoolean();
            }else{
                return rwkTxtBoolean(prompt, convert);
            }
        }catch (Exception e){
            rwkTxtString(rwkTxtError(true, false), false, false);
            return rwkTxtBoolean(prompt, convert);
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
                case "+":  result += clavier; break;
                case "-":  result -= clavier; break;
                case "*":  result = clavier * result; break;
                case "/":  result = clavier / result; break;
                case "+%": result = result * (1+clavier/100.0); break; // augmentation
                case "-%": result = result * (1-clavier/100.0); break; // réduction
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

    public static double rwkOperatorV2(String prompt, boolean scanner, double dft, String operator, String notif, double result){ 
        try{
            Scanner sc = new Scanner(System.in);
            if(scanner){
                rwkTxtString(prompt, false, false);
                dft = sc.nextInt();
            }
            switch(operator){
                case "+":  result += dft; break;
                case "-":  result -= dft; break;
                case "*":  result = dft * result; break;
                case "/":  result = dft / result; break;
                case "+%": result = result * (1+dft/100.0);break; // augmentation
                case "-%": result = result * (1-dft/100.0);break; // réduction
                case "=":  result = dft; break; //laisse comme tel afin d'éviter de créer une function juste pour cela
                default: System.out.println("(op_error) revoir l'opérator"); break;
            }
            if(!notif.equals("")){
                rwkTxtString(notif, false, false);
            }
            //rwkTxtString("CHECK RESULT RWKOPERATOR "+result, false, false);
            return result;
        }catch (Exception e){
            rwkTxtString("Veuillez mettre que des chiffres, virgule autorisé !", false, false);
            return rwkOperator(prompt, operator, result);
        }
    }

    public static double reconversion(String getmoney, double getcash, String setmoney, double result){
        double eur = 1.0;
        double usd = 1.1410;
        double gbp = 0.8576;
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
        Boolean answer = rwkTxtBoolean(query + " (true/false)", false);
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
        Boolean answer = rwkTxtBoolean(query+" (true/false)", false);
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