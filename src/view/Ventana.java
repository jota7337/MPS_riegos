package view;

import javax.swing.JOptionPane;

public class Ventana {
	/**
	 * metodo que nos ayuda a leer lo que el usuario ingresa.
	 * @param mensaje
	 * @return
	 */
		public int leerDato(String mensaje) {
			int respuesta=0;
			String instruccion=JOptionPane.showInputDialog(mensaje);
			respuesta=Integer.parseInt(instruccion);
			return respuesta;
		}
		/**
		 * metodo que nos ayuda a mostrar un dato al usuario.
		 * @param mensaje
		 */
		public void mostrarmensaje(String mensaje) {
			JOptionPane.showMessageDialog(null, mensaje);
		}
		/**
		 * metodo que nos ayuda a leer lo que el usuario ingresa.
		 * @param instruccion
		 * @return
		 */
		public String leerDato2(String instruccion) {
			String respuesta = "";
			respuesta = JOptionPane.showInputDialog(instruccion);
			return respuesta;
		}
}
