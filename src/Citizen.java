import java.util.Date;

public class Citizen extends CitizenController {
<<<<<<< HEAD
    Citizen(String name, int yearOfBirth, int monthOfBirth , int dayOfBirth) {
        super (name, yearOfBirth, monthOfBirth , dayOfBirth);
    }
// ontick() method of superclass is final, @Override of ontick() method is forbidden

    public void onTick(){
        System.out.println("Citizen \""+this.toString()+"\" had had a tick.... nice.");
    }


    Citizen(Date birthDate, String name) {
        super(birthDate, name);
    }
}
