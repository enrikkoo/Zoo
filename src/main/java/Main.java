import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class Main {
    public static Logger LOGGER;
    public static Zoo zoo;

    /**
     * This block initializes the logger for logging
     */
    static {
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("src/main/resources/log.properties"));
            LOGGER = Logger.getLogger(Main.class.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The main method creates a zoo object and an object to interact with the zoo,
     * then calls a recursive method that receives commands from the user
     */
    public static void main(String[] args) throws IOException {
        Main.LOGGER.log(Level.INFO, "The program is running");
        zoo = new Zoo();
        User_Tools ut = new User_Tools(zoo);
        JSON_Reader.parseJSON();
        System.out.println("Welcome to the zoo!");
        menu(ut);
    }

    /**
     * Recursive method that receives commands from the client
     * and calls the method depending on the client's choice
     */
    public static void menu(User_Tools ut) throws IOException {
        Zoo.info();
        System.out.println("Choose an event...(just enter a number)");
        System.out.println("1.Call the keeper to the herbivores");
        System.out.println("2.Call the keeper to the carnivores");
        System.out.println("3.Thunder");
        System.out.println("4.Morning");
        System.out.println("5.Night");
        System.out.println("6.Feed the herbivores");
        System.out.println("7.Feed the carnivores");
        System.out.println("");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        switch (a) {
            case "1":
                ut.visit(AnimalTypes.HERBIVORE);
                break;
            case "2":
                ut.visit(AnimalTypes.CARNIVORE);
                break;
            case "3":
                ut.setThunder();
                break;
            case "4":
                ut.setMorning();
                break;
            case "5":
                ut.setNight();
                break;
            case "6":
                ut.feed(AnimalTypes.HERBIVORE);
                break;
            case "7":
                ut.feed(AnimalTypes.CARNIVORE);
                break;
        }
        menu(ut);
    }
}
