package geometry;

import java.awt.Graphics;

public abstract class Shape implements Moveable, Comparable{

	/*NAPOMENA:
	Kada klasa (npr. Point) prosiruje (nasledjuje) neku klasu (npr. Shape),
	postupak kreiranja objekta izvedene klase podrazumeva lanac izvrsavanja konstruktora,
	pocevsi od klase koja je poslednja u nizu izvodjenja (1. Object -> 2. Shape -> 3. Point)
	Ukoliko se u konstruktorima izvedene klase ne navodi eksplicitno poziv super konstruktora,
	implicitno se poziva podrazumevani super()
	Do greske dolazi ukoliko nadklasa nema definisan podrazumevani konstruktor bez parametara,
	a ima definisane druge konstruktore (u ovom slucaju Java ne generise ugradjeni konstruktor bez parametara)
	*/
	
	private boolean selected;


	public Shape() {
		
	}
	
	public Shape(boolean selected) {
		this.selected = selected;
	}
	
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public boolean isSelected() {
		return this.selected;
	}
	
	public abstract boolean contains(int x, int y);
	public abstract void draw(Graphics g);
}
