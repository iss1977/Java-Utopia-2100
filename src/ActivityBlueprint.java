abstract public class ActivityBlueprint {
    String category;
    String nameOfThePlace ; // ex: "MC Donalds"
    String serviceDescription;
    String createdBy;


    ActivityBlueprint(String category, String nameOfThePlace, String serviceDescription,String createdBy ){ // constructor
        this.category=category;
        this.nameOfThePlace=nameOfThePlace;
        this.serviceDescription=serviceDescription;
        this.createdBy=createdBy;
    }
    abstract public Integer getOffer(Citizen citizen);
}

