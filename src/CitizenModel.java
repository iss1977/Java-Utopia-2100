public class CitizenModel { // here we store the proprieties of a citizen but also can be part of an offer provided by an activity

    final public Integer DUMM_ABER_REICH = 1;
    final public Integer DUMM_UND_ARM = 1;

    public Proprieties proprieties = new Proprieties();
    public Status  status = new Status();
    public Assets assets = new Assets();



    public CitizenModel() {
    }  // is an Object in CitizenController where the Citizen proprieties are stored.

    class Proprieties{
        public  Double inteligence = 0.0;
        public  Double power = 0.0;
        public  Double socialSkills =0.0;
        public  Double courage = 0.0;
        public  Double BankkontoUtopiaDollar = 0.0;

        @Override
        public String toString() {
            return "Proprieties{" +
                    "inteligence=" + inteligence +
                    ", power=" + power +
                    ", socialSkills=" + socialSkills +
                    ", courage=" + courage +
                    ", BankkontoUtopiaDollar=" + BankkontoUtopiaDollar +
                    '}';
        }
    }

     static class Status{
        Status(){
            //wtf
        }
        public  Boolean isAlive=true;
        public  Double hunger = 0.0;
        public  Double rest = 0.0;
        public  Double health = 5.0;
        public  Double fun = 0.0;


         @Override
         public String toString() {
             return "Status{" +
                     "isAlive=" + isAlive +
                     ", hunger=" + hunger +
                     ", rest=" + rest +
                     ", health=" + health +
                     ", fun=" + fun +
                     '}';
         }
     }

    static class Assets{
        public Boolean hasAHouse = false;
        public Boolean hasABike = false;
        public Boolean hasACar = false ;
        public Double utopiaDollar = 0.0;

        @Override
        public String toString() {
            return "Assets{" +
                    "hasAHouse=" + hasAHouse +
                    ", hasABike=" + hasABike +
                    ", hasACar=" + hasACar +
                    ", Utopia Dollar=" + utopiaDollar +
                    '}';
        }
    }



    public void generateRandomData4Citizen(){
        this.proprieties.inteligence = GlobalStacker.generateRandomInteger(2,5).doubleValue(); // An Integer is returned by generateRandomInteger witch has an doubleValue() method
        this.proprieties.power=GlobalStacker.generateRandomInteger(1,5).doubleValue();
        this.proprieties.socialSkills=GlobalStacker.generateRandomInteger(1,5).doubleValue();
        this.proprieties.courage=GlobalStacker.generateRandomInteger(1,5).doubleValue();
        this.status.fun=GlobalStacker.generateRandomInteger(2,5).doubleValue();
        this.status.health=GlobalStacker.generateRandomInteger(2,5).doubleValue();
        this.status.hunger=GlobalStacker.generateRandomInteger(1,5).doubleValue();
        this.status.rest= GlobalStacker.generateRandomInteger(3,5).doubleValue();
        this.assets.hasABike = GlobalStacker.generateRandomInteger(0, 1) != 0;
        this.assets.hasAHouse = GlobalStacker.generateRandomInteger(0, 1) != 0;
        this.assets.hasACar = GlobalStacker.generateRandomInteger(0, 1) != 0;
    }


    @Override
    public String toString() {
        return "CitizenModel{" +
                "proprieties=" + proprieties.toString() +
                ", status=" + status.toString() +
                ", assets=" + assets.toString() +
                '}';
    }
}// end of class

