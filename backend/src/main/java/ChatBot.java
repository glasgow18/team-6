import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChatBot {
    private Person person;
    private String name;
    private List<HealthService> hsList;
    private int pointer;
    private List<State> states;
    private String reply;
    private List<HealthService> relevantHS;

    public ChatBot(String name){
        this.name = name;
        person = new Person();
        relevantHS = new ArrayList<>();
        try {
            hsList = LoadServices.getHealthServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private class Person{
        String name;
        int age;
        String location;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(String input) {
            this.age = getIntFromString(input);
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

    }
    public String poll(String input){
        switch(pointer){
            case 0:
                person.setName(input);
                break;
            case 1:
                checkProblem(input);
                break;
            case 2:
                person.setAge(input);
                break;
            case 3:
                person.setLocation(input);
                break;
        }
        pointer++;
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
            case 1:
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
