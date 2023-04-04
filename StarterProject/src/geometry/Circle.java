package geometry;

import java.awt.Graphics;

public class Circle extends Shape{
	private int radius;
	private Point center;

	public Circle() {
		this.center = new Point();
	}

	public Circle(Point center, int radius) {
		this.radius = radius;
		this.center = center;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		this.setSelected(selected);
	}

	public double area() {
		return this.radius*this.radius*Math.PI;
	}

	public double circumference() {
		return 2*this.radius*Math.PI;
	}
	
	public boolean contains(int x, int y) {
		return this.center.distance(x, y) <= this.radius;
	}
	
	public boolean contains(Point point) {
		return this.center.distance(point.getX(), point.getY()) <= this.radius;
	}

	public int getRadius() {
		return this.radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Point getCenter() {
		return this.center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
	
	public void draw(Graphics g) {
		g.drawOval(this.center.getX() - this.radius, this.center.getY() - this.radius, this.radius * 2, this.radius * 2);
	}
	
	@Override
	public String toString() {
		//Center = (x,y), radius = radius
		return "Center = " + this.center.toString() + ", radius = " + this.radius;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle c = (Circle)obj;
			return (this.getCenter().equals(c.getCenter()) && this.getRadius() == c.getRadius());
		}
		return false;
	}

}
