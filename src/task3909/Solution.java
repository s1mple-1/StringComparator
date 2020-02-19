package task3909;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("am", "mak"));
        System.out.println(isOneEditAway("aline", "line"));
        System.out.println(isOneEditAway("line", "liene"));
        System.out.println(isOneEditAway("line", "linse"));
        System.out.println(isOneEditAway("line", "linsess"));
        System.out.println(isOneEditAway("01", "102"));
        System.out.println(isOneEditAway("1032", "102"));
        System.out.println(isOneEditAway("123", "1023"));
    }

    public static boolean isOneEditAway(String first, String second) {
        if (first == null || second == null) return false;
        if (first.length() == second.length()) {
            return comparatorForEqualLengthStrings(first, second);
        }
        if (first.length()-second.length() == 1) {
            return comparatorForNonEqualLengthStrings(first, second);
        } else if (second.length()-first.length() == 1) { return comparatorForNonEqualLengthStrings(second, first);}
        return false;
    }


    public static boolean comparatorForEqualLengthStrings(String first, String second) {
        int count = 0;
        for (int i = 0; i < first.length(); i++) {
            if (second.charAt(i) != first.charAt(i)) {
                count++;
            }
        }
        return count < 2;
    }

    public static boolean comparatorForNonEqualLengthStrings(String first, String second) {
        StringBuilder sb = new StringBuilder(second);
        for (int i = 0; i < second.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                sb.insert(i, " ");
                return comparatorForEqualLengthStrings(first, sb.toString());
            }
        }
        if (second.equals(sb.toString())) sb.append(" ");
        return comparatorForEqualLengthStrings(first, sb.toString());
    }
}
