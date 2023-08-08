import java.util.ArrayList;
import java.util.List;

public class P17 {
    private static final char[] CHARS = "AEIOU".toCharArray();

    private List<String> generate1(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);

        if (word.length() == 5) return words;

        for (char c : CHARS) words.addAll(generate1(word + c));
        return words;
    }

    public int solution1(String word) {
        return generate1("").indexOf(word);
    }

    private void generate2(String word, List<String> words) {
        words.add(word);

        if (word.length() == 5) return;
        for (char c : CHARS) generate2(word + c, words);
    }

    public int solution2(String word) {
        List<String> words = new ArrayList<>();
        generate2("", words);
        return words.indexOf(word);
    }
}
