import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class LoadServices {

    public static void main(String[] args) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader fileReader = new FileReader("/src/main/resources/services.txt");
        JSONObject json = (JSONObject) parser.parse(fileReader);
        JSONArray services = (JSONArray) json.get("services");
        for (Object service : services) {
            JSONObject serviceInstance = (JSONObject) parser.parse(service.toString());
            String name = serviceInstance.get("service").toString(); //breakdown location
            HashSet<String> locations = new HashSet<>();

            for (Object location : (JSONArray) serviceInstance.get("location")) {
                locations.add(location.toString());
            }

            StringTokenizer st = new StringTokenizer(serviceInstance.get("age").toString(), "-");
            int min = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());

            HashSet<String> tags = new HashSet<>();
            for (Object tag : (JSONArray) serviceInstance.get("tags")) {
                tags.add(tag.toString());
            }

            String gender = serviceInstance.get("gender").toString();


            new HealthService(name, locations, min, max, gender, tags, "dummyLink");
        }
    }
}
