/**
 * These methods are used for interaction between the client and the zoo
 * Each method notifies the observer of an event, and then the observer notifies everyone else
 */
public class User_Tools {

    private  Zoo zoo;
    User_Tools(Zoo zoo){
        this.zoo = zoo;
    }

    void visit(AnimalTypes type){
        if (type == AnimalTypes.HERBIVORE){
            zoo.notifyAnimals(Event.KEEPER_COME);
        }else {
            zoo.notifyAnimals(Event.KEEPER_COME,type);
        }
    }

    void feed(AnimalTypes type){
        zoo.notifyAnimals(Event.FEEDING,type);
    }

    void setThunder(){
        zoo.notifyAnimals(Event.THUNDER);
    }

    void setMorning(){
        zoo.notifyAnimals(Event.MORNING);
    }

    void setNight() {
        zoo.notifyAnimals(Event.NIGHT);
    }
}
