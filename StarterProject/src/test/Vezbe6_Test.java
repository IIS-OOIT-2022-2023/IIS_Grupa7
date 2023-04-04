package test;
import geometry.*;

public class Vezbe6_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Circle c; //deklaracija promenljive tipa Circle, vrednost je null
		c = new Circle(); //inicijalizacija promenljive pozivom konstruktora
		
		/*Promenljivu mozemo deklarisati jednim tipom, a inicijalizovati
		 * bilo kojim tipom koji je podtip tipa kojim je promenljiva deklarisana.
		 * Obrnuto nije moguce, ne mozemo deklarisati promenljivu tipa Donut, 
		 * a inicijalizovati je pozivom konstruktora Circle.
		 * */
		Circle donut = new Donut();
		/*Donut donut = new Circle();
		Circle line = new Line();*/
		
		/*DINAMICKO (KASNO) POVEZIVANJE 
		- odnosi se na povezivanje naziva metode sa implementacijom 
		(desava se tek prilikom izvrsenja programa)
		- omogucava da se u vreme pisanja programa neka promenljiva deklarise jednim tipom
		dok se inicijalizacija vrsi pozivom konstruktora nekog drugog tipa 
		(neke klase koja je izvedena):
		*/
		Circle donut_impl = new Donut(new Point(10,10),10,15);
		System.out.println(donut.toString());
		/*
		 - kompajler posmatra kojim tipom je promenljiva deklarisana (Circle) 
		 i dozvoljava poziv metoda koje postoje u toj klasi 
		 (iz primera - u klasi Circle postoji metoda toString)
		 - interpreter prilikom izvrsenja programa posmatra kako je promenljiva inicijalizovana 
		 i izvrsice se  implementacija metode one klase kojom je promenljiva inicijalizovana 
		 (iz primera - toString metoda klase Donut)
		 */
		
		/* POLIMORFIZAM 
		 * Univerzalni koncept o-o paradigme 
		 - opsta karakteristika polimorfizma je da se ista promenljiva, 
		 objekat ili metoda ponasa razlicito u zavisnosti od uslova u kojima se referencira  
		 - u kontekstu o-o prog. predstavlja koncept koji omogucava da se ista operacija
		 (ponasanje/metoda) realizuje na drugaciji nacin (poly-vise, morf-oblika)
		 1. primer -> sposobnost objekata koji pripadaju razlicitim potklasama iste klase objekata
		 da realizuju ista svojstva i operacije na razlicite nacine (npr. metoda draw)
		 2. primer -> sposobnost da se jedna promenljiva moze koristiti kao referenca na objekte 
		 razlicitog tipa, sto ce uticati na izbor implementacije metode koja se poziva 
		 (npr. promenljiva deklarisana tipom Shape moze biti inicijalizovana pozivom konstruktora
		 bilo koje klase koja nasledjuje Shape)
		 */		
		
		
		/*APSTRAKTNA KLASA 
		 - pred interfejsa, predstavlja kocept za postizanje apstrakcije 
		 (proces skrivanja detalja implementacije)
		 - u apstraktnu klasu treba izdvojiti sve atribute i metode koje su zajednicke 
		 za sve klase koje nasleduju tu klasu
		 - nije moguce instancirati objekat apstraktne klase, cak i ako postoje definisani konstruktori
		 - moze posedovati konstruktore, koji konstruisu delove objekata njenih potklasa
		 - promenljiva moze biti deklarisana tipom apstraktne klase
		 - moze sadrzati apstraktne i neapstraktne metode
		 - ako poseduje abstract metodu, mora biti deklarisana kao apstraktna
		  - klase koje nasledjuju apstraktnu klasu moraju sadrzati implementaciju 
		  svih metoda koje su apstraktne 
		  (ako ih ne implementiraju, moraju biti definisane kao apstraktne)
		 */

		//Shape shape = new Shape(true);
		Shape point = new Point();
	}

}
