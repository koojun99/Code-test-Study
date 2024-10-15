class Solution {
    public String solution (String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9\\-_.]", "");
        s = s.replaceAll("\\.+", ".");
        s = s.replaceAll("^\\.+|\\.+$", "");
        if (s.isEmpty()) s = "a";
        if (s.length() > 15) {
            s = s.substring(0, 15);
            s = s.replaceAll("\\.+$", "");
        }

        while (s.length() < 3) {
            s += s.charAt(s.length() - 1);
        }

        return s;
    }
}