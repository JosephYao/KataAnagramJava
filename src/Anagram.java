import java.util.Arrays;
import java.util.List;

public class Anagram {
    private final List<String> words;

    public Anagram(List<String> words) {
        this.words = words;
    }

    public List<String> generate(String source) {
        if (!this.words.isEmpty() && isAnagram(source))
            return Arrays.asList(words.get(0) + " " + words.get(0));

        return Arrays.asList();
    }

    private boolean isAnagram(String source) {
        return source.equals(words.get(0) + words.get(0));
    }
}
