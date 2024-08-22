package main;


import tokens.LexicException;
import tokens.Token;
import tokens.TokenLogic;


public class Ttest {

    public static void main(String[] args) {
    	//TokenLogic TokenLog = new TokenLogic(); 
    	Controller c=new Controller();
    	//TokenLog.add("Precipitación|Días_Desde_Siembra", Token.FUNCTION); // function
//    	|Humedad_Ambiental|Cantidad_Adicional|Cantidad_Reducida|Umbral_Bajo|Umbral_Alto"
//		+ "|Etapa_Crecimiento_Óptima|Umbral_Humedad|Días_Entre_Riegos|Estado_Plantas|Tipo_Fertilizante_1|Tipo_Fertilizante_2"
//		+ "|Plagas_Observadas|Umbral_Plagas|Tipo_Tratamiento|Tamaño_Fruto|Tamaño_Óptimo|Tiempo_Entre_Aportes|pH_Suelo|pH_Minimo"
//		+ "|pH_Maximo|Solución_Acido|Solución_Alcalina|Días_Para_Cosecha|Días_Entre_Controles|
        
//    	TokenLog.add("\\(", Token.OPEN_BRACKET); // open bracket
//    	TokenLog.add("\\)", Token.CLOSE_BRACKET); // close bracket
//        
//    	TokenLog.add("\\{", Token.OPEN_CORCHETE); // open bracket
//    	TokenLog.add("\\}", Token.CLOSE_CORCHETE); // close bracket
//        
//    	TokenLog.add("[+-=]", Token.PLUSMINUS); // plus or minus
//    	TokenLog.add("[*/:;]", Token.MULTDIV); // mult or divide
//        
//    	TokenLog.add("[<>]", Token.RAISED); // mayor o menor
//        
//    	TokenLog.add("==", Token.EQUALS); // IGUALES
//        
//    	TokenLog.add("<=", Token.EQUALS_HIGHER); // IGUALES
//    	TokenLog.add(">=", Token.EQUALS_LOWER); // IGUALES
//        
//    	TokenLog.add("[0-9]+", Token.NUMBER); // integer number
//        
//    	TokenLog.add("[a-zA-Z][a-zA-Z0-9_]*", Token.VARIABLE); // variable
//        
//    	TokenLog.add("#(.|\\n)*?#", Token.COMENTARIO); // comentario completo    
//
//        try {
//        	TokenLog.tokenize("#Control de Riego# "
//        			+ "Proyecto: Gestion_de_Riego_para_Cultivos2\r\n"
//        			+ "Autor: Nombre_del_Autor \r\n"
//        			+ "\r\n"
//        			+ "Analisis:\r\n"
//        			+ "    Solicite Precipitacian\r\n"
//        			+ "    Solicite Dias_Desde_Siembra\r\n"
//        			+ "    Solicite Humedad_Ambiental\r\n"
//        			+ "    Asigne 0 a Cantidad_Adicional\r\n"
//        			+ "    Asigne 0 a Cantidad_Reducida\r\n"
//        			+ "\r\n"
//        			+ "Operacion:\r\n"
//        			+ "    Si Precipitacion < Umbral_Bajo Entonces:\r\n"
//        			+ "        Ajustar_Riego(Cantidad_Adicional)\r\n"
//        			+ "    Si Precipitación > Umbral_Alto Entonces:\r\n"
//        			+ "        Ajustar_Riego(Cantidad_Reducida)\r\n"
//        			+ "\r\n"
//        			+ "    Mientras Dias_Desde_Siembra < Etapa_Crecimiento_optima Hacer:\r\n"
//        			+ "        Si Humedad_Ambiental < Umbral_Humedad Entonces:\r\n"
//        			+ "            Riego(Cantidad_Adicional)\r\n"
//        			+ "        Esperar(Dias_Entre_Riegos)\r\n"
//        			+ "");
//            
//         
//            
//            System.out.println("\n=========TOKEN LIST==========\n");
//            String letra = "";
//
//            for (Token tok : TokenLog.getTokens()) {
//                // Excluir comentarios
//                if (tok.token != Token.COMENTARIO) {
//                	//letra+="[Token:" + tok.token + " Lexema:" + tok.lexeme + " Posicion:" + tok.pos + "]\n";
//             
//                }
//            }
//           System.out.println(letra);
//        } catch (LexicException e) {
//            System.out.println(e.getMessage());
//        }
//        
    }

}
