package tokens;

import java.util.ArrayList;
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
    
    public ArrayList<Integer> kmp(String text, String patron) {
        ArrayList <Integer> p =new   ArrayList <Integer>();
		int cont = 0;
		if (patron == null || patron.length() == 0) {
		
			p.add(0);
			cont++;
			
		}

		

		char[] chars = patron.toCharArray();

		int[] next = new int[patron.length() + 1];
		for (int i = 1; i < patron.length(); i++) {
			int j = next[i + 1];

			while (j > 0 && chars[j] != chars[i]) {
				j = next[j];
			}

			if (j > 0 || chars[j] == chars[i]) {
				next[i + 1] = j + 1;
			}
		}

		for (int i = 0, j = 0; i < text.length(); i++) {
			if (j < patron.length() && text.charAt(i) == patron.charAt(j)) {
				if (++j == patron.length()) {
					
					
					p.add(i-j+1);
					cont++;
				}
			} else if (j > 0) {
				j = next[j];
				i--;
			}
		}

		
		
		return p;

	}

    public LinkedList<Token> getTokens() {
        return tokens;
    }

}
