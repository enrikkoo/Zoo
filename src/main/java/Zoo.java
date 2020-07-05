import java.util.ArrayList;
import java.util.logging.Level;

/**
 * This class is an ConcreteObservable
 * It defines methods for adding, deleting subscribers and notifying them
 */
public class Zoo implements Observable {

    /**
     * Contains a list of all animal-observers
     */
    public static final ArrayList<Animal> all_animals = new ArrayList<>();

    public static void info() {
        Main.LOGGER.log(Level.INFO, "Current status of animals in the zoo : ");
        Main.LOGGER.log(Level.INFO, all_animals.toString());
    }

    /**
     * Adds an animal to the list of observers
     *
     * @param animal - some animal
     */
    public void addAnimal(Animal animal) {
        all_animals.add(animal);
    }

    /**
     * Remove an animal from the list of observers
     */
    public void removeAnimal(Animal animal) {
        all_animals.remove(animal);
    }

    /**
     * The ConcreteObservable notifies all of the observers
     *
     * @param event - an event that happened at the zoo
     */
    public void notifyAnimals(Event event) {
        Main.LOGGER.log(Level.INFO, event.toString());
        for (Animal animal : all_animals) {
            animal.update(event);
        }
    }

    /**
     * The ConcreteObservable notifies all of a certain type
     *
     * @param event - an event that happened at the zoo
     * @param type  - type of animal
     */
    public void notifyAnimals(Event event, AnimalTypes type) {
        Main.LOGGER.log(Level.INFO, event.toString() + " " + type.toString());
        switch (type) {
            case CARNIVORE:
                for (Animal animal : all_animals) {
                    if (animal instanceof Carnivore) {
                        animal.update(event);
                    }
                }
                break;
            case HERBIVORE:
                for (Animal animal : all_animals) {
                    if (animal instanceof Herbivore) {
                        animal.update(event);
                    }
                }
                break;
        }
    }
}
