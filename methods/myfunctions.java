package methods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList; //import d'un outil pour comparer entre dates
import java.util.Arrays;
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

    public static String rwkCheckdate(String date_string, int duration, ChronoUnit unit, String sector){
        //ChronoUnit.DAYS or ChronoUnit.MONTHS or ChronoUnit.YEARS

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate local_date = LocalDate.parse(date_string, formatter);

        LocalDate now = LocalDate.now();
        long difference;

        if(sector == "ALIMENTARY"){
            difference = unit.between(now, local_date);
        }else{
            difference = unit.between(local_date, now);
        }

        String result = "";
        //rwkTxtString("Il y a "+difference+" "+unit+" de différence entre aujourd'hui et péremption (Période de 20 % si proche des "+duration+" jours restants)", false, false);
        
        //rwkTxtString(difference+" >= "+duration, false, false);

        if(sector == "ALIMENTARY" && (difference < 0)){ // si au dessous du 0, évite des -1 ou moins
            //rwkTxtString("TEST 1 | Différence de "+ difference, false, false);
            //result = "Périmée"; //fonctionnel
            result = "EXPIRED";
        }else if( (sector == "ALIMENTARY" && (difference <= duration)) || (sector == "ECOMMERCE" && (difference >= duration))){
            //rwkTxtString("TEST 2 LIMITED", false, false);
            //result = "Consommable (Périme bientôt !!!)";
            result = "LIMITED";
        }else{
            //rwkTxtString("TEST 3 Différence de "+ difference, false, false);
            //result = "Consommable";
            result = "VALIDATED";
        }

        // if(!alimentary && (difference >= duration)){
        //     rwkTxtString("TEST 2 LIMITED", false, false);
        //     //result = "Consommable (Périme bientôt !!!)";
        //     result = "LIMITED";
        // }else{
        //     result = "VALIDATED";
        // }

        return result;
    }

    public static double rwkSwitchCasePrice(String option, double price, boolean isOnSale, int onsale, int reduce){
        switch(option){// voir pour faire des nouvelles functions assez indépendants pour utiliser en tout
            //case "Périmée": 
            case "EXPIRED": 
            price = 0.0; 
            break;
            //case "Consommable (Périme bientôt !!!)": 
            case "LIMITED":
            //rwkTxtString("CHECK rwkSwitchCasePrice 1 "+price, false, false);
            int discount;
            if (isOnSale) {
                //discount = 40;
                discount = onsale;
                rwkTxtString("(Solde de "+onsale+"% appliquée)", false, false); 
            } else {
                //discount = 10;
                discount = reduce;
                rwkTxtString("(Réduction de "+reduce+"% appliquée)", false, false);
            }
            price = myfunctions.rwkOperatorV2("", false, discount, "-%", "", price); 
            break;
            //case "Consommable":
            case "VALIDATED":
            break;
            default: rwkTxtString("default rwkSwitchCasePrice", false, true); 
            return rwkSwitchCasePrice(option, price, isOnSale, onsale, reduce); //relancement de sécurité
        }
        return price;
    }

    public static String addProductType(String []type) {
        // Implémentez la logique pour ajouter un produit avec son type
        // Par exemple, vous pouvez créer une nouvelle entrée dans la liste avec le type du produit
        String typeName = "";
        try {
        System.out.println("Type de produit :");
        for (int i = 0; i < type.length; i++) {
            System.out.println("(" + (i + 1) + "). " + type[i]);
        }
        int typeChoice = rwkTxtInt("Veuillez choisir votre type de produit :");
            typeName = type[typeChoice - 1];
                    System.out.println("Type de produit choisi : " + typeName);
        } catch (Exception e) {
            Exceptioner.TxtException(e,type.length);
            addProductType(type);
        }
        return typeName;
    }

    public static String[] addProductTypeTest(String[][] type) {
        
        String[] autos_volkswagen   = type[0];
        String[] autos_audi         = type[1]; 
        String[] autos_porsche      = type[2];
        String[] autos_lamborghini  = type[3];

        String[] result = new String[2]; // [0] = marque, [1] = modèle

        String typeName = "";
        try {
        System.out.println("Quel est sa marque, choissisez son numéro :");
        for (int i = 0; i < type.length; i++) {
            System.out.println(""+ (i + 1) +" - "+ type[i][0]);
        }
        int typeChoice = rwkTxtInt("");
            typeName = type[typeChoice - 1][0];
            System.out.println("Vous avez choisi la marque : " + typeName);

            System.out.println("\nQuel est son modèle, choissisez son numéro :");
            String[] models = Arrays.copyOfRange(type[typeChoice - 1], 1, type[typeChoice - 1].length);
        for (int i = 0; i < models.length; i++) {
            System.out.println("(" + (i + 1) + "). " + models[i]);
        }
        
        int modelChoice = rwkTxtInt("");
        String selectedModel = models[modelChoice - 1];
        System.out.println("Vous avez choisi le modèle : " + selectedModel);
        
        result[0] = typeName;
        result[1] = selectedModel;

        return result;

        } catch (Exception e) {
            Exceptioner.TxtException(e, type.length);
            addProductTypeTest(type);
        }
        return result;
    }

    public static ArrayList<String> rwkAddItem(ArrayList<String> tableau, int index, String[] types, String sector, int duration, ChronoUnit unit, int onsale, int reduce, String[][] all_categorys){
        
        String name = ""; String typeName = ""; String date_manufacturing = ""; String[] choix; double price = 0.0; String add_item = "";

        if ("DEALERSHIP".equals(sector)){
            rwkTxtString("Vous voulez ajouter une voiture, très bien.", false, false);
            choix             = addProductTypeTest(all_categorys);

            String marque = choix[0];
            String modele = choix[1];

            rwkTxtString("CHECK DEALERSHIP "+ typeName, false, false);
            typeName = addProductType(types);
            rwkTxtString("Marque : "+marque + " | Modèle : " + modele+" | ", false, false);

            boolean condition = false;
            int kilometrage = 0;

            add_item = "[code : LAAV-2025-06-30] | Marque : "+marque+" | Modele "+modele+" | Neuf : "+condition+" | Kilométrage : "+kilometrage+" | Couleur : "+typeName+" | Prix total : "+String.format("%.2f", price);
        }

        if (sector == "ALIMENTARY" || sector == "ECOMMERCE"){
            name                 = rwkTxtString("Veuillez mettre le nom de l'article", true, false);
            typeName             = addProductType(types);
            //String test_date            = rwkDateTime("Veuillez mettre la date de fabrication ", "1", "");
            //String test_time            = rwkDateTime("Veuillez mettre l'heure et minute de fabrication ", "2", "");
            //String date_manufacturing   = test_date+" "+test_time; //fonctionnel
            date_manufacturing   = rwkDateTime("Veuillez mettre la date de fabrication ", "1", "");
        }
        
        String date_expiration = ""; String date_expiration_txt = ""; String date_check = date_manufacturing;
        if ("ALIMENTARY".equals(sector)){//Demande la date de péremption si alimentaire
            date_expiration      = rwkDateTime("Veuillez mettre la date de péremption ", "1", "");
            date_expiration_txt = "Date de péremption : "+date_expiration+" | ";
            date_check = date_expiration;
        }
        
        String consumable = ""; boolean isOnSale; 
        if (sector == "ALIMENTARY" || sector == "ECOMMERCE"){
            price               = rwkOperator("Prix de base : ", "=", 0);
            consumable          = " | "+rwkCheckdate(date_check, duration, unit, sector); // checking de la limite de date
            isOnSale            = rwkTxtBoolean("En solde ? (OUI/NON)", true);
            price               = rwkSwitchCasePrice(consumable, price, isOnSale, onsale, reduce); // modification du prix en fonction de la date
            add_item = "("+index+") Nom : "+name+"\nType de produit : "+typeName+" | Date de fabrication : "+date_manufacturing+" | "+date_expiration_txt+"Prix : "+String.format("%.2f", price)+consumable;
        }

        tableau.add(index, add_item);
        rwkTxtString("Produit ajouté avec succès ! "+add_item, false, false);
        return tableau;
    }

    public static ArrayList<String> rwkRmvItemViaIndex(ArrayList<String> tableau, int index){
        int index_delete = rwkTxtInt("Veuillez mettre l'ID que vous voulez delete");
        if(index_delete >= 0 && index_delete < tableau.size()) {
            tableau.remove(index_delete);
            rwkTxtString(index_delete+" a été deleté !", false, false);
            return tableau; // mets à jour le tableau en retournant
        }
        if (index_delete > tableau.size()) {
            rwkTxtString("Index invalide !", false, false);
            rwkRmvItemViaIndex(tableau, index);
        }
        return tableau;
    }

    public static ArrayList<String> rwkSrhItem(ArrayList<String> tableau, int index){
        String search = rwkTxtString("Veuillez mettre le nom du produit que vous recherchez :", true, false);
        //System.out.print("TEST "+search);

        // if(tableau.contains(search)){
        //     rwkTxtString(tableau.get(tableau.indexOf(search))+"", false, false);
        // }else{
        //     rwkTxtString("Produit introuvable !", false, false);
        //     return rwkSwitchCase(tableau, index);
        // }
        boolean found = false;
        for (String item : tableau) {
            if (item.contains(search)) { // Cherche "Nom : [recherche]" dans la chaîne
                rwkTxtString("Produit trouvé :" + item, false, false);
                found = true;
                break;
            }
        }
        if(!found) {
            rwkTxtString("Aucun produit trouvé pour : " + search, false, false);
        }
        return tableau;
    }

    public static ArrayList<String> rwkSwitchCase(
        ArrayList<String> tableau, 
        int index, String[] types, 
        String sector, int duration, 
        ChronoUnit unit, int onsale, int reduce,
        String[][] vehicles_autos
        ){
        String option = rwkTxtString("Voulez-vous ? (A) Ajouter un nouvel article | (B) Supprimer un article | (Y) Chercher un article | (W) Afficher la liste d'articles | (X) Quitter", true, true);
        switch(option){// voir pour faire des nouvelles functions assez indépendants pour utiliser en tout
            case "A": tableau = rwkAddItem(tableau, index, types, sector, duration, unit, onsale, reduce, vehicles_autos); 
            return rwkSwitchCase(tableau, index + 1, types, sector, duration, unit, onsale, reduce, vehicles_autos); //relance le tableau de proposition avec index ajouté
            case "B": tableau = rwkRmvItemViaIndex(tableau, index);
            return rwkSwitchCase(tableau, index, types, sector, duration, unit, onsale, reduce, vehicles_autos);
            case "Y": rwkSrhItem(tableau, index);
            return rwkSwitchCase(tableau, index, types, sector, duration, unit, onsale, reduce, vehicles_autos);
            case "W": rwkLoopArraysList(tableau);
            return rwkSwitchCase(tableau, index, types, sector, duration, unit, onsale, reduce, vehicles_autos);
            case "X": rwkTxtString("Merci au revoir ! ", false, false); break;
            default: rwkTxtString("Veuillez répondre que par (A), (B), (Y) ou (X)", false, true); 
            return rwkSwitchCase(tableau, index, types, sector, duration, unit, onsale, reduce, vehicles_autos); //relancement de sécurité
        }
        return tableau;
    }

    public static String rwkDateTimeFormatter(String prompt){
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
            switch(operator){
                case "1": //add date and not time
                formatter = DateTimeFormatter.ofPattern(date_txt);
                String date_string = rwkTxtString(prompt +" (format JJ/MM/AAAA)", true, false);
                //checking format date
                LocalDate.parse(date_string, formatter); // check si bien format date
                result = date_string; break;

                case "2":  //add time and not date
                formatter = DateTimeFormatter.ofPattern(time_txt);
                String time_string = rwkTxtString(prompt +" (format HH:MM)", true, false);
                LocalTime.parse(time_string, formatter); // check si bien format time
                result = time_string; break;

                case "3":  //collate date and time
                rwkTxtString("à voir plus tard", false, false); break;

                case "4":  //releases date in EU
                formatter = DateTimeFormatter.ofPattern(time_txt+" "+date_txt);
                LocalDateTime date_time = LocalDateTime.parse(result, formatter);
                String formattedDate = date_time.format(formatter);
                System.out.println("Date d'aujourd'hui format Francophone: " + formattedDate);
                result = formattedDate; break;

                //case "5":

                // voir d'autres options comme prendre le temps et l'afficher en string
                // voir pour ajouter d'autres options comme ajouter soit un an, un jour ect
                // Essyere de voir si possible d'utiliser un variable à la place de parseYear ???

                default: System.out.println("(op_error)"); break;
            }
            return result;
        }catch (Exception e){
            Exceptioner.TxtException(e, 0);
            return rwkDateTime(prompt, operator, result);
        }
    }

    public static void AfficherTouteValeurTableau(int[] tableau) {
        for (int i = 0; i < tableau.length; i++) {
            System.out.println("Valeur à l'index " + i + " : " + tableau[i]); // Affiche chaque valeur du tableau
        }
    }

    public static void rwkLoopArraysList(ArrayList<String> tableau){
        if (tableau.isEmpty()) {
            rwkTxtString("La liste est vide", false, false);
        }else{
            rwkTxtString("Voici la liste d'articles", false, false);
            for(String nom:tableau){
                rwkTxtString(nom, false, false);
            }
        }
    }

    //public static String TrouverUnNoms(ArrayList<String> stagiaires, String rechercheNom){
    public static String TrouverUnNoms(ArrayList<String> stagiaires){
        String rechercheNom = rwkTxtString("Rechercher :", true, false);

        if(stagiaires.contains(rechercheNom)){
            rwkTxtString(rechercheNom+" Existe dans la liste, à la position "+stagiaires.indexOf(rechercheNom), false, false);
            //return stagiaires;
            return rechercheNom+" Existe dans la liste, à la position "+stagiaires.indexOf(rechercheNom);
        }else{
            //return stagiaires;
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
                    case "YES": case "TRUE": case "OUI": return true;
                    case "NO": case "FALSE": case "NON": return false;
                    default: rwkTxtString("Veuillez répondre par YES/NO, TRUE/FALSE ou OUI/NON", false, true); 
                    return rwkTxtBoolean(prompt, convert);
                }
            //}else if(!convert){
                //return sc.nextBoolean();
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
            Exceptioner.TxtException(e, 0);
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
            double clavier = sc.nextDouble();
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