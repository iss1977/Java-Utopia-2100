import java.util.Date;

public class Citizen extends CitizenController {
<<<<<<< HEAD
    Citizen(String name, int yearOfBirth, int monthOfBirth , int dayOfBirth) {
        super (name, yearOfBirth, monthOfBirth , dayOfBirth);
    }

    @Override
    public void ontick(){
        super.ontick(); // let the superclass do it's job


=======
    Citizen(Date birthDate, String name) {
        super(birthDate, name);
>>>>>>> 6527e55c466a827f1530eb38d7a48b85be7d27b4
    }
}
