import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Token {
    LET_KEYWORD ("let"),
    IF_KEYWORD ("if"),
    WHILE_KEYWORD ("while"),
    ELSE_KEYWORD ("else"),

    SEMICOLON (";"),
    COMMA (","),

    OPEN_BRACKET ("\\{"),
    CLOSE_BRACKET ("\\}"),
    OPEN_PARENTHESIS ("\\("),
    CLOSE_PARENTHESIS ("\\)"),

    EQUAL ("=="),
    DIFFERENT ("<>"),
    GREATER_EQUAL (">="),
    LESSER_EQUAL ("<="),
    ATTRIBUTION ("="),
    GREATER (">"),
    LESSER ("<"),

    ADDITION ("\\+"),
    SUBTRACTION ("-"),
    MULTIPLICATION ("\\*"),
    DIVISION ("/"),
    MODULUS ("%"),

    STRING ("\"[^\"]+\""),
    NUMBER ("\\d+(\\.\\d+)?"),
    IDENTIFIER ("\\w+");    

    private final Pattern pattern;

    Token(String regex) {
        pattern = Pattern.compile("^" + regex);
    }

    int endOfMatch(String s) {
        Matcher m = pattern.matcher(s);

        if (m.find()) {
            return m.end();
        }

        return -1;
    }
}