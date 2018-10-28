import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LoadServices {
    public static List<HealthService> getHealthServices() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader fileReader = new FileReader("backend/src/main/resources/services.txt");
        JSONObject json = (JSONObject) parser.parse(fileReader);
        JSONArray services = (JSONArray) json.get("services");
        List<HealthService> hs = new ArrayList<>();
        for (Object service : services) {
//            parser.parse(service.toString());
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

            hs.add(new HealthService(name, locations, min, max, gender, tags, "dummyLink"));
        }
        return hs;
    }

    public static Set<String> getTags() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader fileReader = new FileReader("backend/src/main/resources/services.txt");
        JSONObject json = (JSONObject) parser.parse(fileReader);
        JSONArray services = (JSONArray) json.get("services");
        Set<String> tags = new HashSet<>();
        for (Object service : services) {
            JSONObject serviceInstance = (JSONObject) parser.parse(service.toString());
            for (Object tag : (JSONArray) serviceInstance.get("tags")) {
                tags.add(tag.toString());
            }

        }
        return tags;
    }

    public static String getResponse(String responeName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader fileReader = new FileReader("backend/src/main/resources/responses.txt");
        JSONObject json = (JSONObject) parser.parse(fileReader);
        JSONArray services = (JSONArray) json.get(responeName);
        Random rng = new Random();
        if(rng.nextBoolean())
            return services.get(0).toString();
        else
            return services.get(1).toString();
    }
}
