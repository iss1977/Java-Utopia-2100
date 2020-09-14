import java.util.Date;
import java.util.Scanner;

public class Main {
    public static Citizen myCitizen = new Citizen("First Citizen", 2080,5,25);
    public static Controller myController = new Controller();

    public static ActivityFood myFoodService = new ActivityFood();




    public static void main(String[] args) {

        System.out.println("My Citizen is alive. He is "+ myCitizen.toString());
        System.out.println("Controller is alive since "+myController.getStartedAT().toString());

        int controllNumber = myController.registerActivity(myFoodService);
        System.out.println("Activity registered. Category:"+myFoodService.category+" | Description:"+myFoodService.serviceDescription+" | Registration nr: "+controllNumber+" | Created by:"+myFoodService.createdBy);

        // this is an endless loop. It will run so long as the controller returns true. It will return false on the next tick() after we call GlobalStacker.stopUtopia()
        boolean endlessloop = true;
        while (endlessloop) {
            endlessloop = myController.cycle();
            //System.out.println("My citizen is "+myCitizen.getAgeInDays());
        }
    }
}
