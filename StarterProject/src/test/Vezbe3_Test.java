package test;

import geometry.*;

public class Vezbe3_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// - napraviti tacku p = (10, 10) pozivom konstruktora Point(int x, int y)
		// - napraviti tacku p1 = (20, 20) pozivom konstruktora Point(), vrednosti x i y dodeliti pozivom set metoda
		// - napraviti liniju l1 pozivom podrazumevanog konstruktora
		Point p = new Point(10, 10);
		Point p1 = new Point();
		p1.setX(20);
		p1.setY(20);
		Line l1 = new Line();
		

		// 1. Inicijalizovati x koordinatu tacke p na vrednost y koordinate tacke p1 
		
		p.setX(p1.getY());
		p.print();

		// 2. Postaviti za pocetnu tacku linije l1 tacku p, a za krajnju tacku linije l1 tacku p1
		
		l1.setStartPoint(p);
		l1.setEndPoint(p1);

		// 3. Postaviti y koordinatu krajnje tacke l1 na 23
		
		l1.getEndPoint().setY(23);

		// 4. Inicijalizovati x koordinatu pocetne tacke linije l1 
		//na vrednost y koordinate krajnje tacke linije l1
		
		l1.getStartPoint().setX(l1.getEndPoint().getY());

		//TODO:
		// 5. Postaviti x koordinatu krajnje tacke l1 na vrednost
		// duzine linije l1 umanjene za vrednost zbira x i y
		// koordinate pocetne tacke linije l1

	
		// - napraviti pravouganik r1 pozivom podrazumevanog konstruktora
		// - napraviti krug c1 pozivom podrazumevanog konstruktora

		// 6. Postaviti x koordinatu tacke gore levo pravougaonika
		// r1 na vrednost 10 i y koordinatu na vrednost 15


		// 7. Postaviti centar kruga c1 na koordinate tacke
		// gore levo od r1


		// 8. Postaviti x koordinatu centra kruga c1 na vrednost razlike
		// povrsine pravougaonika r1 i y koordinate pocetne tacke linije l1

	}

}
