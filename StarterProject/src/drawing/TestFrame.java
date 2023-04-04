package drawing;

import javax.swing.JFrame;

public class TestFrame {
	
	/*
	 * Swing API klase obezbedjuju kreiranje grafickog korisnickog interfejsa aplikacije
	 * 
	 * Dele se na tri grupe: 
	 * 1. kontejneri najviseg nivao (npr. JFrame),
	 * 2. medjukontejneri (npr. JPanel) i
	 * 3. komponente (npr. JTextField, JButton, JLabel)s 
	 * 
	 * JFrame klasa obezbedjuje osnovne funkcionalnosti prozora
	 * JPanel je kontejner koji predstavlja praznu povrsinu na koju mogu da se dodaju 
	 * komponente (JLabel, JTextField, JButton)
	 * JPanel moze da posluzi za crtanje grafike
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		DrawingPanel panel = new DrawingPanel();
		frame.getContentPane().add(panel);
		frame.setBounds(100, 100, 450, 300);
		frame.setVisible(true);
	}

}
