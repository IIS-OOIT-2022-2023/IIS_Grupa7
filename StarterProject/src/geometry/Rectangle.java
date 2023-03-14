package geometry;

public class Rectangle {
	private Point upperLeftPoint;
	private int height;
	private int width;
	private boolean selected;

	public Rectangle () {
		 this.upperLeftPoint = new Point();
	}

	public Rectangle(Point upperLeftPoint, int height, int width)  {
		this.upperLeftPoint = upperLeftPoint;
		this.height = height;
		this.width = width;
	}

	public double area() {
		return (this.height * this.width);
	}

	public double circumference() {
		return 2*(this.height + this.width);
	}

	public Point getUpperLeftPoint() {
		return this.upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public boolean isSelected() {
		return this.selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
