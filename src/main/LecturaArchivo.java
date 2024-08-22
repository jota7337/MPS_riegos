package main;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFileChooser;

public class LecturaArchivo {
	/**
	 * Se busca el archivo escogido y se lee el txt.
	 * @return
	 */
	public String Leer() {
		String texto="";
		JFileChooser jf=new JFileChooser();
		jf.showOpenDialog(null);
		try {
			BufferedReader bf = new BufferedReader(new FileReader(jf.getSelectedFile()));
			String temp="";
			String bfRead;
			while((bfRead = bf.readLine()) != null) {
				temp= temp+bfRead+"\n";
			}
			
			texto=temp;
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("no se encontro archivo");
		}
		return texto;
	}

}
