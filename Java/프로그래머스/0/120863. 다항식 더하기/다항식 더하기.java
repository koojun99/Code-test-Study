class Solution {
    public String solution(String polynomial) {
        String[] factors = polynomial.split(" ");
        StringBuilder sb = new StringBuilder();
        int coefficient = 0;  // x의 계수
        int constant = 0;     // 상수
        for (String factor : factors) {
            if (factor.contains("x")) {
                // 'x' 앞의 숫자가 없는 경우는 1로 간주 (ex: "x" -> 1x)
                String coefPart = factor.replace("x", "");
                if (coefPart.equals("")) {
                    coefficient += 1;  // "x"는 1x로 간주
                } else if (coefPart.equals("-")) {
                    coefficient -= 1;  // "-x"는 -1x로 간주
                } else {
                    coefficient += Integer.parseInt(coefPart);  // 숫자 부분 파싱
                }
            }
            else if (!factor.equals("+")) {
                constant += Integer.parseInt(factor);
            }
        }
        if (coefficient != 0) {
            if (coefficient == 1) {
                sb.append("x");
            } else if (coefficient == -1) {
                sb.append("-x");
            } else {
                sb.append(coefficient).append("x");
            }
        }

        if (constant != 0) {
            if (sb.length() > 0) {
                sb.append(" + ");
            }
            sb.append(constant);
        }

        String answer = sb.toString();
        return answer;
    }
}