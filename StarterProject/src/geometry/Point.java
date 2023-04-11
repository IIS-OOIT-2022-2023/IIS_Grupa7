package geometry;

import java.awt.Color;
import java.awt.Graphics;

/*klasa u Java programu jedinstveno odredjena specifikacijom koja sadrzi
naziv paketa i naziv kalse geometry.Point

klasa - koncept o-o programskih jezika putem kojeg se modeluje klasa objekata realnog sistema
modeluje stanja i ponasanja objekata koji pripadaju datoj klasi objekata realnog sistema
sablon za kreiranje objekata
slozen tip podatka
*/
public class Point extends Shape {

	/*atributi klase - modeluju stanje objekata
	inkapsulacija - skrivanje sadrzaja klase (od drugih klasa), ostvaruje se putem specifikatora pristupa
	specifikatori pristupa: private, protected, public*/
	private int x;
	private int y;
	/**
	 * Staticka polja koriste se da cuvaju vrednosti nekog obelezja koje je zajednicko za sve objekte
	 * te klase. Statickim metodama koja nisu javna pristupa se koriscenjem staickih metoda pristupa.
	 */
	private static int maxX  = 500;
	
	public static int getMaxX() {
		return maxX;
	}
	
	
	/*konstruktor - posebna metoda klase koja sluzi za instanciranje objekata
	poziv konstruktora vrsi kreiranje objekta na heap-u
	naziv konstruktora mora biti isti kao naziv klase u kojoj je definisan
	konstruktor nema specifiran tip povratne vrednosti (ni void)*/
	/*Point*/
	public Point() {
		System.out.println("Ovo je poziv konstruktora");
	}
	
	/*overloading - preklapanje naziva metoda, pridruzivanje istog naziva razlicitim metodama
	- metode se razlikuju po POTPISU
	POTPIS METODE = naziv + niz tipova podataka koji su pridruzeni parametrima metode
	- preklopljene metode moraju se razlikovati ili po broju parametara ili 
	po redosledu tipova podataka koji su pridruzeni parametrima, tj. razlikuju se po potpisu
	*/
	public Point(int x, int y) {
		//System.out.println(this);
		this.x = x;
		this.y = y;
	}
	
	//this() - poziv konstruktora klase, MORA biti prva linija koda unutar konstruktora 
	public Point(int x, int y, boolean selected) {
		this(x, y);
		this.setSelected(selected);
	}
	
	public void print() {
		System.out.println("Koordinate tacke point su: x=" + this.x + ", y=" + this.y);
	}
	
	/*metode klase - modeluju ponasanje objekata
	get i set metode obezbedjuju pristup privatnim obelezjima klase*/
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		if(x > 0) {
			this.x = x;
		}else {
			System.out.println("Vrednosti x moraju da budu pozitivne");
		}
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	
	public double distance(Point point) {
		//dx dy -> dx*dx+dy*dy -> sqrt
		//System.out.println("Referenca na tacku koja je pozvala metodu: " + this + ", referenca tacke koja je parametar metode: "+ point);
		int dx = this.x - point.x;
		int dy = this.y - point.y;
		int sumOfSquares = dx*dx + dy*dy;
		double result = Math.sqrt(sumOfSquares);
		return result;
	}
	
	public double distance(int x, int y) {
		int dx = this.x - x;
		int dy = this.y - y;
		int sumOfSquares = dx*dx + dy*dy;
		double result = Math.sqrt(sumOfSquares);
		return result;
	}
	
	
	public boolean contains(int x, int y) {
		return this.distance(new Point(x, y)) <= 2;
	} 
	
	public boolean contains(Point click) {
		return this.distance(click) <= 2;
	}
	
	public void draw(Graphics g) {
		g.drawLine(this.x, this.y - 2, this.x, this.y + 2);
		g.drawLine(this.x - 2, this.y, this.x + 2, this.y);
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(x-2, y-2, 4, 4);
			g.setColor(Color.black);
		}

	}
	
	/*overriding - redefinisanje metoda 
	- toString i equals metode definisane su u klasi Object, redefinisemo ih za objekte klase Point
	*/
	@Override //anotacija u Javi, nije obavezna, ali je dobra praksa navoditi je kada se vrsi redefinisanje
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			//downcast - kastovanje objekta iz objekta natklase u objekat potklase
			Point pom = (Point) obj;
			return (this.x == pom.x && this.y == pom.y);
			
		}else {
			return false;
		}
	}
	
	/*
	 * Staticke metode se pozivaju nad klasom, nije potrebno kreirati objekat.
	 * */
	public static void staticMethod() {
		System.out.println("Ovo je staticka metoda");
	}


	@Override
	public void moveBy(int x, int y) {
		this.x += x;
		this.y += y;
		
	}


	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}


	@Override
	public int compareTo(Object o) {
		if(o instanceof Point) {
			double d1 = this.distance(new Point(0,0));
			double d2 = ((Point) o).distance(new Point(0,0));
			return (int)(d1 - d2);
		}
		return 0;
		
	}
	
	
}
