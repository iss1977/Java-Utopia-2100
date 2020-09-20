public class Main {

    public static Controller myController = new Controller();;

    public static void main(String[] args) {

    //    Main.myController= new Controller(); // controller must run before the first citizen is created.
        System.out.print("Declaring services ....");
        GlobalStacker.declareServices();
        System.out.println("done.");


        System.out.println("Controller is alive since " + myController.getStartedAT().toString());

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
