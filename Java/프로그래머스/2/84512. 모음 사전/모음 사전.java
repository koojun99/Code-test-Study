import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static char[] vowels = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        List<String> words = new ArrayList<>();
        generate("", words);
        return words.indexOf(word);
    }

    private void generate(String word, List<String> words) {
        words.add(word);
        if (word.length() == 5) {
            return;
        }

        for (char c : vowels) {
            generate(word + c, words);
        }
    }
}