package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import geometry.Moveable;
import geometry.*;

public class Vezbe7i8_Test {

	public static void main(String[] args) {
		
		/*INTERFEJS
		 - mehanizam za postizanje potpune apstrakcije i "visestrukog nasledjivanja"
		 - ugovor o ponasanju objekata klase koja ga implementira (kako komunicirati sa objektom) 
		 - nemaju konstruktore i ne mogu se instancirati, ali se mogu deklarisati
		 promenljive tipa interfejsa
		*/
		
		/*deklaracija promenljive tipom interfejsa (za instanciranje se koristi konstruktor
		klase koja implementira interfejs):*/
		Moveable movePoint = new Point();
		
		/*KOLEKCIJE 
		- skladistenje vise podataka istog tipa u memoriji
		- mogu biti:
		STATICKE -> velicina kolekcije je fiksna i unapred poznata
		DINAMICKE -> dinamicki se alocira memorija, promenljiva velicina kolekcije
		*/

		/*NIZOVI
		- staticke kolekcije -> prilikom inicijalizacije potrebno je definisati duzinu niza
		i jednom definisana duzina se ne moze promeniti
		*/
		Point[] points = new Point[5];
		points[0] = new Point(40, 40);
		points[1] = new Point(20, 20);
		points[2] = new Point(10, 10);
		points[3] = new Point(50, 50);
		points[4] = new Point(30, 30);
		
		System.out.println("Ispis nesortiranog niza:");
		for(int i=0; i<points.length; i++) {
			System.out.println(points[i]);
		}
		
		
		/*SORTIRANJE KOLEKCIJE
		- Arrays klasa je Java klasa util paketa i poseduje STATICKU metodu sort koja sortira kolekciju
		- u kolekciji koja se sortira MORAJU da se nalaze podaci tipa koji MORA da implementira
		java Comparable interfejs, odnosno compareTo metodu
		- poziv sort metode u pozadini poziva compareTo metodu
		*/
		Arrays.sort(points);
		
		System.out.println("Ispis sortiranog niza:");
		for(int i=0; i<points.length; i++) {
			System.out.println(points[i]);
		}
		
		
		Point center = new Point(10,10);
		Circle circle = new Circle(center, 20);
		center.setX(50);
		System.out.println(circle.getCenter().getX());
		
		changeReferenceType(center);
		System.out.println(center.getY());
		
		changeValueType(center.getY());
		System.out.println(center.getY());
		
		
		//LISTE
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Point(10,10));
		shapes.add(new Line(new Point(20,20), new Point(30,30)));
		shapes.add(new Circle(new Point(50,50), 10));
		shapes.add(new Rectangle(new Point(40,40), 40, 40));
		
		Iterator<Shape> it = shapes.iterator();
		
		System.out.println("Lista pre brisanja");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		shapes.remove(1);
		Iterator<Shape> iter = shapes.iterator();
		
		System.out.println("Lista posle brisanja");
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		//HASH MAPE
		//Dinamicka kolekcija koja omogucava cuvanje uredjenih key-value parova
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("it17-2017", "Natalija");
		hashMap.put("it79-2022", "Nikola");
		
		System.out.println(hashMap.get("it17-2017"));
		System.out.println(hashMap.get("it17-2018"));
		
		hashMap.put("it17-2017", "Petar");
		System.out.println(hashMap.get("it17-2017"));
		
		hashMap.remove("it79-2022");
		System.out.println(hashMap.get("it79-2022"));
		
		//SWITCH
		
		String day = "5";
		
		switch(day) {
		case "1":
			System.out.println("Monday");
			break;
		case "2":
			System.out.println("Tuesday");
			break;
		case "3":
			System.out.println("Wednesday");
			break;
		case "4":
			System.out.println("Thursday");
			break;
		default:
			System.out.println("Default case");
		}
		
		//1, 3, 5, 7
		for(int i=0; i<10; i++) {
			if(i % 2 == 0)
				continue;
			System.out.println(i);
			if(i > 5)
				break;
		}
		
		/*IZUZECI
		IZUZETAK - mehanizam za upravljanje nepredvidjenim situacijama u vreme izvrsavanja
		programa 
		*/
		//Bez obrade izuzetaka:
		Shape[] shapesArray = new Shape[2];
		/*System.out.println(shapesArray[2]);
		System.out.println("Ispis nakon izuzetka");*/

		/*Obrada izuzetaka:
		TRY - kod koji potencijalno moze dovesti do izuzetka
		CATCH - "hvatanje" i obrada izuzetka ukoliko dodje do njega
		FINALLY - blok koda koji se uvek izvrsava
		*/
		
		try {
			Integer.parseInt("pet");
			System.out.println(shapesArray[2]);
		}catch(ArrayIndexOutOfBoundsException exc){
			System.out.println("Ne postoji element sa indeksom 2");
		}catch(NumberFormatException exc) {
			System.out.println("Ne mogu da pretvorim u int");
		}finally{
			System.out.println("Ja se uvek izvrsavam");
		}

		System.out.println("Ispis nakon izuzetka");

		//VEZBE 8 Zadatak 3
		Circle circle_exc = new Circle(new Point(50,50), 10);
		
		try {
			circle_exc.setRadius(-10);
		}catch(Exception ec) {
			System.out.println(ec.getMessage());
		}
		
		System.out.println("Ispis nakon Circle izuzetka");
			

	}
	
	public static void changeReferenceType(Point p) {
		p.setY(50);
	}
	
	public static void changeValueType(int y) {
		y = 10;
	}

}
