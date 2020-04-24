package org.greenbook;

public class AdjacentDuplicateRemover {

    public static String removeAdjacentDuplicate(String input) {
        if (input == null || input.length() < 2) {
            return input;
        }
        String output = input;
        int i = 1;
        int mark = -1;
        do  {
            if ((i < output.length()) &&  output.charAt(i) == output.charAt(i - 1)) {
                if (mark == -1) {
                    mark = i - 1;
                }
                i++;
            } else if ((i == output.length()) || (output.charAt(i) != output.charAt(i - 1))) {
                if (mark != -1) {
                    output = head(output, mark) + tail(output, i);
                    i = mark == 0 ? 1 : mark;
                    mark = -1;
                } else {
                    i++;
                }
            }
        } while (i <= output.length());
        return output;
    }

    protected static  String head(String input, int end) {
        return input.substring(0, end);
    }

    protected static String tail(String input, int start) {
        return input.substring(start);
    }

}
