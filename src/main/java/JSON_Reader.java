import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;

public class JSON_Reader {
    /**
     * This method processes data from JSON
     * Adds to the list of animal-observers using the method defined in the observer, which provides this opportunity
     */
    public static void parseJSON() {
        final String filepath = "src/main/resources/AnimalsJSON";
        try {
            int count;
            Main.LOGGER.log(Level.INFO, "Parsing JSON");
            FileReader reader = new FileReader(filepath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonobject = (JSONObject) jsonParser.parse(reader);

            JSONArray carnivore_JSON_array = (JSONArray) jsonobject.get("carnivoreAnimals");
            Iterator i = carnivore_JSON_array.iterator();
            while (i.hasNext()) {
                JSONObject carnivore_JSON_object = (JSONObject) i.next();
                count = (int) (long) carnivore_JSON_object.get("count");
                for (int j = 1; j < count + 1; j++) {
                    Main.zoo.addAnimal(new Carnivore(Current_Status.CALM, (String) carnivore_JSON_object.get("kind"), j));
                }
            }
            JSONArray herbivore_JSON_array = (JSONArray) jsonobject.get("herbivoreAnimals");
            Iterator j = herbivore_JSON_array.iterator();
            while (j.hasNext()) {
                JSONObject herbivore_JSON_object = (JSONObject) j.next();
                count = (int) (long) herbivore_JSON_object.get("count");
                for (int x = 1; x < count; x++) {
                    Main.zoo.addAnimal(new Herbivore(Current_Status.CALM, (String) herbivore_JSON_object.get("kind"), x));
                }
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
