import java.util.Date;

abstract public class CitizenController {
    Date birthDate;
    String name;

    CitizenController(Date birthDate, String name){
        this.birthDate=birthDate;
        this.name=name;
    }

}
