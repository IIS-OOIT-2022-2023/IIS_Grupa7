package geometry;

import java.awt.Color;
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

	public void setRadius(int radius) throws Exception{
		if(radius > 0) {
			this.radius = radius;
		}else {
			throw new Exception("Radius mora biti pozitivan");
		}
	}

	public Point getCenter() {
		return this.center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
	
	public void draw(Graphics g) {
		g.drawOval(this.center.getX() - this.radius, this.center.getY() - this.radius, this.radius * 2, this.radius * 2);
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() + radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - radius - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + radius - 2, 4, 4);
			g.setColor(Color.black);
		}

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

	@Override
	public void moveTo(int x, int y) {
		this.center.moveTo(x, y);
	}
	@Override
	public void moveBy(int byX, int byY) {
		this.center.moveBy(byX, byY);
	}
	@Override
	public int compareTo(Object o) {
		if (o instanceof Circle) {
			return (int) (this.area() - ((Circle) o).area());
		}
		return 0;

	}
}
