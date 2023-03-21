package geometry;

public class Line {

	private Point startPoint;
	private Point endPoint;
	private boolean selected;
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		System.out.println(this);
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
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
	
	public boolean isSelected() {
		return this.selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public double lenght() {
		//duzinu linije racunamo kao udaljenost endPoint tacke i startPoint tacke
		//koristimo distance metodu definisanu u Point klasi
		return this.startPoint.distance(this.endPoint);
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
	
}
