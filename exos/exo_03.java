import java.util.Scanner;

public class exo_03 {

    public static int addition(int a, int b){
        return a + b;
    }

    public static String evenAndOdd(int a){
        String txt = "La valeur ("+ a +") est ";
            if (a % 2 == 0) {
                txt += "pair";
            } else { 
                txt += "impair";
            }
        return txt;
    }

    public static void main(String[] args) {

        try{
            Scanner sc = new Scanner(System.in);
            String notif = "Veuillez mettre une valeur pour ";
        
            System.out.println(notif +"A");
            int a = sc.nextInt();

            System.out.println(notif +"B");
            int b = sc.nextInt();

            int result = addition(a, b);
            System.out.println(evenAndOdd(result));

        }catch (Exception e){
            System.out.println("ERROR FATAL 404");
        }
    }
}