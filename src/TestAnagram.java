import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestAnagram {

    @Test
    public void empty_word_list_and_source_is_any_word_will_have_no_anagram() {
        Anagram generator = new Anagram(Arrays.asList());
        List<String> anagrams = generator.generate("anyword");
        assertThat(anagrams, equalTo(Arrays.asList()));
    }
}
