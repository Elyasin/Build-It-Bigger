package gradle.shaladi.de.jokelib;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class JokeTeller {

    private static final String TAG = JokeTeller.class.getSimpleName();

    public String tellJoke() {

        StringBuilder jsonString = new StringBuilder();

        try {
            URL url = new URL("http://api.icndb.com/jokes/random");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(jsonString.toString());
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        JsonElement type = jsonObject.get("type");
        if (!type.getAsString().equals("success")) {
            return "Yo momma is no success, Json.";
        }

        jsonElement = jsonObject.get("value");
        JsonObject value = jsonElement.getAsJsonObject();
        JsonElement joke = value.get("joke");

        return joke.getAsString();

    }
}
