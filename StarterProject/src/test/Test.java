package test;
import geometry.Point;
import geometry.Line;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 3;
		double b = 0.98;
		
		int c = 4;
		c = (int)b;
		
		String s = "1";
		int d = Integer.parseInt(s);
		
		boolean trueBool = true;
		boolean falseBool = false;
		
		System.out.println(trueBool && falseBool); //false 
		System.out.println(trueBool && !falseBool); //true
		System.out.println(trueBool || falseBool); //true
		System.out.println(trueBool ^ falseBool); //true
		
		//konkatenacija stringova
		String string1 = "ime ";
		String string2 = "prezime";
		System.out.println(string1+string2);
		
		/*objekat je instanca klase i ima sve osnobine i ponasanja koja su definisana u klasi
		modeluje objekat (entitet) realnog sistema
		predstavlja pojavu klase cijim je konstruktorom kreiran 
		objekat se instancira pozivom konstruktora klase (oprator new + poziv konstruktora)*/
		Point point = new Point(); 
		/*promenljiva point ukazuje na kreiran objekat, odnosno predstavlja referencu na objekat klase Point
		kada metodi za ispis prosledimo referencu dobijamo ispis
		<nazivPaketa>.<nazivKlase>@<hexAdresa>*/
		System.out.println(point); 

		/*direktan pristup atributu x promenljive point koja je tipa Point nije moguc jer atribut 
		x ove klase Point ima private specifikator pristupa*/
		//System.out.println(point.x);

		/*nakon instanciranja objekta, atributi primarnih tipova podataka kojima nije eksplicitno dodeljena vrednost
		implicitno dobijaju podrazumevane vrednosti za odgovarajuci tip podatka*/
		System.out.println(point.getX()); //podrazumevana vrednost za int je 0
		System.out.println(point.isSelected());// podrazumevana vrednost za boolean je false
		
		//get i set metode omogucavaju pristup privatnim atributima klase
		point.setX(10);
		System.out.println(point.getX());
		System.out.println("Instanciranje objekta point1:");
		Point point1 = new Point(10,10); 
		System.out.println(point1.getY());
		System.out.println("Instanciranje objekta point2:");
		Point point2 = new Point(20,20);
		
		double distance = point2.distance(point1);
		System.out.println(distance);
		
		System.out.println("********vezbe 2********");
		Point startPoint = new Point(10, 10);
		Point endPoint = new Point(20, 20);
		Line line = new Line(startPoint, endPoint);
		System.out.println(line);
		
		Point lineStartPoint = line.getStartPoint();
		int xlineStartPoint = lineStartPoint.getX();
		int ylineStartPoint = lineStartPoint.getY();
		System.out.println("(" + xlineStartPoint + ", " + ylineStartPoint + ")");
		System.out.println("(" + line.getStartPoint().getX() + ", " + line.getStartPoint().getY() + ")"); //(x , y)
			
		System.out.println(line.lenght());
	}

}
