abstract public class ActivityBlueprint {
    String category;
    String serviceDescription;
    String createdBy;


    ActivityBlueprint(String category,String serviceDescription,String createdBy ){ // constructor
        this.category=category;
        this.serviceDescription=serviceDescription;
        this.createdBy=createdBy;
    }
    abstract public Integer getOffer(Citizen citizen);
}

