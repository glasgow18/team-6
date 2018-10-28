import edu.stanford.nlp.simple.Sentence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Stemming {
   public static List<String> getStems(String sentence){
        Sentence s = new Sentence(sentence.toLowerCase());
        List<String> lemmas = s.lemmas();
        HashSet<String> stopWords = new HashSet<>();
        sentence = "";
        try (Stream<String> stream = Files.lines(Paths.get("backend/src/main/resources/stopwords.txt"))) {
            stream.forEach(stopWords::add);
            for (String lemma : lemmas) {
                if (!stopWords.contains(lemma))
                    sentence = sentence.concat(lemma + " ");
            }
        } catch (IOException ignored) {}


        return new Sentence(sentence).lemmas();
}

}
