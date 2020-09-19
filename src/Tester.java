public class Tester {

    static Integer runTheTestOnEveryThisNumberOfTicks = 1; // Change this value to set tick sequence that will run the following method

    public void runDeveloperTest(){ // this method will run on each tick.
        System.out.println("---------------------  Hello from tester. -----------------------");





        //delete what you want from this method, this code is an example.
        // Referencing the controller like         Main.myController  will not work!

        Main.myController.generateCitizens(1);
        for (int i = 0 ; i < 1; i++) {
            Main.myController.doActivity(Main.myController.getRandomActivity(), Main.myController.getRandomCitizen());
        }
        System.out.println("Utopia time is "+Main.myController.getUtopiaTime());





        System.out.println("------------------------------------------------------------------");
    }

    public void firstTick(){

    }

    public void middleTick(){

    }

    public void lastTick(){

    }

}
