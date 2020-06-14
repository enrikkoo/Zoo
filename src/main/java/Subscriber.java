/**
 *  Interface that all animal subscribers must match and that must implement the update method
 */
public interface Subscriber {
    /**
     * Using this method, the subscriber receives notifications from the observer
     * @param event - an event that happened at the zoo
     */
    void update(Event event);
}
