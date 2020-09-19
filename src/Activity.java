public class Activity extends ActivityBlueprint {
    Activity(String category, String nameOfThePlace, String descriptionOfThePlace, String createdBy){
        super(category, nameOfThePlace, descriptionOfThePlace, createdBy);
    }
    public Integer getOffer(Citizen citizen){
        return 100;
    }
}
