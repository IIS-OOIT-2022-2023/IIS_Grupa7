package test;

import geometry.*;

public class Vezbe4_Test {
	public static void main(String[] args) {
	
		
		Point point = new Point(10, 10, false);
		Line line = new Line(new Point(30,30), new Point(50,50), false);
		System.out.println(point); //kada se metodi println prosledi slozen tip, u pozadini se poziva toString metoda
		System.out.println(point.toString()); 
		
		/*
		 * Svi slozeni tipovi podataka (korisnicki definisane klase) prosiruju klasu Object,
		 * iz java.lang paketa. Klasa Object sadrzi podrazumevani konstruktor i 9 metoda koje se
		 * nasledjuju - medju njima su i metode equals i toString.
		 * Operator instanceof proverava da li je promenljiva sa leve strane operatora
		 * instanca tipa podatka sa desne strane. 
		 * Promenljiva tipa Point je ujedno instanca klase Point i klase Object buduci da prosiruje klasu Object 
		 * (kako je student istovremeno i student i osoba, tako je i promenljiva point i instanca tipa Point i tipa Object)
		 * */
		if(point instanceof Point) { //true
			System.out.println("Tacka point je instanca klase Point");
		}if(point instanceof Object) { //true
			System.out.println("Tacka point je instanca klase Object");
		}

		
		Point point1 = new Point(50, 50, false);
		Point point3 = point1;
		Point point2 = new Point(50, 50, false);
		
		/*operator == poredi reference, odnosno proverava da li dve reference ukazuju na istu fizicku strukturu
		 * podataka u memoriji, tj. da li ukazuju na isti objekat u memoriji. Operator new UVEK pravi u memoriji
		 * novi objekat.  
		*/
		if(point1 == point2) { //false
			System.out.println("point1 i point2 referenciraju isti objekat");
		}else {
			System.out.println("point1 i point2 ne referenciraju isti objekat");
		}
		
		if(point1 == point3) { //true
			System.out.println("point1 i point3 referenciraju isti objekat");
		}else {
			System.out.println("point1 i point3 ne referenciraju isti objekat");
		}
		
		/*Posto reference ponit1 i point3 ukazuju na isti objekat, menjanjem X koordinate objekta
		 * na koji ukazuje point1 referenca menja se isti objekat na koji ukazuje point3 referenca
		 * */
		/*point1.setX(10);
		System.out.println(point3.getX()); //10
		System.out.println(point2.getX()); //10
		*/
		
		/* equals metoda je definisana u Object klasi tako da poredi reference
		 * da bismo imali logiku uporedjivanja vrednosti koordinata tacaka, moramo da REDEFINISEMO metodu u klasi Point
		 * 
		 * kada se equals metoda pozove, implementacija metode se najpre trazi u Point klasi, 
		 * zatim u Object ukoliko ne postoji u Point klasi 
		 * (ukoliko je imamo redefinisanu u Point klasi, ova implementacija ce se izvrsiti)
		 * */
		if(point1.equals(point2)) {
			System.out.println("point1 i point2 su iste");
		}else {
			System.out.println("point1 i point2 nisu iste");
		}
		
		/* String u Javi predtsalja slozen tip podatka i predstavlja klasu.
		 * promenljivu tipa String mozemo inicijalizovati na dva nacina: 
		 * 1. koriscenjem operatora =, kada se u memoriji ne pravi nov objekat ukoliko
		 * vec postoji prethodno kreiran string koji ima istu vrednost 
		 * (primer promenljivih e i f, obe promenljive ukazuju na isti objekat u memoriji)
		 * 2. eksplicitnim pozivom operatora new, kada se u memoriji UVEK pravi nov objekat 
		 * (primer promenljivih s1 i s2, promenljive ne ukazuju na isti objekat u memoriji) 
		 * 
		 * operator == uporedjuje reference, dok equals poredi stringove po vrednosti
		 * String je u Java immutable - nakon kreiranja njegova vrednost ne moze da se menja,
		 * odnosno ukoliko promenljivoj e dodelimo vrednost "abgcdefg", promenljiva e ce ukazivati
		 * na nov objekat, nece vrednost postojeceg objekta da se izmeni 
		 * (iz tog razloga treba izbegavati konkatenacije stringova u programima, vec koristiti za to
		 * klase kao sto je StringBuilder) 
		 * */
		System.out.println("*********************************");
		String e = "abcd"; // String je klasa
		String f = "abc"; // kreira se novi objekat 
		System.out.println(e == f);


		String g = "abc"; //referencira se postojeci objekat
		System.out.println(f == g); 

		String s1 = new String("Hello World");
		String s2 = new String("Hello World"); // kreira se novi objekat 
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2)); // poredjenje po vrednosti jer je redefinisana u klasi String

		
		
	}
}
