package geometry;

public class Circle {
	private int radius;
	private Point center;
	private boolean selected;

	public Circle() {
		this.center = new Point();
	}

	public Circle(Point center, int radius) {
		this.radius = radius;
		this.center = center;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		this.selected = selected;
	}

	public double area() {
		return this.radius*this.radius*Math.PI;
	}

	public double circumference() {
		return 2*this.radius*Math.PI;
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

	public boolean isSelected() {
		return this.selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
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
