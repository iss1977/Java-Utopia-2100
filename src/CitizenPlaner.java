import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;

public class CitizenPlaner {
    Duration duration = Duration.ofDays(1);
    TemporalAmount temporalAmount = Period.ofYears(1).plusMonths(6).plusDays(3);

    ArrayList<Appointments> storedAppointments = new ArrayList<Appointments>();

    // will use a private inner class to define the stored data
    private class Appointments{
        Citizen citizen;
        LocalDateTime activityStartingAt;
        Duration activityDuration;
        TimeUnits recurency;
        ActivityBlueprint hostingActivity;
        PlanerStatus status;
        PlanerStatus importance;

        public Appointments(Citizen citizen, LocalDateTime activityStartingAt, Duration activityDuration, TimeUnits recurency, ActivityBlueprint hostingActivity, PlanerStatus importance) {
            this.citizen = citizen;
            this.activityStartingAt = activityStartingAt;
            this.activityDuration = activityDuration;
            this.recurency = recurency;
            this.hostingActivity = hostingActivity;
            this.status = PlanerStatus.NOTSTARTED;
            this.importance = importance;
        }
    }

    public boolean addAppointment(Citizen citizen, LocalDateTime activityStartingAt, Duration activityDuration, TimeUnits recurency, ActivityBlueprint hostingActivity, PlanerStatus importance){
        this.storedAppointments.add(new Appointments(citizen,activityStartingAt,activityDuration,recurency,hostingActivity, importance));
        
        return true;
    }

}


