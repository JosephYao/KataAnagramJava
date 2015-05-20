import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Anagram {
    private final List<String> words;

    public Anagram(List<String> words) {
        this.words = words;
    }

    public List<String> generate(String source) {
        return words.stream()
                .filter(candidate -> isAnagram(source, candidate))
                .map(this::output)
                .collect(Collectors.toList());
    }

    private String output(String anagram) {
        return anagram + " " + anagram;
    }

    private boolean isAnagram(String source, String candidate) {
        int[] sortedSource = source.chars().sorted().toArray();
        int[] sortedAnagrams = (candidate + candidate).chars().sorted().toArray();

        return Arrays.equals(sortedSource, sortedAnagrams);
    }
}
