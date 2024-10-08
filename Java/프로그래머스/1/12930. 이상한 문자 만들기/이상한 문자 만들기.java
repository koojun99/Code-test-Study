class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        char[] chars = s.toCharArray();
        boolean isUpper = true;
        for (char ch : chars) {
	        if (!Character.isAlphabetic(ch)) {
			        sb.append(ch);
			        isUpper = true;
	        } else {
			    if (isUpper) {
				    sb.append(Character.toUpperCase(ch));
				    isUpper = false;
			    } else {
					sb.append(Character.toLowerCase(ch));
					isUpper = true;
				}
		    }
        }

        String answer = sb.toString();
        return answer;
    }
}