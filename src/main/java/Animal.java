/**
 * This abstract class implements methods of the zoo,which animals react
 * Also implements the observer interface method
 * From this class the class of herbivores and carnivores is further inherited
 */
public abstract class Animal implements Zoo_Events, Observer {

    public Current_Status getStatus() {
        return status;
    }

    public void setStatus(Current_Status status) {
        this.status = status;
    }

    public String getAnimal_kind() {
        return animal_kind;
    }

    public Animal() {
    }

    /**
     * Each animal has its own status and kind
     */
    protected Current_Status status;
    protected String animal_kind;

    /**
     * Depending on the event that occurred, the appropriate method is called
     *
     * @param event - an event that happened at the zoo
     */
    @Override
    public void update(Event event) {
        switch (event) {
            case MORNING:
                morning();
                break;
            case KEEPER_COME:
                keeperVisit();
                break;
            case FEEDING:
                feeding();
                break;
            case NIGHT:
                night();
                break;
            case THUNDER:
                thunder();
                break;
            default:
                System.out.println("Unknown event");
        }
    }

    @Override
    public String toString() {
        return animal_kind + " with " + status + " status";
    }

}
