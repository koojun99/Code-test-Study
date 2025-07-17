import java.util.*;

class Solution {
    static class FileData {
        String head;
        int number;
        String original;

        FileData(String head, int number, String original) {
            this.head = head;
            this.number = number;
            this.original = original;
        }
    }
    public String[] solution(String[] files) {
        List<FileData> list = new ArrayList<>();

        for (String file : files) {
            int i = 0;
            while (i < file.length() && !Character.isDigit(file.charAt(i))) {
                i++;
            }
            int j = i;
            while (j < file.length() && Character.isDigit(file.charAt(j))) {
                j++;
            }

            String head = file.substring(0, i);
            int number = Integer.parseInt(file.substring(i, j));
            list.add(new FileData(head, number, file));
        }
        
        list.sort((a, b) -> {
            int cmp = a.head.toLowerCase().compareTo(b.head.toLowerCase());
            if (cmp != 0) return cmp;
            return a.number - b.number;
        });
        
        
        String[] answer = new String[files.length];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).original;
        }
        
        
        return answer;
    }
}