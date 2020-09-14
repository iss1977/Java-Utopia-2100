import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

abstract public class CitizenController {
    Date birthDate;
    String name;
    Duration age; // will be calculated at each tick

    CitizenController(String name, int yearOfBirth, int monthOfBirth , int dayOfBirth){
        Calendar calendar = Calendar.getInstance();
        calendar.set(yearOfBirth, monthOfBirth, dayOfBirth, 0, 0, 0);
        this.birthDate=calendar.getTime();
        this.name=name;
    }

    void ontick(){ // will be called from  Utopia controller each time there is a tick ...

        // calculate the age of the citizen on every tick -> is probably not necessary
        long diffInMillies = Math.abs(Main.myController.getUtopiaTime().getTime() - birthDate.getTime());
        long diff = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS); // represents the seconds between start of the program and now.
        this.age= Duration.ofSeconds(diff);

    }

    public int getAgeInDays(){ // calculates the age and return it.
        long diffInMillies = Math.abs(Main.myController.getUtopiaTime().getTime() - birthDate.getTime());
        long diff = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS); // represents the seconds between start of the program and now.
        this.age= Duration.ofSeconds(diff);
    return (int) this.age.toDays();
    }
}
