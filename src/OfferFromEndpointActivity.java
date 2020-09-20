import java.time.Duration;

public class OfferFromEndpointActivity {
    ActivityBlueprint offertant; // that we can return this in our offer for the citizen.
    Boolean available = false; // false if no offer available
    Duration durationInMinutes;
    Boolean citizenCanQuit;
    OfferType offerType;
    Benefits offerBenefits = new Benefits(); // create an object to store the data in class Benefits

    public class Benefits{
        public CitizenModel citizenModel = new CitizenModel();

        @Override
        public String toString() {
            return "Benefits : {" +
                    "citizenModel=" + citizenModel.toString() +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OfferFromEndpointActivity : {" +
                "offertant=" + offertant.getClass().getSimpleName() +
                ", available=" + available +
                ", Duration (h)=" + durationInMinutes.toHours() +
                ", citizenCanQuit=" + (citizenCanQuit?"Yes":"No") +
                ", offerType=" + offerType +
                ", offerBenefits=" + offerBenefits.toString() +
                '}';
    }
}

enum OfferType{
    ONETIME, CONTRACT;
}