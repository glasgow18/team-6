import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class ChatBot {
    private String name;
    private List<HealthService> hsList;
    private int pointer;
    private List<State> states;
    public ChatBot(String name){
        this.name = name;
        try {
            hsList = LoadServices.getHealthServices();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String poll(String input){
//        if()
        return "";
    }

}
