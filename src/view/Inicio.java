package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Controller;



public class Inicio extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btCultivo;
	private JLabel titulo;
	private JLabel integrantes;
	public static final String FUENTE = "Verdana";
	public static final String ALKMP = "Iniciar Cultivo";


	public Inicio(Controller c) {
		setVisible(true);
		setOpaque(false);
		setLayout(null);

		titulo = new JLabel("<html>Lenguaje de dominio publico para cultivos</html>");
		titulo.setFont(new Font(FUENTE, Font.BOLD, 35));
		titulo.setForeground(Color.ORANGE);
		titulo.setBounds(20, 10, 500, 100);
		add(titulo);

		integrantes = new JLabel(
				"<html><h1>Integrantes</h1>Jorge Yate <br>Sergio  Sanabria </html>");
		integrantes.setFont(new Font(FUENTE, Font.BOLD, 17));
		integrantes.setForeground(Color.white);
		integrantes.setBounds(20, 200, 500, 150);
		add(integrantes);

		btCultivo = new JButton(ALKMP);
		btCultivo.setOpaque(false);
		btCultivo.setBounds(135, 170, 230, 20);
		btCultivo.setFont(new Font(FUENTE, Font.ITALIC, 14));
		add(btCultivo);


	}

	public JButton getBm() {
		return btCultivo;
	}

	public void setBm(JButton bm) {
		this.btCultivo = bm;
	}



}
