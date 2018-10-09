import java.util.HashMap;
import java.util.Map;

public class PrefixToInfix 
{

	static final Map<String, Integer> PREC = new HashMap<>();
	static { PREC.put("+", 1); PREC.put("-", 1); PREC.put("*", 2); PREC.put("/", 2); }

    public class Source 
    {
        final String s;
        Source(String s) { this.s = s; }
        int index = 0;
        String token;
        String next() { return token = index >= s.length() ? null : s.substring(index, ++index); }
    }

    public String convert(String s) { return convert(new Source(s), 0); }

    public String convert(Source t, int prec) 
    {
        Integer self = PREC.get(t.next());
        if (self != null) {
            String op = t.token;
            String result = String.format("%s%s%s",convert(t, self), op, convert(t, self));
            if (self < prec) result = result;
            return result;
        } else
            return t.token;
    }
}