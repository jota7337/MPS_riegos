package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.Controller;



public class VistaArchivos extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField buscar;
	private JTextArea mostrar;
	private JTextArea mostrar2;
	private JScrollPane tokenlist;
	private JScrollPane archivo;
	private JButton btbuscarlt;
	private JButton bvolver;
	private JButton bsubir;
	private JLabel palabra;
	
	private static final String FUENTE = "Verdana";
	public static final String SUBIR = "Subir Codigo";
	public static final String VOLVER = "Volver";
	public static final String BUSCAR1 = "Buscar";


	public VistaArchivos(Controller c) {
		setVisible(false);
		setOpaque(false);
		setLayout(null);

	

		palabra = new JLabel("INGRESE PATRON");
		palabra.setFont(new Font(FUENTE, Font.BOLD, 13));
		palabra.setForeground(Color.white);
		palabra.setBounds(20, 20, 170, 20);

		btbuscarlt = new JButton(BUSCAR1);
		btbuscarlt.setFont(new Font(FUENTE, Font.BOLD, 13));
		btbuscarlt.setBounds(550, 20, 120, 20);

	

		buscar = new JTextField();
		buscar.setFont(new Font(FUENTE, Font.BOLD, 10));
		buscar.setBounds(160, 20, 350, 20);

		mostrar = new JTextArea();
		archivo = new JScrollPane(mostrar);
		archivo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		archivo.setBounds(20, 65, 320, 370);
		
		mostrar2 = new JTextArea();
		tokenlist = new JScrollPane(mostrar2);
		tokenlist.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		tokenlist.setBounds(360, 65, 320, 370);
		
		bvolver = new JButton(VOLVER);
		bvolver.setFont(new Font(FUENTE, Font.BOLD, 12));
		bvolver.setBounds(150, 440, 100, 20);
		
		bsubir = new JButton(SUBIR);
		bsubir.setFont(new Font(FUENTE, Font.BOLD, 12));
		bsubir.setBounds(300, 440, 130, 20);

		add(buscar);
		add(bvolver);
		add(archivo);
		add(tokenlist);
		add(btbuscarlt);
		add(bsubir);
		add(palabra);
	}
	public JButton getBvolver() {
		return bvolver;
	}

	public void setBvolver(JButton bvolver) {
		this.bvolver = bvolver;
	}

	public JLabel getIngresarkmp() {
		return palabra;
	}

	public void setIngresarkmp(JLabel ingresarkmp) {
		this.palabra = ingresarkmp;
	}

	public JButton getBsubir() {
		return bsubir;
	}

	public void setBsubir(JButton bsubir) {
		this.bsubir = bsubir;
	}

	public JTextArea getMostrar() {
		return mostrar;
	}

	public void setMostrar(JTextArea mostrar) {
		this.mostrar = mostrar;
	}

	public JTextField getBuscar() {
		return buscar;
	}

	public void setBuscar(JTextField buscar) {
		this.buscar = buscar;
	}



	public JButton getBsearchkmp() {
		return btbuscarlt;
	}

	public void setBsearchkmp(JButton bsearchkmp) {
		this.btbuscarlt = bsearchkmp;
	}
	public JTextArea getMostrar2() {
		return mostrar2;
	}
	public void setMostrar2(JTextArea mostrar2) {
		this.mostrar2 = mostrar2;
	}



}
