import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        
        Queue<Word> queue = new LinkedList<>();
        queue.offer(new Word(begin, 0));
        
        boolean[] visited = new boolean[words.length];
        
        while(!queue.isEmpty()) {
            Word current = queue.poll();
            
            if (current.word.equals(target)) {
                return current.step;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isValid(current.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Word(words[i], current.step + 1));
                }
            }
        }
        return 0;
    }
    
    private boolean isValid(String current, String word) {
        int diff = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != word.charAt(i)) {
                diff += 1;
            }
        }
        
        return diff == 1;
    }
    
    class Word {
        String word;
        int step;
        
        Word(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
    
}