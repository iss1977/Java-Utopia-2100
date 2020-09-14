import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;




public class Controller{
    private final Date startedAT; // used to store the date-time when utopia was started.
    public Date getStartedAT() { // getter for startedAT
        return startedAT;
    }

    private Date utopiaTime; // used to store the date-time on Utopia. The world there starts at 01.01.2100 00:00
    public Date getUtopiaTime() {
        return utopiaTime;
    }


    private long lastUpdateAtSecond=0; // only to see if a second is passed or not since last tick. Only on second change will be a tick on utopia generated
    Calendar calendar = Calendar.getInstance(); // will also be used to store the time when utopia was started.

    Controller(Date startDateTime){ // CONSTRUCTOR
        this.startedAT= new Date();
        calendar.set(2100, Calendar.JANUARY, 1, 0, 0, 0);
        this.utopiaTime = calendar.getTime();
    }

    public void tick(){

    }

    public void cycle()  { // this can be run as many times as wished. If a complete second is passed since last tick(), then a new tick() is called
        // on each tick we must update utopiaTime !
        // one step has 900 utopia seconds = 15min.
        final int ONEEARTHSECONDIS=900;

        long diffInMillies = Math.abs(new Date().getTime() - startedAT.getTime());
        long diff = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS); // represents the seconds between start of the program and now.
        if (diff!=this.lastUpdateAtSecond){
            this.lastUpdateAtSecond=diff;
            this.utopiaTime = addSecondsToJavaUtilDate(calendar.getTime(),(int) (diff * ONEEARTHSECONDIS));
            System.out.println("Calling a new tick! Utopia is running since:"+diff+" earth seconds. Time on Utopia is now:"+this.utopiaTime.toString());
            this.tick(); // here happens everything.
        }


    }


    private Date addSecondsToJavaUtilDate(Date date, int seconds) { // used to add seconds to a date. => utopiaTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }




}
