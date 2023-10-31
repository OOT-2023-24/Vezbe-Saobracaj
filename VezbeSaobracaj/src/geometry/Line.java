package geometry;

public class Line {

	private Point startPoint;
	private Point endPoint;
	private boolean selected;
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint,endPoint);
		this.selected = selected;
	}
	
	@Override
	public String toString() {
		return "(" + this.startPoint.getX() + "," + this.getStartPoint().getY()+")" + 
				"--> (" + this.endPoint.getX() + "," + this.getEndPoint().getY() + ")";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Line) {
			Line temp = (Line)o;
			if(this.getStartPoint().equals(temp.getStartPoint()) &&
					this.getEndPoint().equals(temp.getEndPoint())) {
				return true;
			}
		}
		return false;
	}
	
	public double length() {
		return startPoint.distance(endPoint);
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	
	public Point getEndPoint() {
		return endPoint;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
