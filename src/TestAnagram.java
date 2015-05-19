import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;

public class TestAnagram {

    @Test
    public void empty_word_list_and_source_is_any_word_will_have_no_anagram() {
        assertThat(anagramsOf(Arrays.asList(), "anyword"), empty());
    }

    @Test
    public void one_character_word_list_and_source_is_double_of_this_character_will_have_one_anagram() {
        assertThat(anagramsOf(Arrays.asList("a"), "aa"), contains("a a"));
    }

    private List<String> anagramsOf(List<String> words, String source) {
        return new Anagram(words).generate(source);
    }
}
