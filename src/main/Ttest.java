package main;

import gui.IDE;
import tokens.LexicException;
import tokens.Token;
import tokens.TokenLogic;

public class Ttest {

    public static void main(String[] args) {
    	TokenLogic tokenizer = new TokenLogic();        
        tokenizer.add("ClassRoom|Begin|End|ln|sqrt", Token.FUNCTION); // function
        tokenizer.add("\\(", Token.OPEN_BRACKET); // open bracket
        tokenizer.add("\\)", Token.CLOSE_BRACKET); // close bracket
        tokenizer.add("[+-]", Token.PLUSMINUS); // plus or minus
        tokenizer.add("[*/]", Token.MULTDIV); // mult or divide
        tokenizer.add("\\^", Token.RAISED); // raised
        tokenizer.add("[0-9]+", Token.NUMBER); // integer number
        tokenizer.add("[a-zA-Z][a-zA-Z0-9_]*", Token.VARIABLE); // variable
        
        tokenizer.add("%(.|\\n)*?%", Token.COMENTARIO); // comentario completo
        
     // Agregar palabras clave para entidades
//        tokenizer.add("PROYECTO\\[|ACTIVIDAD\\[|PERSONA\\[|RECURSO\\[", Token.FUNCTION); // ENTIDAD
//        
//        // Agregar identificadores y valores
//        tokenizer.add("[a-zA-Z_][a-zA-Z0-9_]*", Token.VARIABLE); // Identificadores
//        
//        // Agregar números, fechas y valores de texto
//        tokenizer.add("\\d+|\\d{1,2}/\\d{1,2}/\\d{4}|[a-zA-Z][a-zA-Z0-9_\\s]*", Token.NUMERO_FECHA_VALOR); // Números, fechas y valores
//        
//        // Agregar caracteres especiales
//        tokenizer.add("\\[|\\]|;|,|:", Token.CARACTER_ESPECIAL); // Caracteres especiales
//        
//        // Agregar comentarios
//        tokenizer.add("#.*", Token.COMENTARIO); // Comentarios

        try {
            tokenizer.tokenize("%hola mundo "
            		+ "yo estoy bien "
            		+ "pero si hago esto "
            		+ "1+1 y"
            		+ "luego esto%"
            		+ "monosusio");
            
            IDE ide = new IDE();
            
            System.out.println("\n=========TOKEN LIST==========\n");

            for (Token tok : tokenizer.getTokens()) {
                // Excluir comentarios
                if (tok.token != Token.COMENTARIO) {
                    System.out.println("[Token:" + tok.token + " Lexema:" + tok.lexeme + " Posicion:" + tok.pos + "]");
                }
            }
        } catch (LexicException e) {
            System.out.println(e.getMessage());
        }
        
    }

}
