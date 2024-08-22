package tokens;

public class Token {

	public static final int EPSILON = 0;
    public static final int PLUSMINUS = 1;
    public static final int MULTDIV = 2;
    public static final int RAISED = 3;
    public static final int FUNCTION = 4;
    public static final int OPEN_BRACKET = 5;
    public static final int CLOSE_BRACKET = 6;
    public static final int NUMBER = 7;
    public static final int VARIABLE = 8;
    public static final int COMENTARIO = 9;
    public static final int SALTO = 10;
    public static final int NUMERO_FECHA_VALOR = 10;
    public static final int OPEN_CORCHETE = 11;
    public static final int CLOSE_CORCHETE = 12;
    public static final int EQUALS = 13;
    public static final int EQUALS_HIGHER = 14; 
    public static final int EQUALS_LOWER = 15;
    
    
    public final int token;
    public final String lexeme;
    public final int pos;

    public Token(int token, String sequence, int pos) {
        super();
        this.token = token;
        this.lexeme = sequence;
        this.pos = pos;
    }
    
    public Token clone(){
        return new Token(this.token, this.lexeme, this.pos);
    }

}
