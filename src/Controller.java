
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Controller {
    private  Date startedAT = new Date(); // used to store the date-time when utopia was started.

    private TickType currentTickType = TickType.UNDEFINED;

    public Date getStartedAT() { // getter for startedAT
        return startedAT;
    }

    private Date utopiaTime; // used to store the date-time on Utopia. The world there starts at 01.01.2100 00:00

    public Date getUtopiaTime() {
        return utopiaTime;
    }

    private long lastUpdateAtSecond= -1; // only to see if a second is passed or not since last tick. Only on second change will be a tick on utopia generated
    Calendar calendar = Calendar.getInstance(); // will also be used to store the time when utopia was started. Search for other possibilities

    public Tester tester=new Tester();

    Controller() { // CONSTRUCTOR
        this.startedAT = new Date();
        calendar.set(2100, Calendar.JANUARY, 1, 0, 0, 0);
        this.utopiaTime = calendar.getTime();
        System.out.println("myController (this) class is "+this.getClass().getName());
    } // end of constructor

    // ----------------------------------|  T h e   T I C K |---------------------------------------\\
    //
    public void tick(){
        // we check if ever ticked, if that's the case, run the initialisations.
        if (currentTickType == TickType.UNDEFINED){
            currentTickType = TickType.FIRSTTICK;
            tester.firstTick(); // run the init procedure in Tester.
            currentTickType = TickType.NORMALTICK;
            this.tickAllCitizensAndActivities();
            tester.middleTick();
        }
        else if (currentTickType == TickType.NORMALTICK){ // after the init method, we run the normal tick
            this.tickAllCitizensAndActivities();
            tester.middleTick(); // run the middleTick method in tester
            if (this.lastUpdateAtSecond==3) this.stopUtopia(); // utopia will end on next tick()
        }
        else if (currentTickType == TickType.LASTTICK){ // after the init method, we run the normal tick
            this.tickAllCitizensAndActivities();
            tester.middleTick(); // run the middleTick method in tester
            GlobalStacker.utopiaIsRunning = false; // this will cause the cycle method of this class to return false to main() and end the program
            tester.lastTick();
        }






        if (this.lastUpdateAtSecond % Tester.runTheTestOnEveryThisNumberOfTicks == 0) tester.runDeveloperTest(); // here can we put some test code.



    } //  end of tick()  -----------------------------------------------------------------------------\\




    public boolean cycle() { // this can be run as many times as wished. If a complete second is passed since last tick(), then a new tick() is called
        // on each tick we must update utopiaTime !
        // one step has 3600 utopia seconds = 1 hour. You can change this in class GlobalStacker

        long diffInMilliesInWorldClock = Math.abs(new Date().getTime() - startedAT.getTime());
        long diff = TimeUnit.SECONDS.convert(diffInMilliesInWorldClock, TimeUnit.MILLISECONDS); // represents the seconds between start of the program and now.
        this.utopiaTime = GlobalStacker.addSecondsToJavaUtilDate(calendar.getTime(),(int) (diff * GlobalStacker.oneSecondOnEarthEqualsThisManySecondsOnUtopia));


        if (diff!=this.lastUpdateAtSecond){
            this.lastUpdateAtSecond=diff;
            System.out.println("\r\nCalling a new tick! Utopia is running since:"+diff+" earth seconds. Time on Utopia is now:"+this.utopiaTime.toString());
            this.tick(); // here happens everything.
        }
        return GlobalStacker.utopiaIsRunning;

    } // end of cycle()

    //every activity that is created must be registered here to be able to make an offer to the citizen.
    public void registerActivity(ActivityBlueprint activity){ // the activity will be stored in GlobalStacker \\
        GlobalStacker.registeredActivities.add(activity);
    }

    // call this method to register a citizen (add it to ArrayList GlobalStacker.registredCitizens )
    public void registerCitizen(Citizen citizen) {
        GlobalStacker.registredCitizens.add(citizen);
        System.out.println("The Citizen " + citizen.toString() + " was registered.");
    }

    //call this method if you want a random citizen....
    public Citizen getRandomCitizen(){
        if (GlobalStacker.registredCitizens.size()>0)
        return GlobalStacker.registredCitizens.get(GlobalStacker.generateRandomInteger(0,GlobalStacker.registredCitizens.size()-1));
        return null;
    }

    public ActivityBlueprint getRandomActivity(){
        if (GlobalStacker.registeredActivities.size()>0) {
            Integer randmomIndex = GlobalStacker.generateRandomInteger(0, GlobalStacker.registeredActivities.size() - 1);
            return GlobalStacker.registeredActivities.get(GlobalStacker.generateRandomInteger(0,GlobalStacker.registeredActivities.size()-1));
        }
        return null; // if the size of ArrayList activities is zero
    }

    public ActivityBlueprint getActivityLike(String searchTerm){
        ActivityBlueprint foundActivity = null;
        for (ActivityBlueprint activity: GlobalStacker.registeredActivities) {
            if (activity.getClass().getSimpleName().startsWith(searchTerm))
                foundActivity = activity;
        }
        return foundActivity;
    }


    public boolean doActivity(ActivityBlueprint activity, Citizen citizen){
        if (activity==null || citizen==null) {
            System.out.println("!!!!!!!!!!!!!!!!!!!   doActivity(ActivityBlueprint activity, Citizen citizen) in Controller :  NULL reference as parameter. Exiting the method."+((citizen==null)?" citizen object is null. ":" citizen object ist OK. ")+((activity==null)?" activity object is null. ":" activity object ist OK. "));
            return false;}

        System.out.println("The citizen "+citizen.name+","+citizen.age+" old is going to do the activity "+activity.category+","+activity.nameOfThePlace+" because he knows, "+activity.serviceDescription);
    return true;
    }

    public void generateCitizens(Integer numberOfCitizens){
        Citizen newCitizen;
        for (int i = 1 ; i<= numberOfCitizens; i++){
            newCitizen = new Citizen(RandomNameList.getRandomName() ,GlobalStacker.generateRandomInteger(2050,2099),GlobalStacker.generateRandomInteger(1,12),GlobalStacker.generateRandomInteger(1,28));
            this.registerCitizen(newCitizen);
        }
        System.out.println(numberOfCitizens+" had been generated with random names.");
    }

    public void stopUtopia(){
        System.out.println("STOP UTOPIA WAS CALLED !!!");
        this.currentTickType= TickType.LASTTICK;
    }

    public void tickAllCitizensAndActivities(){
// let's tick every citizen and activity
        for (Citizen citizen: GlobalStacker.registredCitizens) {
            citizen.ontick();
        }
        for (ActivityBlueprint activity: GlobalStacker.registeredActivities){
            activity.ontick();
        }
    }
  } // end of class
