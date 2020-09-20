import java.util.ArrayList;

 public class ActivityBlueprint {
    ActivityType activityType=ActivityType.UNDEFINED; // here will be the activity type
    ArrayList<ActivityBlueprint> childActivities= new ArrayList<ActivityBlueprint>(); // here we gonna add the child activities
    String category;
    String nameOfThePlace ; // ex: "MC Donalds"
    String serviceDescription;
    String createdBy;
    Integer capacityInCitizens;


     public ActivityBlueprint(){ // default constructor

     }

    ActivityBlueprint(ActivityType activityType, String category, String nameOfThePlace, String serviceDescription, Integer capacityInCitizens, String createdBy ){ // constructor
        this.category=category;
        this.nameOfThePlace=nameOfThePlace;
        this.serviceDescription=serviceDescription;
        this.createdBy=createdBy;
        this.activityType=activityType;
        this.capacityInCitizens = capacityInCitizens;
    }


    public void ontick(){

    }

    // here you can add a child activity
    boolean addChildActivity(ActivityBlueprint activity){
        if (activity!=null) {
            this.childActivities.add(activity);
        } else {
            System.out.println("Activityblueprint.addChildActivity recieved a null object to register. ERROR !!!");
        }
        return activity!=null;
    }
}

