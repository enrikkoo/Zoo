/**
 * Interface that concrete observable must match and that must implement appropriate methods
 */
public interface Observable {
    /***
     * Adds an animal to the list of observers
     * @param animal - some animal
     */
    void addAnimal(Animal animal);

    /**
     * Remove an animal from the list of observers
     */
    void removeAnimal(Animal animal);

    /**
     * The ConcreteObservable notifies all of the observers
     *
     * @param event - an event that happened at the zoo
     */
    void notifyAnimals(Event event);

    /**
     * The ConcreteObservable notifies all of a certain type
     *
     * @param event - an event that happened at the zoo
     * @param type  - type of animal
     */
    void notifyAnimals(Event event, AnimalTypes type);
}
