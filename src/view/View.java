package view;

import javax.swing.JFrame;

import main.Controller;



public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Inicio inicio;
	private ImagenPrincipal img;
	private VistaArchivos mps;

	
	/**
	 * Se instancian los diferentes componentes para nustra interface
	 * y se les pasa un action listenr a nustros botones.
	 * @param c
	 */
	public View(Controller c) {
	
		img = new ImagenPrincipal();
		setSize(500, 400);
		setContentPane(img);
		setResizable(false);
		setVisible(true);
		setTitle("Taller ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		inicio = new Inicio(c);
		inicio.setSize(500, 400);
		getContentPane().add(inicio);

		mps = new VistaArchivos(c);
	
		
		mps.setSize(900, 750);
		getContentPane().add(mps);
		

		
		mps.getBsearchkmp().addActionListener(c);
	
		mps.getBvolver().addActionListener(c);
		mps.getBsubir().addActionListener(c);
		
	
		inicio.getBm().addActionListener(c);


		inicio.updateUI();
		mps.updateUI();
	}


	public VistaArchivos getAlg() {
		return mps;
	}

	public void setAlg(VistaArchivos alg) {
		this.mps = alg;
	}

	public Inicio getInicio() {
		return inicio;
	}

	public void setInicio(Inicio inicio) {
		this.inicio = inicio;
	}


}
