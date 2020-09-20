public class Tester {

    static Integer runTheTestOnEveryThisNumberOfTicks = 1; // Change this value to set tick sequence that will run the following method

    public void runDeveloperTest(){ // this method will run on each tick. // deprecieted. Use middleTick()!
    }

    public void firstTick(){
        System.out.println("TESTER - > FIRST TICK");
        Main.myController.registerCitizen(new Citizen("Donald Trump", 2030,5,25)); // register the Trump VIP citizen
        Main.myController.registerCitizen(new Citizen("Justin Bieber", 2072,6,22)); // register the second citizen can work like that.
        Main.myController.registerCitizen(new Citizen("Leonardo DiCaprio", 2058,2,17));
        Main.myController.registerCitizen(new Citizen("Kim Kardashian", 2068,1,11));
        Main.myController.registerCitizen(new Citizen("Bill Gates", 2037,9,2)); // 5 in total
        Main.myController.generateCitizens(2);



        // Let's init an service with children
        ActivityBlueprint newRootActivity= new ActivityBlueprint( ActivityType.ROOTACTIVITY,"Food Root Service","This is the root(parent) node for the food related service","FOOD ROOT",0,"Sebastian");

        //adding some node activities
        ActivityBlueprint newRestaurantNodeActivity= new ActivityBlueprint( ActivityType.NODEACTIVITY,"Restaurants","Here you can register your restaurants","Node for Restaurants",0,"Sebastian");
        newRootActivity.addChildActivity(newRestaurantNodeActivity);

        // let's make a fun NODE
        ActivityBlueprint newFunNodeActivity= new ActivityBlueprint( ActivityType.NODEACTIVITY,"Fun","Here you can register your fun places","Node for fun",10,"Sebastian");
        newRootActivity.addChildActivity(newFunNodeActivity);


        ActivityCircus myCircus = new ActivityCircus("Circus Bellagio", "Let the kids stay @ home. Nice chicks around", 20,"Sebastian");
        newFunNodeActivity.addChildActivity(myCircus);


        //delete this after root-node methode works!
        Main.myController.registerActivity(myCircus);

        // let's take on offer from myCircus:
        System.out.println(myCircus.makeOffer());


//        ActivityCircus myFoodService;
//        myFoodService = new ActivityCircus("Food","Mc Donalds","A nice place to eat some fast food","Sebastian");
//        Main.myController.registerActivity(myFoodService);
//        myFoodService = new ActivityCircus("Food","Home","No place like home","Sebastian");
//        Main.myController.registerActivity(myFoodService);
//        myFoodService = new ActivityCircus("Food","Fancy Reastaurant","Luxus for the reach people","Sebastian");
//        Main.myController.registerActivity(myFoodService);
//        myFoodService = new ActivityCircus("Food","Dreckige Fastfood","Weil ich arm bin un pleite.","Sebastian");
//        Main.myController.registerActivity(myFoodService);
//



    }

    public void middleTick(){
        System.out.println("TESTER - > MIDDLE TICK");
        for (int i = 0 ; i < 10; i++) {
            Main.myController.doActivity(Main.myController.getRandomActivity(), Main.myController.getRandomCitizen());
        }

        // custom test
        ActivityBlueprint myCircus = Main.myController.getActivityLike("ActivityCircus3");
        if (myCircus!=null) System.out.println("FOUND MY CIRCUS : "+myCircus.toString());


    }

    public void lastTick(){
        System.out.println("TESTER - > LAST TICK");
    }

}
