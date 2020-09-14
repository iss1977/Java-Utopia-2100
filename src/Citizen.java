import java.util.Date;

public class Citizen extends CitizenController {
    Citizen(String name, int yearOfBirth, int monthOfBirth , int dayOfBirth) {
        super (name, yearOfBirth, monthOfBirth , dayOfBirth);
    }

    @Override
    public void ontick(){
        super.ontick(); // let the superclass do it's job


    }
}
