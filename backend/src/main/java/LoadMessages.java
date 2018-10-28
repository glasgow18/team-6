import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class LoadMessages {
    public Set<String> getMessages(String param) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader fileReader = new FileReader("backend/src/main/resources/responses.txt");
        JSONObject json = (JSONObject) parser.parse(fileReader);
        JSONArray messages = (JSONArray) json.get(param);
        Set<String> messagesSet = new HashSet<>();
        for (Object g : messages) {
            messagesSet.add(g.toString());
        }
        return messagesSet;
    }

    public static void main(String[] args) throws IOException, ParseException {
        LoadMessages lm = new LoadMessages();
        for (String s : lm.getMessages("getName")) {
            System.out.println(s);
        }
        for (String s : lm.getMessages("getAge")) {
            System.out.println(s);
        }
        for (String s : lm.getMessages("getLocation")) {
            System.out.println(s);
        }
        for (String s : lm.getMessages("getProblem")) {
            System.out.println(s);
        }
        for (String s : lm.getMessages("noProblem")) {
            System.out.println(s);
        }
        for (String s : lm.getMessages("foundProblem")) {
            System.out.println(s);
        }
        for (String s : lm.getMessages("")) {
            System.out.println(s);
        }
    }

}
