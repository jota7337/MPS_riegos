package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import tokens.LexicException;
import tokens.Token;
import tokens.TokenLogic;
import view.Ventana;
import view.View;





public class Controller implements ActionListener {
	
    private TokenLogic  TokenLog;
	private View gui;
	private Ventana v;
	private LecturaArchivo leer;
	private String buscar = "";

	public Controller() {
		TokenLog = new TokenLogic(); 
		gui = new View(this);
		gui.setVisible(true);
		leer = new LecturaArchivo();
		v = new Ventana();


	}
	public void buscarpalabraBM(JTextArea area1, String patron,boolean estado) {
		
		ArrayList<Integer> p2 =new 	ArrayList<Integer>();
		p2 = TokenLog.kmp(area1.getText(), patron);
		if (estado==false) 
		 p2 = TokenLog.kmp(area1.getText().toUpperCase(), patron.toUpperCase());
		
		if (patron.length() >= 1) {
			DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(
					Color.GREEN);
			Highlighter h = area1.getHighlighter();
			h.removeAllHighlights();
			String text = area1.getText();
			String caracteres = patron;
			Pattern p = Pattern.compile("(?i)" + caracteres);
		
			for (int i = 0; i < p2.size(); i++) {
				try {
					h.addHighlight(p2.get(i), p2.get(i) + patron.length(), highlightPainter);
				
				} catch (BadLocationException e) {

					e.printStackTrace();
				}
			}
		
		
		}
	}
	public String  lexico(String codigo) {
		String lexico="";

		
		
		TokenLog.add("Precipitación|Días_Desde_Siembra", Token.FUNCTION); // function
//    	|Humedad_Ambiental|Cantidad_Adicional|Cantidad_Reducida|Umbral_Bajo|Umbral_Alto"
//		+ "|Etapa_Crecimiento_Óptima|Umbral_Humedad|Días_Entre_Riegos|Estado_Plantas|Tipo_Fertilizante_1|Tipo_Fertilizante_2"
//		+ "|Plagas_Observadas|Umbral_Plagas|Tipo_Tratamiento|Tamaño_Fruto|Tamaño_Óptimo|Tiempo_Entre_Aportes|pH_Suelo|pH_Minimo"
//		+ "|pH_Maximo|Solución_Acido|Solución_Alcalina|Días_Para_Cosecha|Días_Entre_Controles|
        
    	TokenLog.add("\\(", Token.OPEN_BRACKET); // open bracket
    	TokenLog.add("\\)", Token.CLOSE_BRACKET); // close bracket
        
    	TokenLog.add("\\{", Token.OPEN_CORCHETE); // open bracket
    	TokenLog.add("\\}", Token.CLOSE_CORCHETE); // close bracket
        
    	TokenLog.add("[+-=]", Token.PLUSMINUS); // plus or minus
    	TokenLog.add("[*/]", Token.MULTDIV); // mult or divide
    	TokenLog.add("[:;]", Token.DUBLE_DOT);
    	TokenLog.add("[<>]", Token.RAISED); // mayor o menor
        
    	TokenLog.add("==", Token.EQUALS); // IGUALES
        
    	TokenLog.add("<=", Token.EQUALS_HIGHER); // IGUALES
    	TokenLog.add(">=", Token.EQUALS_LOWER); // IGUALES
        
    	TokenLog.add("[0-9]+", Token.NUMBER); // integer number
        
    	TokenLog.add("[a-zA-Z][a-zA-Z0-9_]*", Token.VARIABLE); // variable
        
    	TokenLog.add("#(.|\\n)*?#", Token.COMENTARIO); // comentario completo    

    	TokenLog.add("&(.|\n)*?&", Token.STRING);// Strings
        try {
        	System.out.println(codigo);
        	TokenLog.tokenize(codigo);
            
         
            
            System.out.println("\n=========TOKEN LIST==========\n");
         

            for (Token tok : TokenLog.getTokens()) {
                // Excluir comentarios
                if (tok.token != Token.COMENTARIO) {
                	lexico+="[Token:" + tok.token + " Lexema:" + tok.lexeme + " Posicion:" + tok.pos + "]\n";
             
                }
            }
          
        } catch (LexicException e) {
        	lexico = "Codigo de cultivo invalido ";
            System.out.println(e.getMessage());
        }
        
		return lexico;
		
	}


	public void actionPerformed(ActionEvent e) {
	
		if (e.getActionCommand().equals(gui.getInicio().ALKMP)) {
			gui.getAlg().setVisible(true);
			gui.getInicio().setVisible(false);
			gui.setSize(700, 500);

		}

	

		if (e.getActionCommand() == gui.getAlg().VOLVER) {

			gui.getAlg().setVisible(false);
			gui.getInicio().setVisible(true);

			gui.setSize(500, 400);
			
			gui.getAlg().getMostrar().selectAll();
			gui.getAlg().getMostrar().replaceSelection("");
			gui.getAlg().getMostrar2().selectAll();
			gui.getAlg().getMostrar2().replaceSelection("");
			gui.getAlg().getBuscar().setText("");
			
		}

		if (e.getActionCommand() == gui.getAlg().SUBIR) {
          
			if (!gui.getAlg().getMostrar().getText().isEmpty()) {

				v.mostrarmensaje("Ya subiste el archivo");
			} else {
				gui.getAlg().getMostrar().append(leer.Leer());
				
				gui.getAlg().getMostrar2().append(lexico(gui.getAlg().getMostrar().getText()));
				
			
				

			}
		}
		if (e.getActionCommand() == gui.getAlg().BUSCAR1) {
			if (gui.getAlg().getMostrar().getText().isEmpty() 
					|| gui.getAlg().getBuscar().getText().isEmpty()) {
				v.mostrarmensaje("Debes subir el archivo o poner un patron");
			} else {
				buscarpalabraBM(gui.getAlg().getMostrar(), gui.getAlg().getBuscar().getText(),true);
				
				buscarpalabraBM(gui.getAlg().getMostrar2(), gui.getAlg().getBuscar().getText(),true);
			}

		}
	

		
	}

}
