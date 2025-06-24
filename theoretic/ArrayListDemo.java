package theoretic;

import java.util.ArrayList;
import methods.functions;

public class ArrayListDemo {
    public static void main(String[] args) {

    ArrayList<String> stagiaires = new ArrayList<>();

    stagiaires.add("Benjamin");
    stagiaires.add("Léa"); 
    stagiaires.add("Jérémie"); 
    stagiaires.add("Mamadou"); 
    stagiaires.add("Iliyana"); 

    functions.ListeDesNoms(stagiaires);
    System.err.println(functions.TrouverUnNoms(stagiaires,"Léa"));

    System.err.println(functions.rwkDeleteName(stagiaires,"Léa"));
    functions.ListeDesNoms(stagiaires);
    }
}