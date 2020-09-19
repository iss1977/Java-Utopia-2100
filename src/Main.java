public class Main {

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

        System.out.println("Controller is alive since "+myController.getStartedAT().toString());



        // this is an endless loop. It will run so long as the controller returns true. It will return false on the next tick() after we call GlobalStacker.stopUtopia()
        boolean endlessloop = true;
        long counter =0 ;
        while (endlessloop) {
            endlessloop = myController.cycle();
            //System.out.println("My citizen is "+myCitizen.getAgeInDays());
        }// end of endless loop
    } // end of psvm

    public void tester(){
        System.out.println("---------------------  Hello from tester. -----------------------");
    }

}//end of class
