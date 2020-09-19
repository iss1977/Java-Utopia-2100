public class Main {

<<<<<<< HEAD

    public static Controller myController = new Controller(); // controller must run before the first citizen is created.
    public static Citizen myCitizen = new Citizen("Donald Trump", 2030, 5, 25);

    public static ActivityFood myFoodService = new ActivityFood();


    public static void main(String[] args) {

        System.out.println("My Citizen is alive. He is " + myCitizen.toString());
        myController.registerCitizen(myCitizen); // register the static citizen

        myController.registerCitizen(new Citizen("Justin Bieber", 2072, 6, 22)); // register the second citizen can work like that.
        myController.registerCitizen(new Citizen("Leonardo DiCaprio", 2058, 2, 17));
        myController.registerCitizen(new Citizen("Kim Kardashian", 2068, 1, 11));
        myController.registerCitizen (new Citizen("Bill Gates", 2037, 9, 2)); // 5 in total
=======
    public static Controller myController = new Controller();;

    public static void main(String[] args) {

    //    Main.myController= new Controller(); // controller must run before the first citizen is created.
        System.out.print("Declaring services ....");
        GlobalStacker.declareServices();
        System.out.println("done.");

        myController.registerCitizen(new Citizen("Donald Trump", 2030,5,25)); // register the Trump VIP citizen
        myController.registerCitizen(new Citizen("Justin Bieber", 2072,6,22)); // register the second citizen can work like that.
        myController.registerCitizen(new Citizen("Leonardo DiCaprio", 2058,2,17));
        myController.registerCitizen(new Citizen("Kim Kardashian", 2068,1,11));
        myController.registerCitizen(new Citizen("Bill Gates", 2037,9,2)); // 5 in total
        myController.generateCitizens(15);
>>>>>>> Develop

        System.out.println("Controller is alive since " + myController.getStartedAT().toString());

<<<<<<< HEAD
        int controllNumber = myController.registerActivity(myFoodService);
        System.out.println("Activity registered. Category:" + myFoodService.category + " | Description:" + myFoodService.serviceDescription + " | Registration nr: " + controllNumber + " | Created by:" + myFoodService.createdBy);
=======
>>>>>>> Develop


        // this is an endless loop. It will run so long as the controller returns true. It will return false on the next tick() after we call GlobalStacker.stopUtopia()
        boolean endlessloop = true;
        long counter =0 ;
        while (endlessloop) {
            endlessloop = myController.cycle();
            //System.out.println("My citizen is "+myCitizen.getAgeInDays());
<<<<<<< HEAD


        }
    }

}
=======
        }// end of endless loop
    } // end of psvm

    public void tester(){
        System.out.println("---------------------  Hello from tester. -----------------------");
    }

}//end of class
>>>>>>> Develop
