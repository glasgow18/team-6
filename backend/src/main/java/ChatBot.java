import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChatBot {
    private String name;
    private List<HealthService> hsList;
    private int pointer;
    private List<State> states;
    private String reply;
    private List<HealthService> relevantHS;
    public ChatBot(String name){
        this.name = name;
        relevantHS = new ArrayList<>();
        try {
            hsList = LoadServices.getHealthServices();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String poll(String input){
        switch(pointer){
            case 0:
                checkProblem(input);
                break;
            case 1:
//                checkName(input);
                break;
            case 2:
//                checkAge(input);
                break;
            case 3:
//                checkLoc();
                break;
        }
        return buildReply();
    }

    private String buildReply() {
        return "";
    }

    public void checkProblem(String input){
//        String s = checkSynonym(input);
//        if problem == crisis
//            checkCrisis(type);

    }

    public void checkCrisis(int type){
        String key;
        switch(type){
            case 0:
                key = "depression";
                break;
            case 1:
                key = "anxiety";
                break;
            case 2:
                key = "suicide";
                break;
        }
        for(HealthService hs: hsList){
//            for(Tag t: hs.getTags){
//                if(t.contains(key)){
//                    relevantHS.add(hs);
//                }
//            }
        }
    }
}
