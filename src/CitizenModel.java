public class CitizenModel {

    final public Integer DUMM_ABER_REICH = 1;
    final public Integer DUMM_UND_ARM = 1;

    public Proprieties proprieties = new Proprieties();
    public Status  status = new Status();



    public CitizenModel() {
    }  // is an Object in CitizenController where the Citizen proprieties are stored.
    class Proprieties{
        public  Integer inteligence;
        public  Integer power = 0;
        public  Integer socialSkills =0;
        public  Integer courage = 0;
        public  Integer BankkontoUtopiaDollar = 5000;
    }

     static class Status{
        Status(){
            //wtf
        }
        public  Boolean isAlive=true;
        public  Integer hunger = 0;
        public  Integer rest = 0;
        public  Integer health = 5;
        public  Integer fun = 0;
    }



    public void generateRandomData4Citizen(){
        this.proprieties.inteligence = GlobalStacker.generateRandomInteger(2,5);
        this.proprieties.power=GlobalStacker.generateRandomInteger(1,5);
        this.proprieties.socialSkills=GlobalStacker.generateRandomInteger(1,5);
        this.proprieties.courage=GlobalStacker.generateRandomInteger(1,5);
        this.status.fun=GlobalStacker.generateRandomInteger(2,5);
        this.status.health=GlobalStacker.generateRandomInteger(2,5);
        this.status.hunger=GlobalStacker.generateRandomInteger(1,5);
        this.status.rest= GlobalStacker.generateRandomInteger(3,5);

    }
}
