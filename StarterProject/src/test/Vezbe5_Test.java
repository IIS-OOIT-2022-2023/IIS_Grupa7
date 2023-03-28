package test;

import geometry.*;

public class Vezbe5_Test {

	/*
	 * Main metoda je UVEK staticka jer u trenutku pokretanja programa
	 * u operativnoj memoriji ne postoji kreirat niti jedan objekat bilo
	 * koje klase. 
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Donut donut = new Donut();
		System.out.println(donut);
		/*
		 * Centar kreiranog donut-a nije null jer se u podrazumevanom konstruktoru klase Circle
		 * koju nasledjuje klasa Donut center inicijalizuje pozivom podrazumevanog konstruktora. 
		 * Prilikom kreiranja objekta klase Donut implicitno se poziva konstruktor natklase Circle.
		 * */
		System.out.println(donut.getCenter());
		System.out.println(donut.getRadius());
		
		Donut donut1 = new Donut(new Point(10,10), 10, 5);
		
		System.out.println(donut1.toString());
		
		Donut donut2 = new Donut(new Point(10,10), 10, 5);
		System.out.println(donut2);
		
		if(donut1.equals(donut2)) {
			System.out.println("donut1 i donut2 su isti po vrednosti");
		}
		if(donut1 == donut2) {
			System.out.println("donut1 i donut2 referenciraju isti objekat");
		}
		
		/*
		 * Referenca tipa Donut je instanca tipa svih klasa koje prosiruje
		 * U Javi ne postoji visestruko nasledjivanje, odnosno jedna klasa moze eksplicito da 
		 * nasledjuje samo jednu klasu.
		 * 
		 * Kada se nad objektom pozove metoda, interpeter ce traziti implementaciju metode u 
		 * klasi cijim konstruktorom je promenljiva inicijalizovana. Ukoliko u toj klasi ne pronadje
		 * implementaciju, trazice je u natklasi (u slucaju Donut klase to je Circle), i nastaviti trazenje
		 * u hijerarhiji natklasa (poslednja klasa u hijerarhiji natklasa je uvek klasa Object).
		 * Redosled trazenja implementacije metoda je od dna ka vrhu hijerarhije nasledjivanja.
		 * 
		 * Kada se kreira objekat klase, implicitno se pozivaju konstruktori svih natklasa.
		 * Implicitno se pozivaju podrazumevani konstruktori natklasa, ukoliko ih nema u natklasi,
		 * kompajler prijavljuje gresku. Prvo se poziva konstruktor klase na vrhu hijerarhije nasledjivanja, 
		 * u slucaju promenljive koja se instancira pozivom konstruktora Donut klase, najpre se poziva
		 * konstruktor klase Object, pa Circle i na kraju Donut.  
		 * Redosled izvrsavanja konstruktora je od vrha ka dnu hijerarnije nasledjivanja.
		 * 
		 * */
		if(donut1 instanceof Circle) {
			System.out.println("donut1 je instanca tipa Circle");
		}
		if(donut1 instanceof Donut) {
			System.out.println("donut1 je instanca tipa Donut");
		}
		if(donut1 instanceof Object) {
			System.out.println("donut1 je instanca tipa Object");
		}
		
		Point p = new Point();
		System.out.println(p.contains(0,0));
		Point.staticMethod();
	}
	

}
