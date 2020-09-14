import java.util.Date;
import java.util.Scanner;

public class Main {
<<<<<<< HEAD
    public static Citizen myCitizen = new Citizen("First Citizen", 2080,5,25);
    public static Controller myController = new Controller(new Date());

    public static void main(String[] args) {

        System.out.println("My Citizen is alive. He is "+ myCitizen.toString());
        System.out.println("Controller is alive since "+myController.getStartedAT().toString());

        // this is an endless loop. It will run so long as the controller returns true. It will return false on the next tick() after we call GlobalStacker.stopUtopia()
        boolean endlessloop = true;
        while (endlessloop) {
            endlessloop = myController.cycle();
            //System.out.println("My citizen is "+myCitizen.getAgeInDays());
=======

    public static void main(String[] args) {
        Controller myController = new Controller(new Date());
        Citizen myCitizen = new Citizen(new Date(), "First Citizen");


        System.out.println("My Citizen is alive. He is "+myCitizen.toString());
        System.out.println("Controller is alive since "+myController.getStartedAT().toString());

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        boolean endlessloop = true;
        while (endlessloop) {
           myController.cycle();

>>>>>>> 6527e55c466a827f1530eb38d7a48b85be7d27b4
        }
    }
}
