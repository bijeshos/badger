package io.github.bijeshos.jackal.common;

public class StringUtils {
    private static final String COMMENT_PREFIX = "#";
    private static final String BACK_SLASH = "\\";
    private static final String FORWARD_SLASH = "/";

    public static String replaceBackSlashWithForwardSlash(String input) {
        return input.trim()
                    .replace(BACK_SLASH, FORWARD_SLASH);
    }

    public static boolean isNotComment(String input) {
        if (isNonNull(input) && !input.trim()
                                      .startsWith(COMMENT_PREFIX)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNonNull(String input) {
        if (input != null && input.trim()
                                  .length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNull(String input) {
        return !isNonNull(input);
    }
}
