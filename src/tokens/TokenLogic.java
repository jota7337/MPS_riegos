package tokens;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenLogic {

    private LinkedList<TokenInf> tokenInfos;
    private LinkedList<Token> tokens;

    public TokenLogic() {
        super();
        tokenInfos = new LinkedList<TokenInf>();
        tokens = new LinkedList<Token>();
    }

    public void add(String regex, int token) {
        tokenInfos.add(new TokenInf(Pattern.compile("^(" + regex + ")"), token));
    }

    public void tokenize(String str) {
        String s = str.trim();
        int totalLength = s.length();
        tokens.clear();
        while (!s.equals("")) {
            System.out.println(s);
            int remaining = s.length();
            boolean match = false;
            for (TokenInf info : tokenInfos) {
                Matcher m = info.regex.matcher(s);
                if (m.find()) {
                    match = true;
                    String tok = m.group().trim();
                    s = m.replaceFirst("").trim();
                    
                    // Aquí filtramos los comentarios
                    if (info.token != Token.COMENTARIO) {  // Excluir comentarios
                        tokens.add(new Token(info.token, tok, totalLength - remaining));
                    }
                    
                    break;
                }
            }
            if (!match) {
                throw new LexicException("Unexpected character in input: " + s);
            }
        }
    }

    public LinkedList<Token> getTokens() {
        return tokens;
    }

}
