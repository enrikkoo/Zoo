import java.util.ArrayList;
import java.util.logging.Level;

/**
 *  This class is an Observer(Publisher)
 *  It defines methods for adding, deleting subscribers and notifying them
 */
public class Zoo {

    /**
     *  Contains a list of all animal-subscribers
     */
    public static final ArrayList<Animal> all_animals = new ArrayList<>();

    public Zoo() {
        JSON_Reader.parseJSON();
    }

    public static void info() {
        Main.LOGGER.log(Level.INFO,"Current status of animals in the zoo : ");
        Main.LOGGER.log(Level.INFO,all_animals.toString());
    }

    /**
     * Adds an animal to the list of subscribers
     * @param animal - some animal
     */
    public static void addAnimal(Animal animal) {
        all_animals.add(animal);
    }

    /**
     * Remove an animal from the list
     * @param animal
     */
    public void removeAnimal(Animal animal) {
        all_animals.remove(animal);
    }

    /**
     * The observer notifies all of the subscribers
     * @param event - an event that happened at the zoo
     */
    public void notifyAnimals(Event event) {
        Main.LOGGER.log(Level.INFO,event.toString());
        for (Animal animal : all_animals) {
            animal.update(event);
        }
    }

    /**
     * The observer notifies all subscribers of a certain type
     * @param event - an event that happened at the zoo
     * @param type - type of animal
     */
    public void notifyAnimals(Event event, AnimalTypes type) {
        Main.LOGGER.log(Level.INFO,event.toString()+" "+type.toString());
        switch (type){
            case CARNIVORE:
                for (Animal animal : all_animals){
                    if (animal instanceof Carnivore){
                        animal.update(event);
                    }
                }
                break;
            case HERBIVORE:
                for (Animal animal : all_animals){
                    if (animal instanceof Herbivore){
                        animal.update(event);
                    }
                }
                break;
        }
    }
}
