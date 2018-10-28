import java.util.*;

public class ChatBot {
    private Person person;
    private List<HealthService> hsList;
    private int pointer;
    //    private List<State> states;
    private String reply;
    private Set<HealthService> relevantHS;
    private String name;
    private Set<String> keywords;

    public ChatBot(String name) {
        this.name = name;
        person = new Person();
        relevantHS = new HashSet<>();
        try {
            hsList = LoadServices.getHealthServices();
            keywords = LoadServices.getTags();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String s : keywords) {
            System.out.println(s);
        }
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
                String personName = input;
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
                for(String s: tokens){
                    loc = loc + s + " ";
                }
                person.setLocation(loc);
                pointer++;
                // terminal. point. display relevant things, maybe only 3 at a time possibly another case to show more queries
                break;
        }
        return buildReply();
    }

    private String buildReply() {

        return "";
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
        if (synonyms.contains("sad")) {
            System.out.println("u sad");
        }
        // tokenise
        //call synonym for all of themm.
        // cross check to key words
//call STEMMER
        ArrayList<String> tags = new ArrayList<>();
        return tags;
    }




    public static void main(String[] args) {
        new ChatBot("a");
    }
}
