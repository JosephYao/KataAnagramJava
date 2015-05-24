import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagram {
    private final List<String> words;

    public Anagram(List<String> words) {
        this.words = words;
    }

    public List<String> generate(String source) {
        return words.stream()
                .flatMap(this::candidates)
                .filter(candidates -> isAnagram(source, candidates))
                .map(this::output)
                .collect(Collectors.toList());
    }

    private Stream<List<String>> candidates(String candidate) {
        List<String> anotherCandidateToBePaired = words.subList(words.indexOf(candidate), words.size());

        return anotherCandidateToBePaired.stream()
                .map(another -> pair(candidate, another));
    }

    private List<String> pair(String candidate, String another) {
        return Arrays.asList(candidate, another);
    }

    private String output(List<String> anagrams) {
        return String.join(" ", anagrams);
    }

    private boolean isAnagram(String source, List<String> candidates) {
        int[] sortedSource = source.chars().sorted().toArray();
        int[] sortedAnagrams = (String.join("", candidates)).chars().sorted().toArray();

        return Arrays.equals(sortedSource, sortedAnagrams);
    }
}
