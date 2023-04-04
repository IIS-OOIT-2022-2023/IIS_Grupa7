package drawing;

import java.awt.Graphics;

import javax.swing.JPanel;

import geometry.*;

/*
	- Iscrtavanje elemenata korisnickog interfejsa se vrsi pomocu 
	metoda grafickog konteksta (Graphics)
	- Vizuelizacija onoga sto je iscrtano na grafickom kontekstu moguca je koriscenjem
	vizuelne komponente, kao sto je objekat klase JPanel 
*/

/*
	- paint metodu koristi Swing API kako bi na ekranu iscrtao komponentu ili kontejner
	- paint metodu nije moguce direktno pozvati, vec se poziva repaint(Graphics g)
	- super.paint() poziva nasledjenu metodu implementiranu u JPanel koja podesava sivu
	sivu boju pozadine panela
*/


public class DrawingPanel extends JPanel {

	private Shape[] shapes;
	
	public DrawingPanel() {
		shapes = new Shape[10];
		shapes[0] = new Point(80, 100);
		shapes[1] = new Line(new Point(200, 80), new Point(250, 180));
		shapes[2] = new Circle(new Point(50,50), 40);
		shapes[3] = new Rectangle(new Point(130,30), 40, 20);
		shapes[4] = new Donut(new Point(100, 150), 40, 20);
	}
	
	@Override
	public void paint(Graphics g) {
		
		/* 
		 - Shape kao apstraktna klasa sadrzi deklaraciju draw metode, 
		 pa kompajler dozvoljava poziv ove metode nad elementima niza koji je deklarisan 
		 kao niz tipa Shape (nije potrebno DOWNCAST-ovanje)
		 - na ovaj nacin postignuto je labavo sprezanje komponenti softvera (fleksibilnost koda
		 koja obezbedjuje da se novi korisnicki zahtevi lakse realizuju)
		*/
		
		/*NAPOMENA: provera da li je instanca tipa Donut
		mora da bude pre provere da li je instanca Circle
		*/
		
		for(int i=0; i<5; i++) {
			/*if(shapes[i] instanceof Point) {
				Point p = (Point)shapes[i];
				p.draw(g);
			}else if(shapes[i] instanceof Line) {
				Line l = (Line) shapes[i];
				l.draw(g);
			}else if(shapes[i] instanceof Rectangle) {
				Rectangle r = (Rectangle)shapes[i];
				r.draw(g);	
			}else if(shapes[i] instanceof Donut) {
				Donut d = (Donut) shapes[i];
				d.draw(g);
			}else if(shapes[i] instanceof Circle) {
				Circle c = (Circle)shapes[i];
				c.draw(g);
			}*/
			shapes[i].draw(g);
		}
		
		
		
		
	
		
	}
}
