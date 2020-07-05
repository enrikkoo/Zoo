/**
 * Interface that all animal observers must match and that must implement the update method
 */
public interface Observer {
    /**
     * Using this method, the observer receives notifications from the observable
     *
     * @param event - an event that happened at the zoo
     */
    void update(Event event);
}
