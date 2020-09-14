import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Controller myController = new Controller(new Date());
        Citizen myCitizen = new Citizen(new Date(), "First Citizen");


        System.out.println("My Citizen is alive. He is "+myCitizen.toString());
        System.out.println("Controller is alive since "+myController.getStartedAT().toString());

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        boolean endlessloop = true;
        while (endlessloop) {
           myController.cycle();

        }
    }
}
