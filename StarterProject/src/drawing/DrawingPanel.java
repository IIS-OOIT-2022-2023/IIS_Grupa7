package drawing;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

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

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public DrawingPanel() {
		shapes.add(new Point(80, 100));
		shapes.add(new Line(new Point(200, 80), new Point(250, 180)));
		shapes.add(new Circle(new Point(50,50), 40));
		shapes.add(new Rectangle(new Point(130,30), 40, 20));
		shapes.add(new Donut(new Point(100, 150), 40, 20));
		
		//VEZBE 8 Zadatak 1
		Iterator<Shape> it=shapes.iterator();
		while(it.hasNext()) {
			it.next().moveBy(10, 0);
		}
		

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
		
		/*Shape[] shapes = new Shapes[5];
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
			}
			shapes[i].draw(g);
		}*/
		
		//VEZBE 8 Zadatak 2
		/*shapes.get(3).draw(g);
		shapes.get(shapes.size()-1).draw(g);
		shapes.remove(1);
		shapes.get(1).draw(g);
		shapes.get(3).draw(g);
		shapes.add(3, new Line(new Point(50,50), new Point(30,30)));*/
		
		//VEZBE 8 Zadatak 4
		/*Iterator<Shape> it=shapes.iterator();
		while(it.hasNext()) {
			Shape shape = it.next();
			shape.setSelected(true);;
			shape.draw(g);
		}*/

	
		Iterator<Shape> it=shapes.iterator();
		while(it.hasNext()) {
			it.next().draw(g);
		}
		
	}
}
