package geometry;

import java.awt.Graphics;

public class Donut extends Circle {

	private int innerRadius;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center,radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center,radius,innerRadius);
		super.setSelected(selected);
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawOval(getCenter().getX()-innerRadius, getCenter().getY()-innerRadius,
				innerRadius*2, innerRadius*2);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", inner radius: " + innerRadius;
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Donut) {
			Donut temp = (Donut) o;
			return (int) (area() - temp.area());
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Donut) {
			Donut temp = (Donut) o;
			if(getCenter().equals(temp.getCenter()) && getRadius() == temp.getRadius() &&
					innerRadius == temp.getInnerRadius()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return super.contains(x, y) && (getCenter().distance(new Point(x,y)) >= innerRadius);
	}
	
	@Override
	public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}
	
	@Override
	public double area() {
		return super.area() - Math.PI*innerRadius*innerRadius;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
//	public Donut(Circle c1, int innerRadius) {
//		this.setCenter(c1.getCenter());
//		this.setRadius(c1.getRadius());
//		this.innerRadius = innerRadius;
//	}
	
	
}
