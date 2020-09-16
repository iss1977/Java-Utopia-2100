public class ActivityFood extends ActivityBlueprint {
    ActivityFood(){
        super("Food","A place to take some food in...","Sebastian");
    }
    public Integer getOffer(Citizen citizen){
        return 100;
    }
}
