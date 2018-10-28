import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

enum ServiceTags {
    ANXIETY, DEPRESSION, CONNECT, DISCOVER,
    COUNSELLING, GROUPCOUNSELLING, TRAUMA, SUICIDE
}

public class ChatBot {
    private Person person;
    private List<HealthService> hsList;
    private int pointer;
    //    private List<State> states;
    private String reply;
    private List<HealthService> relevantHS;
    private String name;

    public ChatBot(String name) {
        this.name = name;
        person = new Person();
        relevantHS = new ArrayList<>();
        try {
            hsList = LoadServices.getHealthServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class Person {
        String name;
        int age;
        String location;

        public List<ServiceTags> getTags() {
            return tags;
        }

        public void setTags(List<ServiceTags> tags) {
            this.tags = tags;
        }

        List<ServiceTags> tags;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
//            this.age = age;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

    }

    // Parse through the intent of the message by breaking down keywords
    public String poll(String input) {
        switch (pointer) {
            case 0:
                // break down around words like is, called, i'm, am
                // check crisis words
                String personName = input; //(currently nont broken)
                person.setName(input);
                // increment pointer
                break;
            case 1:
                //check crisis words
                // call
                // break down into tokens, synonym every one, check if they havve synoynms of target word
                List<ServiceTags> tokens = getTokenKeywords(input);
                if (tokens.size() > 0) {
                    pointer++;
                }

                if (tokens.contains(ServiceTags.SUICIDE)) {
                    //call crisis
                }
//                checkProblem(input);

                break;
            case 2:
                //check crisis words
                // break down around ii'm, am, or just get the numbers
                person.setAge(0);
                // if age is under 16 refer and terminal, else retun to case 1
                //increment pointer
                break;
            case 3:
                //check crisis words
                // search for words
                person.setLocation(input);
                // terminal. point. display relevant things, maybe only 3 at a time possibly another case to show more queries
                break;

        }
        pointer++;
        return buildReply();
    }

    private String buildReply() {

        return "";
    }


    public void checkProblem(String input) {
//        String s = checkSynonym(input);
//        if problem == crisis
//            checkCrisis(type);

    }

    private List<ServiceTags> getTokenKeywords(String input) {

        // tokenise
        //call synonym for all of themm.
        // cross check to key words
//call STEMMER
        ArrayList<ServiceTags> tags = new ArrayList<>();
        return tags;
    }


    public void crisis() {
        //
    }

}
