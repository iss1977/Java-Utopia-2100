import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class GlobalStacker {  // this is a collection of methods and variables available globally
    private GlobalStacker(){}; // can not be instanced

    // change the following value to make utopia time run faster or slower. 3600 = 1 sec on earth is 1 hour on Utopia
    final public static int  oneSecondOnEarthEqualsThisManySecondsOnUtopia = 3600;

    //stop the world and exit the program. Change this value to false to stop Utopia
    public static boolean utopiaIsRunning=true;

    // here you find the total number of registered activities ( where superclass is ActivityBlueprint)
    public static int numberOfRegisteredActivities = 0;

    // We need a handler for our Planer
    public static CitizenPlaner citizenPlaner= new CitizenPlaner();

    // The registered activities are stored in a hashmap
    public static ArrayList<ActivityBlueprint> registeredActivities=new ArrayList<ActivityBlueprint>();

    // The registered citizens are stored in an ArrayList. The controller will access this directly
    public static ArrayList<Citizen> registredCitizens = new ArrayList<Citizen>();


    // this utility is used in CitizenController
    public static Date addSecondsToJavaUtilDate(Date date, int seconds) { // used to add seconds to a date. => utopiaTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }

    public static Integer generateRandomInteger(Integer min, Integer max){
        return (int)Math.round(Math.random()*(max-min)+min);
    }

    public static void declareServices(){

    }

} // end of class GlobalStacker

