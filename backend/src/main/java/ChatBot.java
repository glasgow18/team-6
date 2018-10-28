import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;

public class ChatBot {
    private Person person;
    private List<HealthService> hsList;
    private int pointer;
    //    private List<State> states;
    private String reply;
    private String name;
    private Set<String> keywords;

    public ChatBot(String name) {
        this.name = name;
        person = new Person();


        try {
            hsList = LoadServices.getHealthServices();
//            keywords = LoadServices.getTags();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        for (String s : keywords) {
//            System.out.println(s);
//        }
    }

    private class Person {
        String name;
        int age;
        String location;

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        List<String> tags;

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
        List<String> tokens = getTokenKeywords(input);
        switch (pointer) {
            case 0:
                person.setName(input);
                pointer++;
                break;
            case 1:

                if (tokens.size() > 0) {
                    person.setTags(tokens);
                    pointer++;
                }

                if (tokens.contains("suicide")) {   // move to check
                    pointer = 4;
                }

                break;
            case 2:
                //check crisis words
                // break down around ii'm, am, or just get the numbers
                int age=-1;
                for(String s: tokens){
                    StringBuilder sb = new StringBuilder();
                    boolean flag = false;
                    if (s != null && !s.isEmpty()) {
                        for (char c : s.toCharArray()) {
                            if (Character.isDigit(c)) {
                                sb.append(c);
                                flag = true;
                            } else if (flag) {
                                break;
                            }
                        }
                    }
                    if(flag){
                        age = Integer.valueOf(sb.toString());
                        break;
                    }
                }
                if(age >0 && age<1000){
                    person.setAge(age);
                    pointer++;
                }
                // else send same message again
                break;
            case 3:
                String loc = "";
//                System.out.println("tokens at 3: " + tokens);
                for(String s: tokens){
                    loc = loc + s;
                    if(tokens.size()>1){
                        loc= loc+" ";
                    }
                }
                System.out.println("loc at 3: " + loc);
                person.setLocation(input);
                System.out.println(person.getLocation());
                pointer++;
                // terminal. point. display relevant things, maybe only 3 at a time possibly another case to show more queries
                break;
        }
        return buildReply();
    }

    private String buildReply() {
        String response;
        if(pointer == 1){
            //problemFind
            try {
                response = LoadServices.getResponse("problemRequest");
                return response;
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

        }
        if(pointer == 2){
            //ageRequest
            try {
                response = LoadServices.getResponse("ageRequest");
                return response;
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
        if(pointer == 3){
            //locationRequest
            try {
                response = LoadServices.getResponse("locationRequest");
                return response;
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
        if(pointer == 4){

            Set<HealthService> healthServiceList = new HashSet<>();
            for (HealthService healthService : hsList) {
                if(person.getAge() < healthService.getMinAge() || person.getAge() > healthService.getMaxAge())
                    continue;
                if(!healthService.getLocations().contains(person.getLocation().toLowerCase()))
                    continue;
                for(String tags: person.getTags()){
                    if(healthService.getTags().contains(tags)){
                        healthServiceList.add(healthService);
                        break;
                    }
                }
            }

            String out = "";
            for(HealthService hs: healthServiceList)
                out = out.concat(hs.getServiceName() + "\n");


            System.out.println(healthServiceList);
            System.out.println(out);
            return out;
        }
        return "oops";
    }


//    public void                              checkProblem(String input) {
//        String         s = checkSynonym(input);
//        if prob                                                                                    lem == crisis
//            checkCrisis(type);

//    }

    private List<String> getTokenKeywords(String input) {
        List<String> stemmed = Stemming.getStems(input);
        ArrayList<String> synonyms = new ArrayList<>();
        for (String s : stemmed) {
            synonyms.addAll(Synonym.findSynonym(s));
        }

        // tokenise
        //call synonym for all of themm.
        // cross check to key words
//call STEMMER
        return synonyms;
    }




    public static void main(String[] args) {
        new ChatBot("a");
    }
}
