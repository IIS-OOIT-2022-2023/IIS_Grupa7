package geometry;

import java.awt.Color;
import java.awt.Graphics;

/*nasledjivanje omogucava da se postojece klase koriste za kreiranje novih
nalsedjuju se svi atributi i metode koji nisu deklarisani kao private*/
public class Donut extends Circle {
	
	private int innerRadius;
	
	public Donut() {
		
	}
	
	/*super upucuje poziv roditeljskoj (nadklasi) klasi*/
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		//this.setCenter(center);
		//this.setRadius(radius);
		this.setSelected(selected);
	}
	
	public boolean contains(int x, int y) {
		double dFromCenter = this.getCenter().distance(x, y);
		return super.contains(x, y) && dFromCenter > this.innerRadius; 
	}

	public boolean contains(Point p) {
		double dFromCenter = this.getCenter().distance(p.getX(), p.getY());
		return super.contains(p.getX(), p.getY()) && dFromCenter > this.innerRadius;
	}
	
	public int getInnerRadius() {
		return innerRadius;
	}
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		g.drawOval(this.getCenter().getX() - this.innerRadius, this.getCenter().getY() - this.innerRadius, this.innerRadius * 2, this.innerRadius * 2);
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() + innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() - innerRadius - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() + innerRadius - 2, 4, 4);
			g.setColor(Color.black);
		}


	}
	
	/*super se moze iskoristiti kako bi se pristupilo public varijabli ili metodi nadklase*/
	@Override
	public String toString() {
		return super.toString() + ", innerRadius = " + this.innerRadius;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut d = (Donut) obj;
			//this.getCenter().equals(d.getCenter()) && this.getRadius() == d.getRadius() && this.innerRadius == d.innerRadius
			if(super.equals(d) && this.innerRadius == d.innerRadius) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Object o) {
		if (o instanceof Donut) {
			return (int) (this.area() - ((Donut) o).area());
		}
		return 0;
	}
}
