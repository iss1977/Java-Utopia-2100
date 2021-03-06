import java.util.Date;

public class Citizen extends CitizenController {
    Citizen(String name, int yearOfBirth, int monthOfBirth , int dayOfBirth) {
        super (name, yearOfBirth, monthOfBirth , dayOfBirth);
    }
// ontick() method of superclass is final, @Override of ontick() method is forbidden

    public void onCitizenTick(){ // will be called from parent class when he receives a tick ...
        System.out.println("-->Citizen \""+this.toString()+"\" had had a tick.... nice.");
    }

    public void  setProprieties(CitizenModel myCitizenProprieties){

    }

    Citizen(Date birthDate, String name) {
        super(birthDate, name);
    }
}
