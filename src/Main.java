import java.util.Date;
import java.util.Scanner;

public class Main {
    public static Citizen myCitizen = new Citizen("First Citizen", 2080,5,25);
    public static Controller myController = new Controller(new Date());

    public static Controller myController = new Controller(); // controller must run before the first citizen is created.
    public static Citizen myCitizen = new Citizen("Donald Trump", 2030,5,25);

    public static ActivityFood myFoodService = new ActivityFood();




    public static void main(String[] args) {

        System.out.println("My Citizen is alive. He is "+ myCitizen.toString());
        myController.registerCitizen(myCitizen); // register the static citizen

        myController.registerCitizen(new Citizen("Justin Bieber", 2072,6,22)); // register the second citizen can work like that.
        myController.registerCitizen(new Citizen("Leonardo DiCaprio", 2058,2,17));
        myController.registerCitizen(new Citizen("Kim Kardashian", 2068,1,11));
        myController.registerCitizen(new Citizen("Bill Gates", 2037,9,2)); // 5 in total

        System.out.println("Controller is alive since "+myController.getStartedAT().toString());

        int controllNumber = myController.registerActivity(myFoodService);
        System.out.println("Activity registered. Category:"+myFoodService.category+" | Description:"+myFoodService.serviceDescription+" | Registration nr: "+controllNumber+" | Created by:"+myFoodService.createdBy);



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
