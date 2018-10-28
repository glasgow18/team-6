import datamuse.DatamuseQuery;
import datamuse.JSONParse;
import edu.stanford.nlp.simple.Sentence;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Synonym {
    public static ArrayList<String> findSynonym(String keyword){
        String jparser =  new DatamuseQuery().findSimilar(keyword);
        String[] synonyms = new JSONParse().parseWords(jparser);
        System.out.println(Arrays.toString(synonyms));
        String sentenceString = "";
        if (synonyms.length > 0) {
            for (String synonym : synonyms) {
                sentenceString = sentenceString.concat(synonym + " ");
            }
        }
        Sentence sentence = new Sentence(sentenceString);
        ArrayList<String> keywords = new ArrayList<>(sentence.lemmas());
        keywords.add(keyword);
        System.out.println("keywords:" + keywords);
        return keywords;

    }

}
