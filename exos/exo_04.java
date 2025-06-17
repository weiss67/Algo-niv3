import java.util.Scanner;

public class exo_04 {

    public static String divisible(int a){
        String txt = "La valeur ("+ a +") est ";
            if (a % 2 == 0) {
                txt += "divisible";
            } else { 
                txt += "indivisible";
            }
        return txt;
    }

    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Veuillez mettre une valeur pour diviser");
            int value = sc.nextInt();

            System.out.println(divisible(value));
            sc.close();
        } catch (Exception e) {
            System.out.println("ERROR FATAL 404");
        }
    }
}