package geometry;

import java.awt.Graphics;

public class Line extends Shape {

	private Point startPoint;
	private Point endPoint;
	
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
	public void draw(Graphics g) {
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		
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
	
	public boolean contains(int x, int y) {
		if( length() - (startPoint.distance(new Point(x,y)) 
				+ endPoint.distance(new Point(x,y))) <= 3) {
			return true;
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
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	
}
