import java.util.Calendar;
import java.util.Date;

public class GlobalStacker {  // this is a collection of methods and variables available globally
    private GlobalStacker(){}; // can not be instanced

    // change the following value to make utopia time run faster or slower. 3600 = 1 sec on earth is 1 hour on Utopia
    final public static int  oneSecondOnEarthEqualsThisManySecondsOnUtopia = 3600;

    //stop the world and exit the program. Change this value to false to stop Utopia
    public static boolean utopiaIsRunning=true;

    public static void stopUtopia() {utopiaIsRunning=false;}

    public static Date addSecondsToJavaUtilDate(Date date, int seconds) { // used to add seconds to a date. => utopiaTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }
}

