import java.util.Scanner;
public class converter_handling {
    
    public static void FIDC(double fidc) {
        fidc = fidc * 20;
        //fInitialDragCoeff (0.0 - 20.0)
        System.out.println("<fInitialDragCoeff value="+ fidc +"/>");
    }

    public static void FIDF(double fidf) {
        fidf = ((2 -(fidf / 10))/ 4);
        //fInitialDriveForce (0.0 - 2.0)
        System.out.println("<fInitialDriveForce value="+ fidf +"/>");
    }

    public static void FDI(double fdi) {
        
        //fDriveInertia (0.0 - 2.0)
        System.out.println("<fInitialDriveForce value="+ fdi +"/>");
    }

    public static void main(String[] args) {
        try{

            double fidc = 0, fidf = 0;

            Scanner sc = new Scanner(System.in); // Déclaration du scanner Instance de l'Objet Scanner 
            boolean relaunch = true;

            while(relaunch){
                System.out.println("AERODYNAMIQUE");
                //Généralement entre 0.0 à 1.0 et en unité "Cx" (coefficient de traînée)
                fidc = sc.nextDouble();
                FIDC(fidc);
                System.out.println("ACCELERATION");
                //Généralement en seconde de 0 à 100 km
                fidf  = sc.nextDouble();
                FIDF(fidf);
                System.out.println("PUISSANCE");
                fidf  = sc.nextDouble();
                FIDF(fidf);

                relaunch = false;
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("ERROR FATAL 404");
        }
    }
}