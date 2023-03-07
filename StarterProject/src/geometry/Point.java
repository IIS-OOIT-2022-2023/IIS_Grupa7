package geometry;
/*klasa u Java programu jedinstveno odredjena specifikacijom koja sadrzi
naziv paketa i naziv kalse geometry.Point

klasa - koncept o-o programskih jezika putem kojeg se modeluje klasa objekata realnog sistema
modeluje stanja i ponasanja objekata koji pripadaju datoj klasi objekata realnog sistema
sablon za kreiranje objekata
slozen tip podatka
*/
public class Point {

	/*atributi klase - modeluju stanje objekata
	inkapsulacija - skrivanje sadrzaja klase (od drugih klasa), ostvaruje se putem specifikatora pristupa
	specifikatori pristupa: private, protected, public*/
	private int x;
	private int y;
	private boolean selected;
	
	
	/*konstruktor - posebna metoda klase koja sluzi za instanciranje objekata
	poziv konstruktora vrsi kreiranje objekta na heap-u
	naziv konstruktora mora biti isti kao naziv klase u kojoj je definisan
	konstruktor nema specifiran tip povratne vrednosti (ni void)*/
	public Point() {
		System.out.println("Ovo je poziv konstruktora");
	}
	
	public Point(int x, int y) {
		System.out.println(this);
		this.x = x;
		this.y = y;
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
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public boolean isSelected() {
		return this.selected;
	}
	
	public double distance(Point point) {
		//dx dy -> dx*dx+dy*dy -> sqrt
		System.out.println("Referenca na tacku koja je pozvala metodu: " + this + ", referenca tacke koja je parametar metode: "+ point);
		int dx = this.x - point.x;
		int dy = this.y - point.y;
		int sumOfSquares = dx*dx + dy*dy;
		double result = Math.sqrt(sumOfSquares);
		return result;
	}
	
}
