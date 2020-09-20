import java.time.Duration;

public class ActivityCircus extends ActivityBlueprint {

    // here will be the offer stored for the circus. There are other offers in child classes.
    OfferFromEndpointActivity cirkusOffer = null;

    // list the subActivities here ->
    ActivityCircus theCircusBigWheel = new CircusBigWheel();



    ActivityCircus(){
        super();

    };

    ActivityCircus(String nameOfThePlace, String descriptionOfThePlace, Integer capacity,  String createdBy){
        super(ActivityType.ENDPOINTACTIVITY, "FUN", nameOfThePlace, "Let the kids home. Nice girls", capacity, createdBy); // call parent constructor

        // lets initialize the offer of this service and fill the this.cirkusOffer object
        // create an temporary Offer object as described by the class OfferFromEndpointActivity and return it.
        this.cirkusOffer = new OfferFromEndpointActivity(); // creates the object to hold the offer data
        cirkusOffer.offertant = this; // store a reference to the offertant ( this activity circus)
        cirkusOffer.available = true;
        cirkusOffer.durationInMinutes = Duration.ofMinutes(120);
        cirkusOffer.citizenCanQuit = true;
        cirkusOffer.offerBenefits.citizenModel.status.health = + 2.0; // offers 2 units of food
        cirkusOffer.offerBenefits.citizenModel.status.fun = + 2.0 ;
        cirkusOffer.offerBenefits.citizenModel.proprieties.courage = + 0.005;
        cirkusOffer.offerBenefits.citizenModel.proprieties.socialSkills = + 0.005;
        // end of offer

        //let's add the CircusWheel and Fastfood to the suboffers.
        //this.childActivities.add(new CircusBigWheel());
        //this.childActivities.add(new CircusFastFood());

    }


    @Override
    public void ontick() {
        super.ontick();
        // this will be called from controller on each tick:

        System.out.println("-->ActivityCircus Tick:"+this.getClass().getSimpleName());
    }


    private OfferFromEndpointActivity offerFromEndpointActivity; // here will the offer be stored to use in makeOffer()


    public OfferFromEndpointActivity makeOffer(){
        return this.cirkusOffer;
    } // end of makeOffer()


    @Override
    public String toString() {
        return "ActivityCircus{" +
                "activityType=" + activityType +
                ", category='" + category + '\'' +
                ", nameOfThePlace='" + nameOfThePlace + '\'' +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }

    // declare some child activities in Circus.

    public class CircusBigWheel extends ActivityCircus{

        OfferFromEndpointActivity bigWhellOffer = null;

        CircusBigWheel() {
            super("The big wheel - Circus" ,"take a ride", 20, "Sebastian");

            this.bigWhellOffer = new OfferFromEndpointActivity(); // creates the object to hold the offer data
            this.bigWhellOffer.offertant = this; // store a reference to the offertant ( this activity circus)
            this.bigWhellOffer.available = true;
            this.bigWhellOffer.durationInMinutes = Duration.ofMinutes(120);
            this.bigWhellOffer.citizenCanQuit = true;
            this.bigWhellOffer.offerBenefits.citizenModel.status.health = - 0.05; // offers 2 units of food
            this.bigWhellOffer.offerBenefits.citizenModel.status.fun = + 3.0 ;
            this.bigWhellOffer.offerBenefits.citizenModel.proprieties.courage = + 0.1;
            this.bigWhellOffer.offerBenefits.citizenModel.proprieties.socialSkills = - 0.005;
            this.bigWhellOffer.offerBenefits.citizenModel.assets.utopiaDollar = -13.5;


        }
    }

    public class CircusFastFood extends ActivityCircus{

        OfferFromEndpointActivity circusFastFoddOffer = null;


        CircusFastFood() {
            super("The fast food - Circus" ,"take a sandvici", 2, "Sebastian");

            this.circusFastFoddOffer = new OfferFromEndpointActivity(); // creates the object to hold the offer data
            this.circusFastFoddOffer.offertant = this; // store a reference to the offertant ( this activity circus)
            this.circusFastFoddOffer.available = true;
            this.circusFastFoddOffer.durationInMinutes = Duration.ofMinutes(10);
            this.circusFastFoddOffer.citizenCanQuit = true;
            this.circusFastFoddOffer.offerBenefits.citizenModel.status.health = + 0.25; // offers 2 units of food
            this.circusFastFoddOffer.offerBenefits.citizenModel.status.fun = + 0.05 ;
            this.circusFastFoddOffer.offerBenefits.citizenModel.status.hunger= + 1.5;
            this.circusFastFoddOffer.offerBenefits.citizenModel.proprieties.socialSkills = + 0.05;
            this.circusFastFoddOffer.offerBenefits.citizenModel.assets.utopiaDollar = -3.5;


        }
    }

} // end of class ActivityCircus

