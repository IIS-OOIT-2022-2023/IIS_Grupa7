package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{

	private Point startPoint;
	private Point endPoint;
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		//System.out.println(this);
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.setSelected(selected);
	}
	
	public Point getStartPoint() {
		return this.startPoint;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	public Point getEndPoint() {
		return this.endPoint;
	}
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	
	public double length() {
		//duzinu linije racunamo kao udaljenost endPoint tacke i startPoint tacke
		//koristimo distance metodu definisanu u Point klasi
		return this.startPoint.distance(this.endPoint);
	}
	
	public boolean contains(int x, int y) {
		return this.startPoint.distance(x, y) + this.endPoint.distance(x,y) - this.length() <= 2;
	}
	
	public boolean contains(Point click) {
		return this.startPoint.distance(click) + this.endPoint.distance(click) - this.length() <= 2;
	}
	
	public void draw(Graphics g) {
		g.drawLine(this.startPoint.getX(), this.startPoint.getY(), this.endPoint.getX(), this.endPoint.getY());
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(startPoint.getX()-2, startPoint.getY()-2, 4, 4);
			g.drawRect(endPoint.getX()-2, endPoint.getY()-2, 4, 4);
			g.setColor(Color.black);
		}

	}
	
	@Override
	public String toString() {
		//return "("+this.startPoint.getX()+","+this.startPoint.getY()+")"+"--> ("+this.endPoint.getX()+","+this.endPoint.getY()+")";
		return this.startPoint + "-->" + this.endPoint;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line l = (Line)obj;
			return (this.getStartPoint().equals(l.getStartPoint()) && this.getEndPoint().equals(l.getEndPoint()));
		}else {
			return false;
		}
	}

	@Override
	public void moveTo(int x, int y) {
		this.startPoint.moveTo(x, y);
		this.endPoint.moveTo(x, y);
	}
	@Override
	public void moveBy(int byX, int byY) {
		this.startPoint.moveBy(byX, byY); 

		this.endPoint.moveBy(byX, byY);
	}
	@Override
	public int compareTo(Object o) {
		if(o instanceof Line) {
			return (int)(this.length()-((Line)o).length());
		}
		return 0;

	}
}
