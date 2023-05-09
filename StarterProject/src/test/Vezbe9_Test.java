package test;

import geometry.Point;

public class Vezbe9_Test {

	public static void main(String[] args) {
		/*
		 * Vazni pojmovi:
		 * konstruktori
		 * specifikatori pristupa
		 * staticke i nestaticke metode
		 * metode pristupa
		 */
		Point point = new Point();
		point.print();
		Point.getMaxX();
		point.getX();
		point.setY(10);
	}
}
