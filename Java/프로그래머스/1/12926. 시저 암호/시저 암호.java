class Solution {
    public String solution(String s, int n) {

	StringBuilder sb = new StringBuilder();
	for (char ch : s.toCharArray()) {
		char pushed = push(ch, n);
		sb.append(pushed);
	}

	String answer = sb.toString();
	return answer;
    }
    
    private char push(char ch, int n) {
	    if (!Character.isAlphabetic(ch)) return ch;
	
	    int start = Character.isUpperCase(ch) ? 'A' : 'a';
	    int current = ch - start;
	    int pushed = (current+n) % ('Z'-'A' + 1) + start;
	    return (char) pushed;
    }
}
