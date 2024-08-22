package tokens;

import java.util.regex.Pattern;

public class TokenInf {

    public final Pattern regex;
    public final int token;

    public TokenInf(Pattern regex, int token) {
        super();
        this.regex = regex;
        this.token = token;
    }
}