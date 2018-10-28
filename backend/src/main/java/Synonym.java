import datamuse.DatamuseQuery;
import datamuse.JSONParse;
import edu.stanford.nlp.simple.Sentence;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class Synonym {

    private static String streamToString(InputStream inputStream) {
        String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
        return text;
    }
    public static void main(String args[]){
        String jparser =  new DatamuseQuery().findSimilar("crying");
        String[] synonyms = new JSONParse().parseWords(jparser);
        System.out.println(Arrays.toString(synonyms));
        String sentenceString = "";
        for (String synonym : synonyms) {
            sentenceString = sentenceString.concat(synonym + " ");
        }
        Sentence sentence = new Sentence(sentenceString);
        System.out.println(sentence.lemmas());

    }

}
