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
    Calendar calendar = Calendar.getInstance(); // will also be used to store the time when utopia was started. Search for other posibilities

    Controller(){ // CONSTRUCTOR
        this.startedAT= new Date();
        calendar.set(2100, Calendar.JANUARY, 1, 0, 0, 0);
        this.utopiaTime = calendar.getTime();
    } // end of constructor

    // ----------------------------------|  T h e   T I C K |---------------------------------------\\
    public void tick(){
        if (this.lastUpdateAtSecond==10) GlobalStacker.stopUtopia();
        if (this.lastUpdateAtSecond==3){
            this.doActivity(GlobalStacker.registeredActivities.get(1),Main.myCitizen);
        }

        Main.myCitizen.ontick(); // modify here to make a list of citizens. Is not known yet if myCitizen will need ontick() or not, but is available.
    } //  end of tick()

    public boolean cycle()  { // this can be run as many times as wished. If a complete second is passed since last tick(), then a new tick() is called
        // on each tick we must update utopiaTime !
        // one step has 3600 utopia seconds = 1 hour. You can change this in class GlobalStacker
        long diffInMillies = Math.abs(new Date().getTime() - startedAT.getTime());
        long diff = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS); // represents the seconds between start of the program and now.
        if (diff!=this.lastUpdateAtSecond){
            this.lastUpdateAtSecond=diff;
            this.utopiaTime = GlobalStacker.addSecondsToJavaUtilDate(calendar.getTime(),(int) (diff * GlobalStacker.oneSecondOnEarthEqualsThisManySecondsOnUtopia));
            System.out.println("Calling a new tick! Utopia is running since:"+diff+" earth seconds. Time on Utopia is now:"+this.utopiaTime.toString());
            this.tick(); // here happens everything.
        }
    return GlobalStacker.utopiaIsRunning;
    } // end of cycle()

    //every activity that is created must be registered here to be able to make an offer to the citizen.
    public Integer registerActivity(ActivityBlueprint activity){ // the activity will be stored in GlobalStacker \\
        GlobalStacker.registeredActivities.put(++GlobalStacker.numberOfRegisteredActivities, activity);
        return GlobalStacker.numberOfRegisteredActivities;
    }


    public void doActivity(ActivityBlueprint activity, Citizen citizen){
        System.out.println("The activity "+activity.category+" hat returned an offer of "+activity.getOffer(citizen)+" points.");
        System.out.println("The citizen "+citizen.name+","+citizen.age+" old is going to do the activity "+activity.category+" because he knows, "+activity.serviceDescription);
        int hunger = Benefits.hunger;
    }
  } // end of class
