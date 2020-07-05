import java.util.logging.Level;

public class Carnivore extends Animal {

    public Carnivore(Current_Status status, String animal_kind, int number) {
        this.status = status;
        this.animal_kind = animal_kind + number;
    }

    /**
     * When the keeper visits, the animal starts making noise
     */
    @Override
    public void keeperVisit() {
        setStatus(Current_Status.NOISE);
    }

    /**
     * When the animal is fed, it calms down
     */
    @Override
    public void feeding() {
        setStatus(Current_Status.CALM);
    }

    /**
     * If the animal does not make noise, it falls asleep,
     * otherwise there will be a warning and the animal will not fall asleep
     */
    @Override
    public void night() {
        if (getStatus() == Current_Status.NOISE) {
            Main.LOGGER.log(Level.WARNING, getAnimal_kind() + " is noisy and can't sleep");
        } else {
            setStatus(Current_Status.SLEEP);
            Main.LOGGER.log(Level.INFO, getAnimal_kind() + " is sleeping");
        }
    }

    /**
     * If the animal was asleep, it will wake up and have the status CALM
     * Otherwise there will be a warning with the previous status of the animal
     */
    @Override
    public void morning() {
        if (getStatus() == Current_Status.SLEEP) {
            setStatus(Current_Status.CALM);
        } else if (getStatus() == Current_Status.CALM) {
            Main.LOGGER.log(Level.WARNING, getAnimal_kind() + " didn't sleep because he was calm");
        } else Main.LOGGER.log(Level.WARNING, getAnimal_kind() + " didn't sleep because it's noisy");
    }

    /**
     * After the thunder, the animal begins to make noise
     */
    @Override
    public void thunder() {
        setStatus(Current_Status.NOISE);
    }
}
